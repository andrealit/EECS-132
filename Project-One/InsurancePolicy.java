// Andrea Tongsak
// EECS 132 Fall 2019
// Insurance company that focuses on processing, keeping track of policy information, 
// process claims, and determines yearly premiums.

import java.util.Scanner;

// An insurance policy that calculates the users needs
public class InsurancePolicy {
  
  /* FIELDS */
  
  // policyNumber is value initialized to empty string
  private String policyNumber = "";
  // copay is starting amount before policy, double initialized to 0.0
  private double copay = 0.0;
  // deductible is double initialized to 0.0
  private double deductible = 0.0;
  // amountApplied is double initialized to 0.0
  private double amountApplied = 0.0;
  // actuarialValue is double initialized to 0.0
  private double actuarialValue = 0.0;
  // hasOutOfPocketLimit is boolean initialized to false
  private boolean hasOutOfPocketLimit = false;
  // outOfPocketLimit is double initialized to 0.0
  private double outOfPocketLimit = 0.0;
  // yearlyOutOfPocketCost is double initialized to 0.0
  private double yearlyOutOfPocketCost = 0.0;
  
  // yearlyBenefit is double initialized to 0.0
  private double yearlyBenefit = 0.0;
  // lifetimeBenefit is double initialized to 0.0
  private double lifetimeBenefit = 0.0;
  // premium is double initialized to 0.0
  private double premium = 0.0;
  // profitMargin is double initialized to 0.0
  private double profitMargin = 0.0;
  // expectedTenYearBenefit is double initialized to 0.0
  private double expectedTenYearBenefit = 0.0;
  // claim is double initialized to 0.0
  private double claim = 0.0;
  
  // hasSupplementalInsurance is boolean initialized to false
  private boolean hasSupplementalInsurance = false;
  // supplementalInsurance is InsurancePolicy with null
  private InsurancePolicy supplementalInsurance = null;
  // expirationDate is of type Date class with null
  private Date expirationDate = null;
  
  // benefit is double initialized to 0.0
  private double benefit = 0.0;
  // outOfPocketCost is double initialized to 0.0
  private double outOfPocketCost = 0.0;

  
  /* CONSTRUCTORS */ 
  
