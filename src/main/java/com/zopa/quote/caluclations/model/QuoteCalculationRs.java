/**
 * 
 */
package com.zopa.quote.caluclations.model;

import java.math.BigInteger;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.StandardToStringStyle;

/**
 * @author venky
 *
 */
public class QuoteCalculationRs {

	private BigInteger loanAmount;
	private Double quote;
	private Double monthlyRepayment;
	private Double totalRepayment;
	
	public QuoteCalculationRs(BigInteger loanAmount, Double quote, Double monthlyRepayment, Double totalRepayment) {
		this.loanAmount=loanAmount;
		this.quote=quote;
		this.monthlyRepayment=monthlyRepayment;
		this.totalRepayment=totalRepayment;
	}
	
	public BigInteger getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigInteger loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getQuote() {
		return quote;
	}
	public void setQuote(Double quote) {
		this.quote = quote;
	}
	public Double getMonthlyRepayment() {
		return monthlyRepayment;
	}
	public void setMonthlyRepayment(Double monthlyRepayment) {
		this.monthlyRepayment = monthlyRepayment;
	}
	public Double getTotalRepayment() {
		return totalRepayment;
	}
	public void setTotalRepayment(Double totalRepayment) {
		this.totalRepayment = totalRepayment;
	}
	
	@Override
	public String toString() {
		
		StandardToStringStyle style = new StandardToStringStyle();
	    style.setFieldSeparator(", ");
	    style.setUseClassName(false);
	    style.setUseIdentityHashCode(false);

	    return new ReflectionToStringBuilder(this, style).toString();
	}
	
}
