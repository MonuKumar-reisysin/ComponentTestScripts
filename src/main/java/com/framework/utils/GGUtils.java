package com.framework.utils;

import com.force.service.ForceDelegate;
import com.framework.constant.IConstant;

public class GGUtils {

	public static ForceDelegate getForceDelegate() {
		return ForceDelegate.login(IConstant.ORG_NAME);
	}
	
	public static void main(String[] args) {
		

	}

}
