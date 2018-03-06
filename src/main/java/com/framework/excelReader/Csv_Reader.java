package com.framework.excelReader;

import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;




import com.opencsv.CSVReader;

public class Csv_Reader {
	
	public static final Logger logger  = Logger.getLogger(Excel_Reader.class.getName());
	
	public static void csvReader(){
	CSVReader reader = null;
	try{
		reader = new CSVReader(new FileReader("E:/FrameworkComponents-TestScripts/ComponentTestScripts/Input.csv"));
		String[] cell = reader.readNext();
		
		while((cell=reader.readNext())!=null){
			String keyword = cell[0];
		}
	}
    catch(IOException e){
    	e.printStackTrace();
    }

}
}