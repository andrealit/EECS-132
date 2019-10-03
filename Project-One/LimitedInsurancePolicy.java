// Andrea Tongsak
// EECS 132 Fall 2019
// Insurance company that focuses on processing, keeping track of policy information, 
// process claims, and determines yearly premiums.

import java.util.Scanner;

// LimitedInsurancePolicy class has all same methods as InsurancePolicy plus additional methods
public class LimitedInsurancePolicy extends InsurancePolicy {
  
  /* FIELDS */
  private boolean hasAnnualLimit = false;
  private double annualLimit = 0.0;
  private boolean hasLifetimeLimit = false;
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
  
  // processClaim: after computing benefit and claim, method does other stuff
  @Override 
  public double processClaim(double claim, Date date) {
    // must call super. to refer something from parent class
    // use get 
    return getYearlyBenefit();
  }
  
  // checks if policy has lifetime limit and returns no more than the difference between 
  // lifetime benefit and lifetime limit
  @Override 
  public double getExpectedTenYearBenefit() {
    if (hasLifetimeLimit() == true) {
      return getLifetimeBenefit() - getOutOfPocketLimit();
    } else {
      // check work
      return 0.0;
    }
  }
  
}
