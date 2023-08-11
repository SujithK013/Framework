package com.framework.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.pageObjects.LoginPage;

public class TC_Login_01 extends BaseClass {

	@Test
	public void loginTest() throws IOException, InterruptedException {

		driver.get(baseURL);
		logger.info("URL is opened");
		Thread.sleep(3000);
		LoginPage lp = new LoginPage(driver);
		lp.setUsrName(username);
		logger.info("Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickSubmit();
		logger.info("Clicked on Submit button");
		String ti = driver.getTitle();
		logger.info(ti);
		Thread.sleep(1000);

		if (driver.getTitle().equals(ti)) {
			Assert.assertTrue(true);
			logger.info("TC Passed");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("TC Failed");

		}

	}

}
