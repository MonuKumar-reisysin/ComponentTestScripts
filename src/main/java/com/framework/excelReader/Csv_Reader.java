package com.framework.excelReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.Logger;

import com.force.service.ForceDelegate;
import com.framework.vo.CustomAppVO;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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