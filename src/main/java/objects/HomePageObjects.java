package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseobjects.base;

public class HomePageObjects extends base{

	
	
	@FindBy(xpath = "//img[@alt='My Store']")
	private WebElement HomePageLogo;
	
	@FindBy(xpath = "//a[@title='Women']")
	private WebElement WomenTab;
	
	@FindBy(xpath="(//a[@title='Dresses'])[2]")   ////*[@id=\"block_top_menu\"]/ul/li[2]/a
	private WebElement DressesTab;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement TShirtsTab;
		
	@FindBy(id="newsletter-input")
	private WebElement EmailTextBox;
	
	//alert alert-success
	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement ResMailBox;
	
	
	////span[text()='Women']
	@FindBy(xpath="//span[text()='Women']")
	private WebElement WomenNavTab;
	
	////div[@id='categories_block_left']//*[@class='title_block']
	@FindBy(xpath="//div[@id='categories_block_left']//*[@class='title_block']")
	private WebElement DressNavTab;
	
	//span[@class='cat-name']
	@FindBy(xpath="(//a[@class='product-name'])[2]")
	private WebElement TshirtNavTab;
	
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	
	public void getHomePageLogo() {
		 HomePageLogo.click();;
	}

	public WebElement ValidateWomenTab() {
		return WomenTab;
	}
	
	public WebElement getDressPage() {
		return DressesTab;
	}

	public WebElement ValidateTShirtsTab() {
		return TShirtsTab;
	}
	 
	public WebElement setEmailAdrees() {
		return EmailTextBox;
		}
	
	public WebElement RegEmail() {
		return ResMailBox;
		}
	
	public WebElement WomenTabPage() {
		
		return WomenNavTab;
	}
	public WebElement DressTabPage() {
		
		return DressNavTab;
	}
	public WebElement TshirtTabPage() {
		
		return TshirtNavTab;
	}
}
