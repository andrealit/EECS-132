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
  
//  public LimitedInsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
//                                double actuarialValue, boolean hasActualLimit, double annualLimit, 
//                                boolean hasLifetimeLimit, double lifetimeLimit) {
//    
//  }
  
  /* METHODS */
  
  // A) setAnnualLimit sets whether policy has an annual limit, if so, what limit is
  public void setAnnualLimit(boolean hasAnnualLimit, double annualLimit) {
    this.hasAnnualLimit = hasAnnualLimit;
    if (this.hasAnnualLimit == true) {
      this.annualLimit = annualLimit;
    }
  }
  
  // B) hasAnnualLimit returns if policy has annual limit (true) or not (false)
  public boolean hasAnnualLimit() {
    return hasAnnualLimit;
  }
  
  // C) getAnnualLimit returns the annual limit for the policy. If policy has no annual limit, method returns non-positive value
  public double getAnnualLimit() {
    if (hasAnnualLimit == true) {
      return annualLimit;
    } else {
      return 0.0;
    }
  }
  
  // D) setLifetimeLimit returns whether policy has lifetime limit, if so, what it is
  public void setLifetimeLimit(boolean hasLifetimeLimit, double lifetimeLimit) {
    this.hasLifetimeLimit = hasLifetimeLimit;
    if (hasLifetimeLimit) {
      this.lifetimeLimit = lifetimeLimit;
    }
  }
  
  // E) hasLifetimeLimit returns if policy has lifetime limit (true) or not (false)
  public boolean hasLifetimeLimit() {
    return hasLifetimeLimit;
  }
  
  // F) getLifetimeLimit returns lifetime limit for the policy if there is one, else returns non-positive number
  public double getLifetimeLimit() {
    if (hasLifetimeLimit && lifetimeLimit > 0) {
      return lifetimeLimit;
    } else {
      return 0.0;
    }
  }
  
  // G) applyYearlyLimit if policy has a yearly limit and (claim + yeartime benefit) exceeds yearly limit, amount is reduced by excess
  public double applyAnnualLimit(double claim) {
    if (hasAnnualLimit() == true && (claim + getYearlyBenefit()) > getAnnualLimit()) {
      return claim - ((claim + getYearlyBenefit()) - getAnnualLimit());
    } else {
      return claim;
    }
  }
  
  // H) applyLifetimeLimit has a lifetime limit and this checks to see if the claim exceeds it and returns the largest claim
  public double applyLifetimeLimit(double claim) {
    if (hasLifetimeLimit() == true && (claim + getLifetimeBenefit()) > getLifetimeLimit()) {
      return claim - ((claim + getLifetimeBenefit()) - getLifetimeLimit());
    } else {
      return claim;
    }
  }
  
}
