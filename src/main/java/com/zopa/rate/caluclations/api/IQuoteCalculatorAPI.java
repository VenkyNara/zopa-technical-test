/**
 * 
 */
package com.zopa.rate.caluclations.api;

import java.util.List;

import com.zopa.rate.caluclations.model.Offer;
import com.zopa.rate.caluclations.model.QuoteCalculationRs;

/**
 * @author venky
 *
 */
public interface IQuoteCalculatorAPI {
	QuoteCalculationRs getQuote(Integer loanAmount, List<Offer> offers,Integer loanLength);
}
