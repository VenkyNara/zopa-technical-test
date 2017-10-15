package com.zopa.quote.caluclations.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.StandardToStringStyle;

/**
 * @author venky
 *
 */
public class Offer {
	
	private Double rate;
	private Double cashAvailable;
	
	public Offer() {
		
	}
	
	public Offer(Double rate, Double cashAvailable) {
		this.rate=rate;
		this.cashAvailable=cashAvailable;
	}
	
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getCashAvailable() {
		return cashAvailable;
	}
	public void setCashAvailable(Double cashAvailable) {
		this.cashAvailable = cashAvailable;
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
