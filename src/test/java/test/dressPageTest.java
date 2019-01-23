package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Baseobjects.base;
import objects.HomePageObjects;
import objects.dressPageObjects;

public class dressPageTest {


	HomePageObjects homePage;
	base bp;
	dressPageObjects dressPage;
	
	public	dressPageTest() {
		homePage = new HomePageObjects();
		bp = new base();
		dressPage = new dressPageObjects();
	}


	
	@Test(priority = 0)
	public void ValidateSizeLtab() {
		homePage.getDressPage().click();
		Assert.assertTrue(dressPage.ValidateSizeL());
		
		}
	
	
	@Test(priority = 2) 
	public void ValidateSizeMtab() {
		
		Assert.assertTrue(dressPage.ValidateSizeM());
		
		}
	
	
	@Test(priority = 4)
	public void ValidateSizeStab() {
		
		Assert.assertTrue(dressPage.ValidateSizeS());
		
		}
	
	
	@Test(priority = 3)
	public void ValidateProductCountMatch() {
		
		Assert.assertEquals(dressPage.getProductCountFromHeader(), dressPage.getProductCountfromPage());
		
	}
	
	
	
	
	
	@Test(priority = 1)
	public void VerifiFirstProduct() {
		
		dressPage.Mouseover(dressPage.FirstProduct());
		bp.elementFound(dressPage.FirstProduct());
		//dressPage.FirstProduct().click();
		Assert.assertTrue(dressPage.elementFound(dressPage.FirstProduct()));
		dressPage.Mouseover(dressPage.addToCart());
		Assert.assertTrue(dressPage.isElementVisible(dressPage.AlertMessage()));
	
	}
	
	
	
	@Test
	public void verifyDiscount() {
		homePage.getDressPage().click();
		dressPage.clickOnListView();
		List <WebElement> pro = dressPage.getProductDiscount();
		
		for( WebElement product : pro ) {
			
			if(dressPage.checkDiscountNoticeDisplayed(product)) {
				System.out.println("1");

			}else {
				continue;
			}
		}
		
		
	}
	
	
	
	
	@BeforeMethod
	public void getDressPage() {
		
		homePage.getHomePageLogo();
		homePage.getDressPage().click();
		
	}
	
		
	}
	
	
	
	

