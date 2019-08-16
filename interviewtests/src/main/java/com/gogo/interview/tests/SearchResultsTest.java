package com.gogo.interview.tests;

/**
 * @author cb-dinesh
 *
 */

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gogo.interview.core.BaseTest;
import com.gogo.interview.pages.HomePage;
import com.gogo.interview.pages.SearchResultsPage;
import com.gogo.interview.tests.constants.TestConstants;

public class SearchResultsTest extends BaseTest {
	
	HomePage homePage;
	SearchResultsPage searchResultsPage;

	@Test
	public void verifySearchBox() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isSearchBoxDisplayed());
	}

	@Test
	public void verifySearchAutoSuggestion() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isAutoSuggestionDisplayed("data"));
	}

	@Test
	public void verifyCategorySelection() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		Assert.assertEquals("Books", homePage.chooseCategory("Books"));
	}

	@Test
	public void verifySearchResults() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
	}

	@Test
	public void verifyTitleOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		String title = searchResultsPage.verifyTitle(0);
		Assert.assertNotEquals(title, "", "Title not found - FAILED");
		logger.info("Title-" + title);
	}

	@Test
	public void verifyImageOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		Assert.assertTrue(searchResultsPage.verifyImage(0));
	}

	@Test
	public void verifyVersionsOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		List<String> versions = searchResultsPage.verifyBookVersionAndPrice(0);
		Assert.assertNotEquals(versions, "", "Versions not found - FAILED");
		for (String version : versions) {
			logger.info("Versions-" + version);
		}
	}
	
	@Test
	public void verifyAuthorOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		String author = searchResultsPage.verifyAuthor(0);
		Assert.assertNotEquals(author, "", "Author not found - FAILED");
		logger.info("Author-" + author);
	}
	
	@Test
	public void verifyBuyOptionsOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		String buyingOptions = searchResultsPage.verifyMoreBuyingOptions(0);
		Assert.assertNotEquals(buyingOptions, "", "Buying Options not found - FAILED");
		logger.info("Buying Options-" + buyingOptions);
	}
	
	@Test
	public void verifyPublishDateOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		String publishDate = searchResultsPage.verifyPublishedDate(0);
		Assert.assertNotEquals(publishDate, "", "Publish Date not found - FAILED");
		logger.info("Publish Date-" + publishDate);
	}
	
	@Test
	public void verifyStarRatingOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		String reviewStars = searchResultsPage.verifyReviewStars(0);
		Assert.assertNotEquals(reviewStars, "", "Rating stars not found - FAILED");
		logger.info("Star Rating-" + reviewStars);
	}
	
	@Test
	public void verifyReviewsOfBook() {
		driver.get(TestConstants.SITE_URL);
		homePage = new HomePage(driver);
		homePage.chooseCategory("Books");
		searchResultsPage = homePage.searchQuery("data");
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed());
		String reviews = searchResultsPage.verifyReview(0);
		Assert.assertNotEquals(reviews, "", "Review is empty - FAILED");
		logger.info("Review count-" + reviews);
	}

}
