package com.ComponentTestScripts.utility;

import com.ComponentTestScripts.constant.IConstant;
import com.force.service.ForceDelegate;



public class GGUtils {
	
	public static ForceDelegate getForceDelegate() {
		return ForceDelegate.login(IConstant.ORG_NAME);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
