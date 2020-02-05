package common;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class Utility {
	
	/**
     * Utility method to return random array of Integers in a range of 0 to range
     */
    public int[] getRandomArray(int length, int numRange){
        int[] randoms = new int[length];
        for(int i=0; i<length; i++){
            randoms[i] = (int) (Math.random()*numRange);
        }
		return randoms;
    }

	public List<String[]> readCSV(String filename) throws IOException
	{
		//Reading CSV while skipping the headers
		CSVReader reader = new CSVReaderBuilder(new FileReader(filename)).withSkipLines(1).build();
		
		//storing CSV data
		List<String[]> records = new ArrayList<String[]>();
		
		records = reader.readAll();
		
		reader.close();
		
		return records;
				
	}
	
	public void writeCSV(String filename, List<String[]> records) throws IOException
	{
		char c = 0;
		CSVWriter writer = new CSVWriter(new FileWriter(filename),'\t',c,c,"\n");
		
		writer.writeAll(records);
		
		/*for(String[] record : records)
			writer.writeNext(record);*/
		writer.close();
	}
	
	public static void decimalFormat(int noOfDecimalPlaces,String number)
	{
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(noOfDecimalPlaces);
		df.setMaximumFractionDigits(noOfDecimalPlaces);
		//df.setMaximumIntegerDigits(5);
		System.out.println(df.format(Float.parseFloat(number)));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		decimalFormat(2,"10.7");
		decimalFormat(2,"10");
		decimalFormat(2,"10.123");
		decimalFormat(2,"10.0");
		decimalFormat(2,"0");
		decimalFormat(2,"12234343");
		
		/*String file = "/home/surya/Downloads/data.csv";
		
		Utility utility = new Utility();
		try {
			List<String[]> data = utility.readCSV(file);
			
			utility.writeCSV("/home/surya/write.csv", data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
