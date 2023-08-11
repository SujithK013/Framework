package com.framework.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.pageObjects.LoginPage;
import com.framework.utilitites.XLUtils;

public class TC_LoginDDT_02 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsrName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()== true){
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path = "C:/Users/HP/workspace/frameWork/src/test/java/com/framework/testData/LoginData.xlsx"; 
		
		int rowNum= XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rowNum][colCount];
		
		for(int i=1; i<=rowNum;i++){
			for(int j=0;j<colCount;j++){
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0
			}
		}
		return logindata;
	}

}
