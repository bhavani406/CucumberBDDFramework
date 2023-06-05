package Factory;

import org.openqa.selenium.WebDriver;


public class DriverFactory {

	public WebDriver createInstance(String browser) {
		WebDriver driver = null;
		BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

		switch (browserType) {

		case CHROME:
			driver = new ChromeDriverManager().createDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriverManager().createDriver();
			break;
		case EDGE:
			driver = new EdgeDriverManager().createDriver();
			break;
		case SAFARI:
			//driver = new SafariDriverManager().createDriver();
			break;
		case OPERA:
			//driver = new OperaDriverManager().createDriver();
			break;
		case IE:
			//driver = new ChromeDriverManager().createDriver();
			break;
		default:
			//throw new BrowserNotSupportedException(browser);
		}
		return driver;
	}

	public enum BrowserList {
		CHROME, FIREFOX, EDGE, SAFARI, OPERA, IE
	}
}


