package UITests;

import org.testng.annotations.Test;
import pageObject.OpenHomePage;

@Test(enabled = true)
public class TestCloneButtonURL {
	
	/* constants for testing*/
	static final String SearchText = "webdriverIO";
	static final String NormalTitle = "GitHub";
	static final String HomePageTitle = "How people build software · GitHub";
	static final String SearchTitle = "Search";
	static final String LanguageText = "JavaScript";

	public void testCloneURL(){
		
		// initial new page
		OpenHomePage newPage = new OpenHomePage();
		// open page
		newPage.openURL();
		// verify page title
		newPage.assertTitle(HomePageTitle);
		// navigate to search box
		newPage.navigateToSearchBox(SearchText);
		// verify page title
		newPage.assertTitle(SearchTitle);
		// navigate to detail page
		newPage.navigateToLanguagesPage(LanguageText);
		// verify page title
		newPage.assertTitle(NormalTitle);
		// close page
		newPage.closeDriver();
    }
}