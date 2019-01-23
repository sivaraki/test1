package test;

import java.sql.Driver;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Baseobjects.base;
import objects.HomePageObjects;

public class HomePageTest {

	
	HomePageObjects homePage;
	base bp;
	int val = new Random().nextInt(7000);
	
	public HomePageTest() {
		homePage = new HomePageObjects();
		bp = new base();
	}

	//1. Verify Tabs - Women, Dresses and T-shirt are displayed on Home Page.
	
	@Test
	public void VerifyWomensTab() {
		Assert.assertTrue(bp.isElementVisible(homePage.ValidateWomenTab()));
	}
	
	@Test
	public void VerifyDressedTab() {
		Assert.assertTrue(bp.isElementVisible(homePage.getDressPage()));
	}
	
	@Test
	public void VerifyTshirtTab() {
		Assert.assertTrue(bp.isElementVisible(homePage.ValidateTShirtsTab()));
	}
	
	//3. Verify Subscription message is displayed after entering valid e-mail in Newsletter follow up.
	
	@Test
	public void ValidateEmailReg() {
	bp.setText(homePage.setEmailAdrees(),"Siva"+val+"@gmail.com");
		Assert.assertTrue(bp.isElementVisible(homePage.RegEmail()));
	}
	
	//2. Verify Correspoding page been navigated on selecting these tabs
	
	@Test (groups = {"sanity"})
 	public void VerifyTabNavWomen() {
	homePage.ValidateWomenTab().click();
		Assert.assertTrue(homePage.WomenTabPage().isDisplayed());
	homePage.getHomePageLogo();
	}
	@Test (groups = {"smoke","sanity"})
	public void VerifyTabNavDressess() {
		homePage.getDressPage().click();
		//Dresses
		Assert.assertEquals(homePage.DressTabPage().getText(), "DRESSES");
		homePage.getHomePageLogo();
	}
	
	@Test
	public void VerifyTabNavTshirts() {
	homePage.ValidateTShirtsTab().click();
	String Tshirt = homePage.TshirtTabPage().getText();
	Assert.assertTrue(Tshirt.contains("T-shirts"));
	homePage.getHomePageLogo();
	}
		
	@BeforeMethod
	public void getHomePage() {
		homePage.getHomePageLogo();
	}
	

}
