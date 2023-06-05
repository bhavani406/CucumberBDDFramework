package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class FirefoxDriverManager implements FactoryInterface {
	private static final DriverManagerType FIREFOX = null;

	@Override
	public WebDriver createDriver() {
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.firefoxdriver().setup();

		return new FirefoxDriver(option);
	}

}
