package pageObject;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenHomePage {

	/* constants used across methods */
	static final String GitHubURL = "https://github.com/";
	static final String GIT = ".git";
	/* class variables used across methods */
	WebDriver driver = new FirefoxDriver();
    
	/*
	 * Open URL
	 */
	public void openURL() {
    	driver.get(GitHubURL);
    	driver.manage().window().maximize();
    }
	/*
	 * assert title
	 */
    public void assertTitle(String titleStr) {
    	Assert.assertTrue(driver.getTitle().contains(titleStr));
    } 
    /*
     * navigate to searchbox
     */
    public void navigateToSearchBox(String inputStr) {
    	// find serarch box
    	WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
    	Assert.assertEquals(searchBox.getAttribute("placeholder"), "Search GitHub");
    	searchBox.clear();
    	// assert input string value
    	searchBox.sendKeys(inputStr);
    	searchBox.sendKeys(Keys.RETURN);
    	
    	// wait for some times
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    /*
     * navigate to language detail page
     */
    public void navigateToLanguagesPage(String languageStr) {
    	// find the language hyper link
    	WebElement languageLink = driver.findElement(By.xpath("//ul[@class='filter-list small']/li[1]/a"));
    	// assert language background Color   TODO: 
//    	languageLink.click();
//    	String languageBackgroundColor = driver.findElement(By.xpath("//ul[@class='filter-list small']/li[1]/a")).getCssValue("background-color"); 
//    	String[] hexValue = languageBackgroundColor.replace("rgba(", "").replace(")", "").split(",");
//    	int hexValue1=Integer.parseInt(hexValue[0]);
//    	hexValue[1] = hexValue[1].trim();
//    	int hexValue2=Integer.parseInt(hexValue[1]);
//    	hexValue[2] = hexValue[2].trim();
//    	int hexValue3=Integer.parseInt(hexValue[2]);
//    	String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);    	
//    	Assert.assertEquals(actualColor, "#4078c0");
    
    	// click first result link
        WebElement firstResultLink = driver.findElement(By.xpath("//h3/a[@class='v-align-middle']"));
        String firstResultLinkText = firstResultLink.getText();
        firstResultLink.click();
        
        // wait for some times
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	// click clone or download button
        WebElement cloneOrDownloadBtn = driver.findElement(By.xpath("//span[text()='Clone or download']"));
        cloneOrDownloadBtn.click();
        
        //Verify clone button value 
        WebElement httpsXpath = driver.findElement(By.xpath("//div[@class='input-group js-zeroclipboard-container']/input"));
        String httpsActualText = httpsXpath.getAttribute("value");
        String httpsExpectedText = GitHubURL + firstResultLinkText + GIT;
        Assert.assertEquals(httpsActualText, httpsExpectedText);   
    }    
    /*
     * close driver
     */
    public void closeDriver() {
    	driver.close();
    }
}




