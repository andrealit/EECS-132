// Andrea Tongsak
// EECS 132 Fall 2019
// Insurance company that focuses on processing, keeping track of policy information, 
// process claims, and determines yearly premiums.

import java.util.Scanner;

// LimitedInsurancePolicy class has all same methods as InsurancePolicy plus additional methods
public class LimitedInsurancePolicy extends InsurancePolicy {
  
  /* FIELDS */
  
  // hasAnnualLimit is boolean initialized to false
  private boolean hasAnnualLimit = false;
  // annualLimit is double initialized to 0.0
  private double annualLimit = 0.0;
  // hasLifetimeLimit is boolean initialized to false
  private boolean hasLifetimeLimit = false;
  // lifetimeLimit is double initialized to 0.0
  private double lifetimeLimit = 0.0;
  
  /* CONSTRUCTORS */
  
  public LimitedInsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                                double actuarialValue, boolean hasAnnualLimit, double annualLimit, 
                                boolean hasLifetimeLimit, double lifetimeLimit) {
    super(policyNumber, expirationDate, copay, deductible, actuarialValue);
    this.hasAnnualLimit = hasAnnualLimit;
    this.annualLimit = annualLimit;
    this.hasLifetimeLimit = hasLifetimeLimit;
    this.lifetimeLimit = lifetimeLimit;
  }
  
  public LimitedInsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                                double actuarialValue, boolean hasAnnualLimit, double annualLimit, 
                                boolean hasOutOfPocketLimit, double outOfPocketLimit, boolean hasLifetimeLimit, 
                                double lifetimeLimit, double expectedTenYearBenefit, double profitMargin, 
                                InsurancePolicy supplementalInsurance) {
    super(policyNumber, expirationDate, copay, deductible, actuarialValue, hasAnnualLimit, annualLimit, 
          hasOutOfPocketLimit, outOfPocketLimit, hasLifetimeLimit, lifetimeLimit, expectedTenYearBenefit, profitMargin, 
          supplementalInsurance);
  }
  
  /* METHODS */
  
  // A) sets whether policy has an annual limit, if so, what limit is
  public void setAnnualLimit(boolean hasAnnualLimit, double annualLimit) {
    this.hasAnnualLimit = hasAnnualLimit;
    if (this.hasAnnualLimit == true) {
      this.annualLimit = annualLimit;
    }
  }
  
  // B) returns if policy has annual limit (true) or not (false)
  public boolean hasAnnualLimit() {
    return hasAnnualLimit;
  }
  
  // C) returns the annual limit for the policy. If policy has no annual limit, method returns non-positive value
  public double getAnnualLimit() {
    if (hasAnnualLimit == true) {
      return annualLimit;
    } else {
      return 0.0;
    }
  }
  
  // D) returns whether policy has lifetime limit, if so, what it is
  public void setLifetimeLimit(boolean hasLifetimeLimit, double lifetimeLimit) {
    this.hasLifetimeLimit = hasLifetimeLimit;
    if (hasLifetimeLimit) {
      this.lifetimeLimit = lifetimeLimit;
    }
  }
  
  // E) returns if policy has lifetime limit (true) or not (false)
  public boolean hasLifetimeLimit() {
    return hasLifetimeLimit;
  }
  
  // F) returns lifetime limit for the policy if there is one, else returns non-positive number
  public double getLifetimeLimit() {
    if (hasLifetimeLimit && lifetimeLimit > 0) {
      return lifetimeLimit;
    } else {
      return 0.0;
    }
  }
  
  // G) if policy has a yearly limit and (claim + yeartime benefit) exceeds yearly limit, amount is reduced by excess
  public double applyAnnualLimit(double claim) {
    if (hasAnnualLimit() == true && (claim + getYearlyBenefit()) > getAnnualLimit()) {
      return claim - ((claim + getYearlyBenefit()) - getAnnualLimit());
    } else {
      return claim;
    }
  }
  
  // H) has a lifetime limit and this checks to see if the claim exceeds it and returns the largest claim
  public double applyLifetimeLimit(double claim) {
    if (hasLifetimeLimit() == true && (claim + getLifetimeBenefit()) > getLifetimeLimit()) {
      return claim - ((claim + getLifetimeBenefit()) - getLifetimeLimit());
    } else {
      return claim;
    }
  }
  
  
  /* execute Claim Processing
   * 11) if benefit causes yearlyBenefit > annualLimit, applyAnnualLimit
   * 12) if benefit causes lifetimeBenefit > lifetimeLimit, applyLifetimeLimit
   * 13) the total amount the benefit was decreased in the first two steps is the additional out-of-pocket cost
   * 14) if there is a supplemental insurance policy, the additional out-of-pocket expenses are reduced by the supplemental insurance (use the appropriate method to do this)
   * 15) the amount the benefit was reduced is subtracted from both the yearly benefit and the lifetime benefit
   * 16) the additional out-of-pocket cost is added to the yearly out-of-pocket cost
   * the sum of the out-of-pocket cost and the additional out-of-pocket cost is returned
   * 
   * */
  @Override 
  public double processClaim(double claim, Date date) {
    // must call super to refer something from parent class
    super.processClaim(claim, date);
    
    // if yearly benefit is greater than annual, applyAnnualLimit
    if (this.getYearlyBenefit() > this.annualLimit) {
      this.applyAnnualLimit(claim);
    }
    
    // if lifetime benefit is greater than lifetime, applyLifetimeLimit
    if (this.getLifetimeBenefit() > this.lifetimeLimit) {
      this.applyLifetimeLimit(claim);
    }
    
    // sets a local variable to additional out-of-pocket-cost
    // the total amount the benefit decreased is the additional out-of-pocket-cost
    double outOfPocketCostExtra = claim - this.getBenefit();
    
    // additional out of pocket costs are reduced by supplemental (if exists) 
    if (this.getSupplementalInsurance() != null) {
      if (outOfPocketCostExtra - this.applySupplementalInsurance(claim, date) < 0) {
        outOfPocketCostExtra = 0;
        System.out.println("additional out of pocket cost: " + outOfPocketCostExtra);
      } else {
        outOfPocketCostExtra -= this.applySupplementalInsurance(claim, date);
        System.out.println("out of pocket cost: " + outOfPocketCostExtra);
      }
    }
    
    // the amount the benefit was reduced is subtracted from both yearlyBenefit 
    this.setYearlyBenefit(this.getYearlyBenefit() - (claim - this.getBenefit()));
    this.setLifetimeBenefit(this.getLifetimeBenefit() - (claim - this.getBenefit()));
    
    this.setDeductible(getOutOfPocketCost());
    
    // returns sum of outOfPocketCost and additional out-of-pocket
    return this.getDeductible() + outOfPocketCostExtra;
  }
  
  // if policy has lifetime limit, returns no more than the difference between lifetime benefit and lifetime limit
  @Override 
  public double getExpectedTenYearBenefit() {  
    super.getExpectedTenYearBenefit();
    
    if (hasLifetimeLimit() == true) { 
      if (getLifetimeBenefit() - getLifetimeLimit() < 0) {
        return 0.0;
      } else {
        return getLifetimeBenefit() - getLifetimeLimit();
      }
    } else {
      //return expectedTenYearBenefit;
      return 0.0;
    }
    
  }
  
}
