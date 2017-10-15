package com.zopa.quote.caluclations.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.zopa.quote.caluclations.model.Offer;
import com.zopa.quote.caluclations.utils.CSVParser;


/**
 * @author venky
 *
 */
public class ApplicationTests 
{
	@Test
	public void testCSVParser() {
		List<Offer> offers = CSVParser.parseCSV("/Users/venky/handson/zopa-technical-test/zopa-caluclations/data/MarketData.csv");
		
		offers.forEach(System.out::println);
		offers.sort((o1, o2)->o1.getRate().compareTo(o2.getRate()));
		System.out.println("After sort.....");
		offers.forEach(System.out::println);
	   Assert.assertNotNull(offers);
	} 

    
}
