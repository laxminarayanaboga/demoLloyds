package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public final static String PAGE_TITLE = "Lloyds Bank - Personal Banking, Personal Finances & Bank Accounts";

	private @FindBy(xpath = "//h3[contains(text(),'Log on to Internet Banking')]") WebElement loginToInternetBanking;
	private @FindBy(xpath = "//ul[@class='top-header-right']//li/a[@data-tealium-narrative='Branch Finder']") WebElement branchFinder;

	public void gotoHomePage() {
		this.driver.get("https://www.lloydsbank.com/");
		this.wait.until(ExpectedConditions.visibilityOf(loginToInternetBanking));
	}

	public String getPageTitle() {
		return this.driver.getTitle();
	}

	public void gotToBranchFinder() {
		this.wait.until(ExpectedConditions.elementToBeClickable(branchFinder)).click();
	}

}
