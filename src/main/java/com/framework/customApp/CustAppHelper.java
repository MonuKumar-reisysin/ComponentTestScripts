package com.framework.customApp;

import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.force.service.ForceDelegate;
import com.framework.vo.CustomAppVO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CustAppHelper {
	@SuppressWarnings({ "unchecked" })
	public static List<CustomAppVO> getCustomApps() {
		ForceDelegate gate = com.framework.utils.GGUtils.getForceDelegate();

		List<CustomAppVO> customapp = gate.queryMultiple("select.custom.app");
		return customapp;

	}
	
	public static void newCSVReader(){
		try {
			String path = "E:/FrameworkComponents-TestScripts/ComponentTestScripts/Input.csv";
			Reader reader = Files.newBufferedReader(java.nio.file.Paths.get(path));
			
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CustomAppVO.class).withIgnoreLeadingWhiteSpace(true).build();
			
			java.util.List<CustomAppVO> appVOs = csvToBean.parse();
			
			/*for(CustomAppVO appVO: appVOs) {

				System.out.println("GNT__Abbreviation__c :"+appVO.getGNT__Abbreviation__c());
				System.out.println("GNT__Active__c :"+appVO.getGNT__Abbreviation__c());
				
				//ForceDelegate gate = com.framework.utils.GGUtils.getForceDelegate();
				//gate.createMultiple("create.custom.app", appVOs);
				//gate.createSingle("create.custom.app", appVO);
			}*/
			
			ForceDelegate gate = com.framework.utils.GGUtils.getForceDelegate();
			gate.createMultiple("create.custom.app", appVOs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		getCustomApps();
		
		//csvReader();
		newCSVReader();
	}
	
	

}
