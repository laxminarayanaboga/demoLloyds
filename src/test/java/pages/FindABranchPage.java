package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindABranchPage extends BasePage {

	public final static String PAGE_TITLE = "Find your nearest branch | Service | Lloyds Bank";

	private @FindBy(id = "q") WebElement searchBox;

	private @FindBy(xpath = "//form[@id='search-form']//div[@class='Locator-buttons']//button") WebElement submit;

	private @FindBy(xpath = "//div[@class='ResultSummary']") WebElement resultSummary;

	private final String searchResultsXpath = "//ol[@class='ResultList']/li//a[@class='Teaser-titleLink']";

	private @FindAll(@FindBy(xpath = "//ol[@class='ResultList']/li//a[@class='Teaser-titleLink']")) List<WebElement> resultList;

	public String getPageTitle() {
		return this.driver.getTitle();
	}

	public void searchFor(String searchString) {
		this.wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(searchString);
		this.wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	}

	public void accessTheLastSearchResult() {
		this.wait.until(ExpectedConditions.visibilityOf(resultSummary));
		this.wait.until(
				ExpectedConditions.visibilityOfAllElements(this.driver.findElements(By.xpath(searchResultsXpath))));
		List<WebElement> searchResults = this.driver.findElements(By.xpath(searchResultsXpath));
		try {
			WebElement lastSearchResultElement = searchResults.get(searchResults.size() - 1);
			scrollToElement(lastSearchResultElement);
			lastSearchResultElement.click();
		} catch (ElementClickInterceptedException e) {
			if (searchResults.size() > 1) {
				WebElement lastSearchResultElement = searchResults.get(searchResults.size() - 1);
				scrollToElement(searchResults.get(searchResults.size() - 2));
				lastSearchResultElement.click();
			}
		}
	}

}