  // A constructor for a less restricted, simple insurance policy 
  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                         double actuarialValue) {
    this.policyNumber = policyNumber;
    this.expirationDate = expirationDate;
    this.copay = copay;
    this.deductible = deductible;
    this.actuarialValue = actuarialValue;
  }
  
  // More complex constructor
  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, 
                         double actuarialValue, boolean hasOutOfPocketLimit, double outOfPocketLimit, 
                         double expectedTenYearBenefit, double profitMargin, 
                         InsurancePolicy supplementalInsurance) {
    this(policyNumber, expirationDate, copay, deductible, actuarialValue);
    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
    this.outOfPocketLimit = outOfPocketLimit;
    this.expectedTenYearBenefit = expectedTenYearBenefit;
    this.profitMargin = profitMargin;
    if (supplementalInsurance != null) {
      this.hasSupplementalInsurance = true;
    }
    this.supplementalInsurance = supplementalInsurance;
  }
 
  
  /* METHODS */
  
  // A) returns policy number
  public String getPolicyNumber() {
    return policyNumber;
  }
  
  // B) sets copay to user input
  public void setCopay(double copay) {
    this.copay = copay;
  }
  
  // C) returns copay 
  public double getCopay() {
    return copay;
  }
  
  // D) sets yearly deductible for policy
  public void setDeductible(double deductible) {
    this.deductible = deductible;
  }
  
  // E) returns deductible 
  public double getDeductible() {
    return deductible;
  }
  
  // F) returns the amount, applied so far to this year, to the deductible
  public double getAmountAppliedToDeductible() {
    return amountApplied;
  }
  
  // G) sets actuarial value (must be decimal percent)
  public void setActuarialValue(double actuarialValue) {
    this.actuarialValue = actuarialValue;
  }
  
  // H) returns actuarial value (the percent of claims the policy will cover)
  public double getActuarialValue() {
    return actuarialValue;
  }
  
  // I) checks to see if policy has pocket limit, and if so, sets it
  public void setOutOfPocketLimit(boolean hasOutOfPocketLimit, double outOfPocketLimit) {
    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
    if (this.hasOutOfPocketLimit) {
      this.outOfPocketLimit = outOfPocketLimit;
    }
  }
  
  // J) returns true if policy has out-of-pocket limit, false if it doesn't
  public boolean hasOutOfPocketLimit() {
    return hasOutOfPocketLimit;
  }
  
  // K) returns out-of-pocket limit. If no pocket limit, method returns a non-positive value.
  public double getOutOfPocketLimit() {
    if (hasOutOfPocketLimit && outOfPocketLimit > 0) {
      return outOfPocketLimit;
    } else {
      return 0.0;
    }
  }
  
  // EXTRA) sets yearlyBenefit
  public void setYearlyBenefit(double yearlyBenefit) {
    this.yearlyBenefit = yearlyBenefit;
  }
  
  // L) returns the amount this policy has paid so far this year
  public double getYearlyBenefit() {
    return yearlyBenefit;
  }
  
  // EXTRA) sets lifetimeBenefit
  public void setLifetimeBenefit(double lifetimeBenefit) {
    this.lifetimeBenefit = lifetimeBenefit;
  }
  
  // M) returns the amount the policy paid so far in total
  public double getLifetimeBenefit() {
    return lifetimeBenefit;
  }
  
  // N) adds a supplemental policy (also an InsurancePolicy) to the existing policy, and indicates that the current policy has a supplemental one.
  public void setSupplementalInsurance(InsurancePolicy policy) {
    hasSupplementalInsurance = true;
    this.supplementalInsurance = policy;
  }
  
  // O) returns supplementalInsurance
  public InsurancePolicy getSupplementalInsurance() {
    if (hasSupplementalInsurance) {
      return supplementalInsurance;
    } else {
      return null;
    }
  }
  
  // P) returns end date of policy
  public Date getExpirationDate() {
    return expirationDate;
  }
  
  // Q) returns the premium (the amount the policy holder must pay to buy the policy)
  public double getPremium() {
    return premium;
  }
  
  // R) sets the profit margin, a percentage of what the company wants to earn
  public void setProfitMargin(double profitMargin) {
    this.profitMargin = profitMargin;
  }
  
  // S) returns the profit margin for the policy
  public double getProfitMargin() {
    return profitMargin;
  }
  
  // EXTRA) sets the benefit
  public void setBenefit(double benefit) {
    this.benefit = benefit;
  }
  
  // EXTRA) gets the benefit
  public double getBenefit() {
    return benefit;
  }
  
  // EXTRA) sets the out of pocket cost
  public void setOutOfPocketCost(double outOfPocketCost) {
    this.outOfPocketCost = outOfPocketCost;
  }
  
  // EXTRA) gets the out of pocket cost
  public double getOutOfPocketCost() {
    return outOfPocketCost;
  }
  
  // T) returns the amount the policy expects to pay in 10 years
  public void setExpectedTenYearBenefit(double expectedTenYearBenefit) {
    this.expectedTenYearBenefit = expectedTenYearBenefit;
  }
  
  // U) returns the expected amount paid out by the policy
  public double getExpectedTenYearBenefit() {
    return expectedTenYearBenefit;
  }
  
  // V) returns the user claim minus copay
  public double applyCopay(double claim) {
    return claim -= copay;
  }
  
  // W) calculates the amount user must pay before the insurance policy pays a claim
  public double applyDeductible(double claim) {
    // checks if the amount applied to the deductible is less than deductible
    if (getAmountAppliedToDeductible() < getDeductible()) {
      // if difference results in negative
      if (claim - (getDeductible() - getAmountAppliedToDeductible()) < 0) {
        amountApplied = claim;
        claim = 0;
      } else {
        // takes difference between claim and deductible for new claim. 
        // amountApplied is from amount applied to deductible plus the difference between it and deductible
        claim = claim - (getDeductible() - getAmountAppliedToDeductible());
        amountApplied = getAmountAppliedToDeductible() + (getDeductible() - getAmountAppliedToDeductible());
      }
    }
    return claim;
  }
  
  // X) returns claim multiplied by actuarial value percent
  public double applyActuarialValue(double claim) {
    return claim * getActuarialValue();
  }
  
  // Y) returns the call of processClaim if policy has supplemental insurance, else returns claim
  public double applySupplementalInsurance(double claim, Date date){
    if (this.getSupplementalInsurance() != null){
      return this.getSupplementalInsurance().processClaim(claim, date);
    } else { 
      return claim;
    }
  }
  
  
  /* Claim Processing*/
  
  // Z) takes 2 inputs: amount claimed and date claimed, and returns the amount user must contribute
  public double processClaim(double claim, Date date) {
    
    // if date is after expiration date, returns claim
    if (this.getExpirationDate().compareTo(date) <= 0) {
      this.renewPolicy();
      this.premium();
      return claim;
    }
    
    double originalClaim = claim;
    // reduces by copay
    claim = this.applyCopay(claim);
    
    // reduces by deductible
    claim = this.applyDeductible(claim);
    
    // reduces by actuarial
    claim = this.applyActuarialValue(claim);
    
    // sets benefit to the reduced claim
    this.setBenefit(claim);
    
    // sets outOfPocketcost to current out of pocket cost
    this.setOutOfPocketCost(originalClaim - benefit);
    
    // reduces out of pocket cost by supplemental (if exists)
    if (hasSupplementalInsurance) {
      if (outOfPocketCost - this.applySupplementalInsurance(claim, date) < 0) {
        outOfPocketCost = 0;
      } else {
        outOfPocketCost -= this.applySupplementalInsurance(claim, date);
      }
    }
  
//   7) the out of pocket cost is reduced by the amount the sum exceeds the limit, and added to benefit
    if (hasOutOfPocketLimit && ((outOfPocketCost + yearlyOutOfPocketCost) > outOfPocketLimit)) {
      outOfPocketCost -= ((outOfPocketCost + yearlyOutOfPocketCost) - outOfPocketLimit);
      benefit += ((outOfPocketCost + yearlyOutOfPocketCost) - outOfPocketLimit);
    }
    
    yearlyBenefit += benefit;
    lifetimeBenefit += benefit;
    yearlyOutOfPocketCost += outOfPocketCost;
    return outOfPocketCost;
  }
  
  // AA) resets the amount applied to the deductible, the yearly benefit, and yearly out-of-pocket cost
  public void renewPolicy() {
    // expectedTenYearBenefit is adjusted adding yearly benefit to 90%
    expectedTenYearBenefit = getYearlyBenefit() + (.9 * (expectedTenYearBenefit));
    amountApplied = 0.0;
    yearlyBenefit = 0.0;
    yearlyOutOfPocketCost = 0.0;
    expirationDate = new Date(expirationDate.getDay(), expirationDate.getMonth(), (expirationDate.getYear() + 1));
  }
  
  // AB) returns premium
  public double premium() {
    this.premium = (0.1* getExpectedTenYearBenefit()) + (this.getProfitMargin() * (0.1 * this.getExpectedTenYearBenefit()));
    this.premium = premium;
    return premium;
  }
  
  // AC) returns sum of the premium of this policy and the premium of any supplemental insurance policies
  public double totalPremium() {
    if (hasSupplementalInsurance) {
      getSupplementalInsurance().premium();
      return getPremium() + getSupplementalInsurance().totalPremium();
    } else {
      return getPremium();
    }
  }
  
  // returns boolean and checks if insurance policies have the same policy number and same expiration date
  @Override 
  public boolean equals(Object otherPolicy) {
    InsurancePolicy comparePolicy = (InsurancePolicy)otherPolicy;
    
    if (this.getPolicyNumber().equals(comparePolicy.getPolicyNumber()) && this.getExpirationDate() == comparePolicy.getExpirationDate()) {
      return true;
    } else {
      return false;
    }
  }
  
  
}
