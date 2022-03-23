package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BranchPage extends BasePage {

	private @FindBy(xpath = "//h1[@class='Hero-title']//span[@class='LocationName-geo']") WebElement branchName;

	private @FindBy(xpath = "//div[@class='Core']//div[@class='Core-desktopAddress']//address") WebElement branchAddress;

	private @FindAll(@FindBy(xpath = "//table[@class='c-hours-details']/tbody/tr//td[text()='Closed']/preceding-sibling::td")) List<WebElement> daysTheBranchIsClosed;

	public String getPageTitle() {
		return this.driver.getTitle();
	}

	public String getBranchName() {
		return this.wait.until(ExpectedConditions.visibilityOf(branchName)).getText();
	}

	public String getBranchAddress() {
		String address = this.wait.until(ExpectedConditions.visibilityOf(branchAddress)).getText();
		address = address.replaceAll("\n", " ");
		return address;
	}

	public List<String> getDaysTheBranchIsClosed() {
		List<String> days = new ArrayList<String>();
		daysTheBranchIsClosed.forEach(element -> {
			days.add(this.wait.until(ExpectedConditions.visibilityOf(element)).getText());
		});
		return days;
	}

}
