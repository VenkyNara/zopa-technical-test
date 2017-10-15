/**
 * 
 */
package com.zopa.quote.caluclations.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.zopa.quote.caluclations.model.Offer;

/**
 * @author venky
 *
 */
public class CSVParser {

	public static List<Offer> parseCSV(String csvFile) {

		CSVReader reader = null;
		List<Offer> offers = null;
		try {
			offers = new ArrayList<Offer>();
			reader = new CSVReader(new FileReader(csvFile));
			String[] line;
			int i=0;
			while ((line = reader.readNext()) != null) {
				if(i==0) {i++;continue;}
				offers.add(new Offer(Double.valueOf(line[1]), Double.valueOf(line[2])));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return offers;
	}

}
