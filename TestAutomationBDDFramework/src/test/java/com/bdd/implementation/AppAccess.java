package com.bdd.implementation;

import static com.bdd.utils.WebdriverUtils.getDriver;
import static com.bdd.variables.GlobalVariables.*;

public class AppAccess {
	public static void accessapplication(String string) {
		if(cdriver==null || cdriver.toString().contains("null")) {
			cdriver = getDriver(string);
		}
		openURL();
	}
	

	public static void openURL() {
		
		cdriver.get(baseUrl);
	}
}
