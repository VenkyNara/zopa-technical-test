package com.zopa.quote.caluclations.client;

import java.util.List;

import com.zopa.quote.caluclations.api.IQuoteCalculatorAPI;
import com.zopa.quote.caluclations.api.QuoteCalculator;
import com.zopa.quote.caluclations.model.Offer;
import com.zopa.quote.caluclations.model.QuoteCalculationRs;
import com.zopa.quote.caluclations.utils.CSVParser;

/**
 * @author venky
 *
 */
public class Application {
	private static final Integer LOAN_LENGTH_MONTHS = 36;

	public static void main(String[] args) {
		if (args.length < 2) {
			throw new IllegalArgumentException("Pass Market data file path and specify the loan amount !!!");
		}

		String csvFile = args[0];
		Integer loanAmount = Integer.valueOf(args[1]);

		List<Offer> offers = CSVParser.parseCSV(csvFile);

		IQuoteCalculatorAPI caluclator = new QuoteCalculator();
		QuoteCalculationRs quoteCalculationRs = caluclator.getQuote(loanAmount, offers, LOAN_LENGTH_MONTHS);
		if (quoteCalculationRs != null) {
			System.out.println("Requested amount: " + quoteCalculationRs.getLoanAmount());
			System.out.println("Rate: " + quoteCalculationRs.getQuote() + "%");
			System.out.println("Monthly repayment: " + quoteCalculationRs.getMonthlyRepayment());
			System.out.println("Total repayment: " + quoteCalculationRs.getTotalRepayment());
		}

	}
}
