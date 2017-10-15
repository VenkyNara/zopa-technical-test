/**
 * 
 */
package com.zopa.quote.caluclations.api;

import java.util.List;

import com.zopa.quote.caluclations.model.Offer;
import com.zopa.quote.caluclations.model.QuoteCalculationRs;

/**
 * @author venky
 *
 */
public interface IQuoteCalculatorAPI {
	QuoteCalculationRs getQuote(Integer loanAmount, List<Offer> offers,Integer loanLength);
}
