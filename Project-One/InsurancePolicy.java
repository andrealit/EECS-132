// Andrea Tongsak
// EECS 132 Fall 2019
// Insurance company that focuses on processing, keeping track of policy information, 
// process claims, and determines yearly premiums.

import java.util.Scanner;

public class InsurancePolicy {
  
  /* FIELDS */
  
  private String policyNumber = "";
  private double copay = 0.0;
  private double deductible = 0.0;
  private double amountApplied = 0.0;
  private double actuarialValue = 0.0;
  private boolean hasOutOfPocketLimit = false;
  private double outOfPocketLimit = 0.0;
  private double yearlyBenefit = 0.0;
  private double lifetimeBenefit = 0.0;
//  private InsurancePolicy supplementalInsurance = 0.0;
//  private Date expirationDate;
  private double premium = 0.0;
  private double profitMargin = 0.0;
  private double expectedTenYearBenefit = 0.0;
  private double claim = 0.0;
  
  /* CONSTRUCTORS */ 
  
  
  /* METHODS */
  
  // A) getPolicyNumber returns policy number
  public String getPolicyNumber() {
    return policyNumber;
  }
  
  // B) setCopay sets copay to user input
  public void setCopay(double copay) {
    this.copay = copay;
  }
  
  // C) getCopay returns copay 
  public double getCopay() {
    return copay;
  }
  
  // D) setDeductible sets yearly deductible for policy
  public void setDeductible(double deductible) {
    this.deductible = deductible;
  }
  
  // E) getDeductible returns deductible 
  public double getDeductible() {
    return deductible;
  }
  
  // F) getAmountAppliedToDeductible returns the amount, applied so far to this year, to the deductible
  public double getAmountAppliedToDeductible() {
    return amountApplied;
  }
  
  // G) setActuarialValue sets actuarial value
  public void setActuarialValue(double actuarialValue) {
    this.actuarialValue = actuarialValue;
  }
  
  // H) getActuarialValue returns actuarial value (the percent of claims the policy will cover)
  public double getActuarialValue() {
    return actuarialValue;
  }
  
  // I) setOutOfPocketLimit checks to see if policy has pocket limit, and if so, sets it
  public void setOutOfPocketLimit(boolean hasOutOfPocketLimit, double outOfPocketLimit) {
    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
    if (this.hasOutOfPocketLimit) {
      this.outOfPocketLimit = outOfPocketLimit;
    }
  }
  
  // J) hasOutOfPocketLimit returns true if policy has out-of-pocket limit, false if it doesn't
  public boolean hasOutOfPocketLimit() {
    return hasOutOfPocketLimit;
  }
  
  // K) getOutOfPocketLimit returns out-of-pocket limit. If no pocket limit, method returns a non-positive value.
  public double getOutOfPocketLimit() {
    if (hasOutOfPocketLimit && outOfPocketLimit > 0) {
      return outOfPocketLimit;
    } else {
      return 0;
    }
  }
  
  // L) getYearlyBenefit returns the amount this policy has paid so far this year
  public double getYearlyBenefit() {
    return yearlyBenefit;
  }
  
  // M) getLifetimeBenefit returns the amount the policy paid so far in total
  public double getLifetimeBenefit() {
    return lifetimeBenefit;
  }
  
  // N) setSupplementalInsurance sets a supplemental insurance policy for the policy
//  public void setSupplementalInsurance(InsurancePolicy policy) {
//    
//  }
  
  // O) getSupplementalInsurance returns supplementalInsurance
//  public InsurancePolicy getSupplementalInsurance() {
//    return supplementalInsurance;
//  }
  
  // P) getExpirationDate returns end date of policy
//  public Date getExpirationDate() {
//    return expirationDate;
//  }
  
  // Q) getPremium returns the premium of the policy
  public double getPremium() {
    return premium;
  }
  
  // R) setProfitMargin sets the profit margin, a percentage of what the company wants to earn
  public void setProfitMargin(double profitMargin) {
    this.profitMargin = profitMargin;
  }
  
  // S) getProfitMargin returns the profit margin for the policy
  public double getProfitMargin() {
    return profitMargin;
  }
  
  // T) setExpectedTenYearBenefit returns the amount the policy expects to pay in 10 years
  public void setExpectedTenYearBenefit(double expectedBenefit) {
    this.expectedTenYearBenefit = expectedBenefit;
  }
  
  // U) getExpectedTenYearBenefit returns the expected amount paid out by the policy
  public double getExpectedTenYearBenefit() {
    return expectedTenYearBenefit;
  }
  
  // V) applyCopay returns the user claim minus copay
  public double applyCopay(double claim) {
    return claim -= copay;
  }
  
  // W) applyDeductible calculates the amount user must pay before the insurance policy pays a claim
  public double applyDeductible(double claim) {
    // checks if the amount applied to the deductible is less than total claim
    if (getAmountAppliedToDeductible() < getDeductible()) {
      // if difference results in negative
      if (claim - (getDeductible() - getAmountAppliedToDeductible()) < 0) {
        amountApplied = claim;
        claim = 0;
      } else {
        // takes difference between claim and deductible for new claim, get amountApplied from applied plus deductible, 
        claim = claim - (getDeductible() - getAmountAppliedToDeductible());
        amountApplied = getAmountAppliedToDeductible() + (getDeductible() - getAmountAppliedToDeductible());
      }
      return claim;
    }
      
  }
  
  // X) applyActuarialValue returns claim multiplied by actuarial value percent
  public double applyActuarialValue(double claim) {
    return claim = claim * getActuarialValue();
  }
  
  // Y) applySupplementalInsurance is called if policy has supplemental insurance, else returns claim
  public double applyYearlyLimit(double claim) {
    if(hasAnnualLimit()) {
      if() {
        
      }
    }
    return claim;
  }
  
  // Z)
  
  
}