package stepDefinitions;

import java.util.Arrays;

import org.junit.Assert;

import demo.uiFactory.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BranchPage;
import pages.FindABranchPage;
import pages.HomePage;

public class Steps {
	HomePage homePage = new HomePage();
	FindABranchPage findABranchPage = new FindABranchPage();
	BranchPage branchPage = new BranchPage();

	@Given("I access the Lloyds home page")
	public void i_access_the_lloyds_home_page() {
		homePage.initialize(WebDriverFactory.driver, WebDriverFactory.wait);
		homePage.gotoHomePage();
		Assert.assertEquals(HomePage.PAGE_TITLE, homePage.getPageTitle());
	}

	@When("I click on Branch Finder")
	public void i_click_on_branch_finder() {
		homePage.gotToBranchFinder();

	}

	@When("search for {string}")
	public void search_for(String searchString) {
		findABranchPage.initialize(WebDriverFactory.driver, WebDriverFactory.wait);
		Assert.assertEquals(FindABranchPage.PAGE_TITLE, findABranchPage.getPageTitle());
		findABranchPage.searchFor(searchString);
	}

	@When("access the last search result")
	public void access_the_last_search_result() {
		findABranchPage.accessTheLastSearchResult();
	}

	@Then("I should see branch page with {string}, {string}, {string}")
	public void i_should_see_branch_page_with(String branchName, String branchAddress, String daysTheBranchIsClosed) {
		branchPage.initialize(WebDriverFactory.driver, WebDriverFactory.wait);
		Assert.assertEquals(branchName, branchPage.getBranchName());
		Assert.assertEquals(branchAddress, branchPage.getBranchAddress());
		Assert.assertEquals(Arrays.asList(daysTheBranchIsClosed.split(",")), branchPage.getDaysTheBranchIsClosed());
	}

}
