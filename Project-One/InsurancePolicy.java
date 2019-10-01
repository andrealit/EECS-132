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
  private double yearlyOutOfPocketCost = 0.0;
  
  private double yearlyBenefit = 0.0;
  private double lifetimeBenefit = 0.0;
  private double premium = 0.0;
  private double profitMargin = 0.0;
  private double expectedTenYearBenefit = 0.0;
  private double claim = 0.0;
  
  private boolean hasSupplementalInsurance = false;
  private InsurancePolicy supplementalInsurance = null;
  private Date expirationDate = null;

  
  /* CONSTRUCTORS */ 
  
  // A less restricted, simple insurance policy 
//  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
//                         double actuarialValue) {
//    this.policyNumber = policyNumber;
//    this.expirationDate = expirationDate;
//    this.copay = copay;
//    this.deductible = deductible;
//    this.actuarialValue = actuarialValue;
//  }
  
  // More complex constructor
//  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
//                         double actuarialValue, boolean hasAnnualLimit, double annualLimit, 
//                         boolean hasOutOfPocketLimit, double outOfPocketLimit, boolean hasLifetimeLimit, 
//                         double lifetimeLimit, double expectedTenYearBenefit, double profitMargin, 
//                         InsurancePolicy supplementalInsurance) {
//    this(policyNumber, expirationDate, copay, deductible, actuarialValue);
//    this.hasAnnualLimit = hasAnnualLimit;
//    this.annualLimit = annualLimit;
//    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
//    this.outOfPocketLimit = outOfPocketLimit;
//    this.hasLifetimeLimit = hasLifetimeLimit;
//    this.lifetimeLimit = lifetimeLimit;
//    this.expectedTenYearBenefit = expectedTenYearBenefit;
//    this.profitMargin = profitMargin;
//    if (supplementalInsurance != null) {
//      this.hasSupplementalInsurance = true;
//    }
//    this.supplementalInsurance = supplementalInsurance;
//  }
  
 
  
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
      return 0.0;
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
  
  // N) setSupplementalInsurance adds a supplemental policy (also an InsurancePolicy) to the existing policy, and indicates that the current policy has a supplemental one.
  public void setSupplementalInsurance(InsurancePolicy policy) {
    hasSupplementalInsurance = true;
    this.supplementalInsurance = policy;
  }
  
  // O) getSupplementalInsurance returns supplementalInsurance
  public InsurancePolicy getSupplementalInsurance() {
    if (hasSupplementalInsurance) {
      return supplementalInsurance;
    } else {
      return null;
    }
  }
  
  // P) getExpirationDate returns end date of policy
  public Date getExpirationDate() {
    return expirationDate;
  }
  
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
    // checks if the amount applied to the deductible is less than deductible
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
    }
    return claim;
  }
  
  // X) applyActuarialValue returns claim multiplied by actuarial value percent
  public double applyActuarialValue(double claim) {
    return claim * getActuarialValue();
  }
  
  // Y) applySupplementalInsurance is called if policy has supplemental insurance, else returns claim
  public double applySupplementalInsurance(double claim, Date date){
    if (this.getSupplementalInsurance() != null){
      return this.getSupplementalInsurance().processClaim(claim, date);
    } else {
      return claim;
    }
  }
  
  /* Claim Processing
   * 1) if date is after expiration date, claim value is returned
   * 2) claim is reduced by copay
   * 3) claim is reduced by deductible
   * 4) claim is reduced by actuarial value
   * 5) reduced claim is now the benefit, and out-of-pocket = initial claim - benefit
   * 6) if supplemental policy exists, out-of-pocket - supplemental
   * 7) if out of pocket limit exists, and the (out-of-pocket + annual out-of-pocket) > out-of-pocket limit, the
   * out of pocket cost is reduced by the amount the sum exceeds the limit, and this amount is added to benefit
   * 8) the benefit is added to both the yearly benefit and the lifetime benefit
   * 9) out of pocket cost added to yearly out of pocket cost
   * 10) out of pocket cost is returned
   * 
   * */
  
  // Z) processClaim takes 2 inputs: amount claimed and date claimed, returning the amount user must contribute
  public double processClaim(double claim, Date date) {
    // if date is after expiration date, returns claim
    if (this.getExpirationDate().compareTo(date) <= 0) {
      this.renewPolicy();
      this.premium();
    } 
    
    double originalClaim = claim;
    // reduces by copay
    claim = this.applyCopay(claim);
    // reduces by deductible
    claim = this.applyDeductible(claim);
    // reduces by actuarial
    claim = this.applyActuarialValue(claim);
    // sets a local variable benefit to the reduced claim
    double benefit = claim;
    // sets a local variable to current out of pocket cost
    double outOfPocketCost = originalClaim - claim;
    
    // reduces out of pocket cost by supplemental (if exists)
    if (hasSupplementalInsurance) {
      if (outOfPocketCost - this.applySupplementalInsurance(claim, date) < 0) {
        outOfPocketCost = 0;
      } else {
        outOfPocketCost -= this.applySupplementalInsurance(claim, date);
      }
    }
  
//     7) if out of pocket limit exists, and the (out-of-pocket + annual out-of-pocket) > out-of-pocket limit, the
//     out of pocket cost is reduced by the amount the sum exceeds the limit, and this amount is added to benefit
    if (hasOutOfPocketLimit && ((outOfPocketCost + yearlyOutOfPocketCost) > outOfPocketLimit)) {
      outOfPocketCost -= ((outOfPocketCost + yearlyOutOfPocketCost) - outOfPocketLimit);
      benefit += ((outOfPocketCost + yearlyOutOfPocketCost) - outOfPocketLimit);
    }
    
    yearlyBenefit += benefit;
    lifetimeBenefit += benefit;
    yearlyOutOfPocketCost += outOfPocketCost;
    return outOfPocketCost;
  }
  
  // AA) renewPolicy gives the amount applied to the deductible, the yearly benefit, and out-of-pocket costs
  public void renewPolicy() {
    // expectedTenYearBenefit is adjusted adding yearly benefit to 90%
    expectedTenYearBenefit = yearlyBenefit + (.9 * (expectedTenYearBenefit));
    amountApplied = 0.0;
    yearlyBenefit = 0.0;
    yearlyOutOfPocketCost = 0.0;
    expirationDate = new Date(expirationDate.getDay(), expirationDate.getMonth(), expirationDate.getYear() + 1);
  }
  
  // AB) premium returns value x percent more than one tenth of expected ten year benefit. x is profit margin
  public double premium() {
    premium = ((.1 * getExpectedTenYearBenefit()) + (getProfitMargin() * (.1 * getExpectedTenYearBenefit())));
    return premium;
  }
  
  // AC) totalPremium returns sum of the premium of this policy and the premium of any supplemental insurance policies
  public double totalPremium() {
    if (hasSupplementalInsurance) {
      getSupplementalInsurance().premium();
      return getPremium() + getSupplementalInsurance().totalPremium();
    } else {
      return getPremium();
    }
  }
  
  
//  @Override 
//  // equals checks if insurance policies have the same policy number and same expiration date
//  public boolean equals(Object object) {
//    if (this.getPolicyNumber() == (String)object.getPolicyNumber() && this.getExpirationDate() == (Date)object.getExpirationDate()) {
//      return true;
//    } else {
//      return false;
//    }
//  }
  
  
  
}
