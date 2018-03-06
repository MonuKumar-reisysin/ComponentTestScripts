package com.framework.excelReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class ExcelUtils {

        		private static XSSFSheet ExcelWSheet;

        		private static XSSFWorkbook ExcelWBook;

        		private static XSSFCell Cell;

        		private static XSSFRow Row;
        		public static String incremental_counter;
        		static {
        			int counterValue = 0;
        			try {
        				BufferedReader br = null;
        				FileReader fr = null;
        				
						fr = new FileReader("E:/AutoCounter.txt");
						br = new BufferedReader(fr);
						String sCurrentLine;

						while ((sCurrentLine = br.readLine()) != null) {
							counterValue = Integer.valueOf(sCurrentLine);
						}
						br.close();
						fr.close();
						
						BufferedWriter bw = null;
						FileWriter fw = null;
						
						Integer pusToFile = counterValue + 1;
						fw = new FileWriter("E:/AutoCounter.txt");
						bw = new BufferedWriter(fw);
						bw.write(pusToFile+"");
						bw.close();
						fw.close();
						
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}catch (IOException e) {
						e.printStackTrace();
					}
        			incremental_counter = "_" + counterValue;
        			
        		}

    		//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    		public static void setExcelFile(String Path,String SheetName) throws Exception {

       			try {

           			// Open the Excel file
       				
					FileInputStream ExcelFile = new FileInputStream(Path);

					// Access the required test data sheet

					ExcelWBook = new XSSFWorkbook(ExcelFile);

					ExcelWSheet = ExcelWBook.getSheet(SheetName);
					
					} catch (Exception e){

						throw (e);

					}

			}

    		//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    	    public static String getCellData(int RowNum, int ColNum) throws Exception{

       			try{
          			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
          			String CellData = Cell.getStringCellValue();
          			return CellData;
          			}catch (Exception e){

						return"";

          			}

		    }

    		//This method is to write in the Excel cell, Row num and Col num are the parameters

    		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

       			try{

          			Row  = ExcelWSheet.getRow(RowNum);

          			System.out.println("Flag 1, setCellData");
					Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

					if (Cell == null) {

						Cell = Row.createCell(ColNum);

						Cell.setCellValue(Result);

						} else {

							Cell.setCellValue(Result);

						}

          // Constant variables Test Data path and Test Data file name
					System.out.println("Flag 2, setCellData");
          				FileOutputStream fileOut = new FileOutputStream("E://FrameworkComponents-TestScripts/ComponentTestScripts/src/main/java/com/ComponentTestScripts/data/TestData.xlsx");

          				ExcelWBook.write(fileOut);

          				fileOut.flush();

 						fileOut.close();

						}catch(Exception e){

							throw (e);

					}

				}

	}