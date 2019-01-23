package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Baseobjects.base;

public class dressPageObjects extends base {

	@FindBy(xpath = "(//div[@class='layered_filter']//*[@class='checker'])[6]")
	private WebElement getSizeL;

	@FindBy(xpath = "(//div[@class='layered_filter']//*[@class='checker'])[5]")
	private WebElement getSizeM;

	@FindBy(xpath = "(//div[@class='layered_filter']//*[@class='checker'])[4]")
	private WebElement getSizeS;

	@FindBy(xpath = "//span[@class='heading-counter']")
	private WebElement getTextFromHeaders;

	@FindBys(@FindBy(xpath = "(//ul[@class='product_list grid row']/li)"))
	private List<WebElement> getProductCount;

	@FindBy(xpath = "(//ul[@class='product_list grid row']/li)[1]")
	private WebElement getFirstProduct;

	@FindBy(xpath = "(//span[text()='Add to cart'])[1]")
	private WebElement getFirstProductToAddtoCart;

	@FindBy(xpath = "(//*[@itemprop='name']//*[@class='product-name'])[1]")
	private WebElement getFirstProIMG; // created for productTest page to validate

	// *[@class='right-block-content row']
	// *[@id='center_column']/ul/li//div[@class='content_price']//span[@class='price-percent-reduction']
	

	// span[@title='Close window']
	@FindBy(xpath = "//span[@title='Close window']")
	private WebElement popUpAlertforAddtocart;

	@FindBy(xpath = "//*[@class='icon-th-list']")
	private WebElement listView;

	@FindBys(@FindBy(xpath = "//div[@class='product-container']/div"))
	private List<WebElement> getAllProducts;
	
	public dressPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public boolean ValidateSizeL() {

		return getSizeL.isDisplayed();

	}

	public boolean ValidateSizeM() {

		return getSizeM.isDisplayed();

	}

	public boolean ValidateSizeS() {

		return getSizeS.isDisplayed();

	}

	public int getProductCountFromHeader() {
		String txt = getTextFromHeaders.getText();
		String ar[] = txt.split(" ");
		String num = ar[2];
		int number = Integer.parseInt(num);
		return number;
	}

	public int getProductCountfromPage() {

		return getProductCount.size();

	}

	public void Mouseover(WebElement path) {
		Actions ac = new Actions(driver);
		ac.moveToElement(path).click().build().perform();

	}

	public WebElement FirstProduct() {

		return getFirstProduct;

	}

	public WebElement addToCart() {

		return getFirstProductToAddtoCart;
		

	}

	public WebElement AlertMessage() {

		return popUpAlertforAddtocart;
	}

	public WebElement getFirstPro() {

		return getFirstProIMG;
	}

	public void clickOnListView() {

		listView.click();
	}

	public List<WebElement> getProductDiscount() {
		return getAllProducts;

	}

	public String getDisountPrices(WebElement parent) {

		return parent.findElement(By.xpath(".//div[@class='content_price col-xs-5 col-md-12']//span[@class='price-percent-reduction']")).getText();

	}

	public boolean checkDiscountNoticeDisplayed(WebElement parent) {
		
		return elementFound(parent.findElement(By.xpath(".//span[@class='discount']")));
		
	}

}
