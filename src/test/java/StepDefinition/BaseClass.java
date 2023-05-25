package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public static Logger logger;

	public String getRandomEmail() {
		
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
