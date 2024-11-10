
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Random;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class majd {
	WebDriver driver = new ChromeDriver();

	String MyWebsiteUrl = "https://global.almosafer.com/en";
	Random rand = new Random();

	@BeforeTest
	public void mysetup() {

		driver.manage().window().maximize();
		driver.get(MyWebsiteUrl);

		WebElement ButtonforTheCurrancy = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));

		ButtonforTheCurrancy.click();
	}

	@Test(priority = 1, enabled = false)
	public void checkTheEnglishLangugeIsDefault() {

		String ActuallLanguge = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExPeCtedLanguge = "en";
		Assert.assertEquals(ActuallLanguge, ExPeCtedLanguge);
	}

	@Test(priority = 2, enabled = false)
	public void ChickTheDefaultCurrancyIsSAR() {

		// button[@data-testid='Header__CurrencySelector']

		String ActualCurrancy = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedCurrancy = "SAR";

		Assert.assertEquals(ActualCurrancy, ExpectedCurrancy);

	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumbers() {

		String ActualNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();

		String ExpectedNumber = "+966554400000";

		Assert.assertEquals(ActualNumber, ExpectedNumber);
	}

	@Test(priority = 4, enabled = false)
	public void CheckiQtafLogoTherInTheFoter() {
		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		boolean ActualResult = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		boolean EexpectedResult = true;

		Assert.assertEquals(ActualResult, EexpectedResult);

	}

	@Test(priority = 5, enabled = false)
	public void checkHotelTabIsNotSelected() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ExpectedValue = "false";
		String ActualValue = HotelTab.getAttribute("aria-selected");

		Assert.assertEquals(ActualValue, ExpectedValue);
	}

	@Test(priority = 6, enabled = false)
	public void ckeckDepatureDate() {

		int Today = LocalDate.now().getDayOfMonth();
		int Tomorro = LocalDate.now().plusDays(1).getDayOfMonth();
		int Dayaftertomorro = LocalDate.now().plusDays(2).getDayOfMonth();

		// System.out.println(Today );
		// System.out.println(Tomorro);
//	System.out.println(Dayaftertomorro);

		String ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		String ExpectedDepature = Integer.toString(Tomorro);

		Assert.assertEquals(ActualDepature, ExpectedDepature);

	}

	@Test(priority = 7, enabled = false)
	public void CheckReturnDate() {

		int Today = LocalDate.now().getDayOfMonth();
		int Tomorro = LocalDate.now().plusDays(1).getDayOfMonth();
		int Dayaftertomorro = LocalDate.now().plusDays(2).getDayOfMonth();

		String ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		String ExpectedDepature = Integer.toString(Dayaftertomorro);

		Assert.assertEquals(ActualDepature, ExpectedDepature);

	}

	@Test(priority = 8, enabled = false)
	// invocationCount = 5
	public void RandomlyCHangeThelanguage() throws InterruptedException {

		String[] EnglisgCitesName = { "jedda", "riyadh", "dubai" };
		String[] ArabicCitesName = { "جدة", "دبي" };
		int randomArabicCitesName = rand.nextInt(ArabicCitesName.length);
		int randomEnglishCitesName = rand.nextInt(EnglisgCitesName.length);

		String[] myWebsites = { "https://global.almosafer.com/en", "https://www.almosafer.com/ar" };
		int RandomIndex = rand.nextInt(myWebsites.length);
		driver.get(myWebsites[RandomIndex]);

		//

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		WebElement hotelsearshbar = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		if (driver.getCurrentUrl().equals("https://www.almosafer.com/ar")) {
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "ar";
			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
			hotelsearshbar.sendKeys(ArabicCitesName[randomArabicCitesName]);

		} else {
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "en";

			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
			hotelsearshbar.sendKeys(EnglisgCitesName[randomEnglishCitesName]);
		}

		Thread.sleep(2000);
		WebElement Citylist = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
		WebElement SelectNuomberOfVistor = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Citylist.findElements(By.tagName("li")).get(1).click();

		Select select = new Select(SelectNuomberOfVistor);
		int NuomberOfVistor = rand.nextInt(2);
		select.selectByIndex(NuomberOfVistor);

		WebElement SearshBotton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearshBotton.click();

		Thread.sleep(35000);

	}

	@Test(priority = 9, enabled = false)
	public void CheckThatThePageIsFuallyLodead() {
		WebElement serchResult = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		boolean ActualResult = serchResult.getText().contains("found") || serchResult.getText().contains("مكان");
		boolean expectedResult = true;
		Assert.assertEquals(ActualResult, expectedResult);
	}

	@Test(priority = 10)
	public void chechThesortOption() throws InterruptedException {
		driver.get("https://www.almosafer.com/ar/hotels/Dubai/21-11-2024/22-11-2024/2_adult?placeId=ChIJRcbZaklDXz4RYlEphFBu5r0&city=Dubai&sortBy=LOWEST_PRICE");
		Thread.sleep(20000);
		 WebElement sortoption =driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		 sortoption.click();
		 Thread.sleep(2000);
		WebElement container =driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[5]/div/div[2]"));
		
if( driver.getCurrentUrl().contains("en")) {
	List<WebElement>	priceList	  =     container.findElements(By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp.undefined.muiltr-18vmb2l"));

	int lowestPrice = Integer.parseInt(priceList.get(0).getText().replace("SAR ", ""));
	int HighestParice = Integer.parseInt(priceList.get(priceList.size() - 1).getText().replace("SAR ", ""));

			System.out.println(lowestPrice);
			System.out.println(HighestParice );
			boolean actualvalue=lowestPrice<HighestParice;
			boolean expectedvalue=true;
			Assert.assertEquals(actualvalue, expectedvalue);
			
}else {
	List<WebElement>	priceList	  =     container.findElements(By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp.undefined.muirtl-1l5b3qq"));

	int lowestPrice=Integer.parseInt(priceList.get(0).getText().replace("ر.س. ", ""));
	int HighestParice= Integer.parseInt(priceList.get(priceList.size()-1).getText().replace("ر.س. ", ""));

				System.out.println(lowestPrice);
				System.out.println(HighestParice );
				boolean actualvalue=lowestPrice<HighestParice;
				boolean expectedvalue=true;
				Assert.assertEquals(actualvalue, expectedvalue);
				

}







}}

