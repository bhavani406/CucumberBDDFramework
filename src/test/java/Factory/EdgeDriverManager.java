package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class EdgeDriverManager implements FactoryInterface {

	private static final DriverManagerType EDGE = null;

	@Override
	public WebDriver createDriver() {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.edgedriver().setup();	
	
		return new EdgeDriver(option);
	}

}
