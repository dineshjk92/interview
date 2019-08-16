package com.gogo.interview.pages;

/**
 * @author cb-dinesh
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.gogo.interview.core.BasePage;

public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[contains(@class,'search-results')]")
	private WebElement searchResultsDiv;
	
	@FindBy(xpath = "//div[contains(@class,'search-results')]//div[@data-index]")
	private List<WebElement> searchResults;
	
	@FindBy(xpath = "//div[contains(@class,'search-results')]//div[@data-index]//span[contains(@class,'a-text-normal')]") 
	private List<WebElement> searchResultTitles;

	@FindBy(xpath = "//div[contains(@class,'search-results')]//div[@data-index]//img") 
	private List<WebElement> searchResultImages;
	
	public boolean isSearchResultsDisplayed() {
		return isElementPresentAndDisplayed(searchResultsDiv);
	}
	
	public String verifyTitle(int resultIndex) {
		return searchResultTitles.get(resultIndex).getText();
	}
	
	public boolean verifyImage(int resultIndex) {
		String title = searchResultTitles.get(resultIndex).getText();
		WebElement image = driver.findElement(By.xpath("//span[contains(text(),'" + title + "')]//ancestor::div[@data-index='0']//img"));
		return isElementPresentAndDisplayed(image);
	}
	
	public String verifyAuthor(int resultIndex) {
		String title = searchResultTitles.get(resultIndex).getText();
		WebElement authorName = driver.findElement(By.xpath("//span[contains(text(),'" + title + "')]//following::div[1]//a"));
		return getElementText(authorName);
	}
	
	public String verifyPublishedDate(int resultIndex) {
		String title = searchResultTitles.get(resultIndex).getText();
		WebElement publishedDate = driver.findElement(By.xpath("//span[contains(text(),'" + title + "')]//following::div[1]//span[5]"));
		return getElementText(publishedDate);
	}
	
	public String verifyReviewStars(int resultIndex) {
		String title = searchResultTitles.get(resultIndex).getText();
		WebElement reviewStars = driver.findElement(By.xpath("//span[contains(text(),'" + title + "')]//following::div[2]//span[@class='a-icon-alt']"));
		return getElementText(reviewStars);
	}
	
	public String verifyReview(int resultIndex) {
		String title = searchResultTitles.get(resultIndex).getText();
		WebElement review = driver.findElement(By.xpath("//span[contains(text(),'" + title + "')]//following::div[2]//span[@class='a-size-base']"));
		return getElementText(review);
	}
	
	public List<String> verifyBookVersionAndPrice(int resultIndex) {
		String title = searchResultTitles.get(resultIndex).getText();
		List<WebElement> bookVersions = driver.findElements(By.xpath("//span[contains(text(),'" + title + "')]//following::div[4]//div[@class='sg-col-inner']//child::div/a[@class='a-size-base a-link-normal a-text-bold']"));
		List<WebElement> bookVersionsPrices = driver.findElements(By.xpath("//span[contains(text(),'" + title + "')]//following::div[4]//div[@class='sg-col-inner']//child::div[2]//span[@class='a-price'and @data-a-color='base']//span[@class='a-offscreen']"));
		List<String> versionsAvailable = new ArrayList<String>();
		for(int i=0; i<bookVersions.size(); i++) {
			versionsAvailable.add(getElementText(bookVersions.get(i)) + " " + getElementText(bookVersionsPrices.get(i)));
		}
		return versionsAvailable;
	}
	
	public String verifyMoreBuyingOptions(int resultIndex) {
		String title = searchResultTitles.get(resultIndex).getText();
		WebElement moreOptionsPrice = driver.findElement(By.xpath("//span[contains(text(),'" + title + "')]//ancestor::div[@data-index]//following-sibling::span[@class='a-color-base']"));
		WebElement moreOptionsInfo = driver.findElement(By.xpath("//span[contains(text(),'" + title + "')]//ancestor::div[@data-index]//following-sibling::a[@class='a-link-normal']"));
		return getElementText(moreOptionsPrice) + " " + getElementText(moreOptionsInfo);
	}
	
	
	
	
}
