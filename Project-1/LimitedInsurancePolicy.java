// Andrea Tongsak
// EECS 132 Fall 2019
// Insurance company that focuses on processing, keeping track of policy information, 
// process claims, and determines yearly premiums.

// LimitedInsurancePolicy is an insurance policy, but sets specific limits.
public class LimitedInsurancePolicy extends InsurancePolicy {
  
  /* FIELDS */
  
  // Stores whether the policy has an annual limit
  private boolean hasAnnualLimit = false;
  // Stores the annual limit for the policy
  private double annualLimit = 0.0;
  // Stores whether the policy has a lifetime limit
  private boolean hasLifetimeLimit = false;
  // Stores the lifetime limit for the policy
  private double lifetimeLimit = 0.0;
  
  /* CONSTRUCTORS */
  
  // A constructor to create the limited insurance policy with annual and lifetime limits
  public LimitedInsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                                double actuarialValue, boolean hasAnnualLimit, double annualLimit, 
                                boolean hasLifetimeLimit, double lifetimeLimit) {
    super(policyNumber, expirationDate, copay, deductible, actuarialValue);
    this.hasAnnualLimit = hasAnnualLimit;
    this.annualLimit = annualLimit;
    this.hasLifetimeLimit = hasLifetimeLimit;
    this.lifetimeLimit = lifetimeLimit;
  }
  
  // A constructor to create the limited insurance policy with supplemental policy, expected benefits, and profit.
  public LimitedInsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                                double actuarialValue, boolean hasAnnualLimit, double annualLimit, 
                                boolean hasOutOfPocketLimit, double outOfPocketLimit, boolean hasLifetimeLimit, 
                                double lifetimeLimit, double expectedTenYearBenefit, double profitMargin, 
                                InsurancePolicy supplementalInsurance) {
    super(policyNumber, expirationDate, copay, deductible, actuarialValue, hasOutOfPocketLimit, outOfPocketLimit, expectedTenYearBenefit, profitMargin, 
          supplementalInsurance);
    this.hasAnnualLimit = hasAnnualLimit;
    this.annualLimit = annualLimit;
    this.hasLifetimeLimit = hasLifetimeLimit;
    this.lifetimeLimit = lifetimeLimit;
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
    return this.hasAnnualLimit;
  }
  
  // C) returns the annual limit for the policy. If policy has no annual limit, method returns non-positive value
  public double getAnnualLimit() {
    if (hasAnnualLimit == true) {
      return this.annualLimit;
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
    return this.hasLifetimeLimit;
  }
  
  // F) returns lifetime limit for the policy if there is one, else returns non-positive number
  public double getLifetimeLimit() {
    if (hasLifetimeLimit && lifetimeLimit > 0) {
      return this.lifetimeLimit;
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
  
  // execute additional steps of Claim Processing, tailored to limited.
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
      } else {
        outOfPocketCostExtra -= this.applySupplementalInsurance(claim, date);
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
    // local variable expectedTenYearBenefit 
    double expectedTenYearBenefit = super.getExpectedTenYearBenefit();
    
    if (hasLifetimeLimit() == true) { 
      // if value is negative, return 0
      if (getLifetimeBenefit() - getLifetimeLimit() < 0) {
        return 0.0;
      } else {
        return this.getLifetimeBenefit() - this.getLifetimeLimit();
      }
    } else {
      return expectedTenYearBenefit;
    }
    
  }
  
}
