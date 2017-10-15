/**
 * 
 */
package com.zopa.quote.caluclations.api;

import java.math.BigInteger;
import java.util.List;

import com.zopa.quote.caluclations.model.Offer;
import com.zopa.quote.caluclations.model.QuoteCalculationRs;

/**
 * @author venky
 *
 */
public class QuoteCalculator implements IQuoteCalculatorAPI{

	
	
	public QuoteCalculationRs getQuote(Integer loanAmount, List<Offer> offers, Integer loanLength) {

		
		if (offers.stream().mapToDouble(offer -> offer.getCashAvailable()).sum() < loanAmount)
		{
			return null;
		}
		
		Double totalRepayment = calculateTotalToPay(loanAmount, offers);

		Double quote = (totalRepayment - loanAmount) / loanAmount;

		Double monthlyRepayment = loanAmount * (1 + quote) / loanLength;

		return new QuoteCalculationRs(BigInteger.valueOf(loanAmount),quote,monthlyRepayment,totalRepayment);
		
	}
	
	private  Double calculateTotalToPay(Integer loanAmount, List<Offer> offers)
	{
		Double borrowed = 0.0d;
		Double totalTopay = 0.0d;
		
		//List<Offer> sortedOffers = offers.stream().sorted((o1, o2)->o1.getRate().compareTo(o2.getRate())).collect(Collectors.toList());
		
		 offers.sort((o1, o2)->o1.getRate().compareTo(o2.getRate()));
		for(Offer o : offers) {
			Double amountToBorrow = loanAmount < borrowed + o.getCashAvailable() ? loanAmount - borrowed : o.getCashAvailable();
			
			totalTopay += amountToBorrow + (amountToBorrow * o.getRate());
			
			if ((borrowed += amountToBorrow) >= loanAmount)
			{
				break;
			}
			
			
		}

		return totalTopay;
	}

	
	
}
