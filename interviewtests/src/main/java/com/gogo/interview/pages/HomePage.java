package com.gogo.interview.pages;

/**
 * @author cb-dinesh
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.gogo.interview.core.BasePage;
import com.gogo.interview.core.BaseTest;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "searchDropdownBox")
	private WebElement cateforyDropDown;
	
	@FindBy(xpath = "(//div[@id='nav-search-dropdown-card']//span)[1]")
	private WebElement categorySelectedText;
	
	@FindBy(id = "suggestions")
	private WebElement autoSuggestions;
	
	@FindBy(id = "twotabsearchtextbox") 
	private WebElement searchTextBox;
	
	@FindBy(xpath = "//span[@id='nav-search-submit-text']//following-sibling::input")
	private WebElement searchSubmitButton;
	
	
	public SearchResultsPage searchQuery(String query) {
		clearAndType(searchTextBox, query);
		searchSubmitButton.click();
		return new SearchResultsPage(driver);
	}
	
	public String chooseCategory(String category) {
		cateforyDropDown.click();
		selectValueFromDropDown(cateforyDropDown, "text", category);
		return getElementText(categorySelectedText);
	}
	
	public boolean isSearchBoxDisplayed() {
		return isElementPresentAndDisplayed(searchTextBox);
	}
	
	public boolean isAutoSuggestionDisplayed(String query) {
		clearAndType(searchTextBox, query);
		return isElementPresentAndDisplayed(autoSuggestions);
	}
}
