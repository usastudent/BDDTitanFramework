package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	/**
	 * This class will be parent of all other classes in this framework Here we will
	 * define the property of WebDriver interface, create methods for selecting the
	 * browser type we create methods to generate logs we create methods to read the
	 * data from config file
	 */

	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String configPath = ".\\src\\test\\resources\\input\\config.properties";
	// for mac ./src/test/resources/input/config.properties
	private String log4JPath = ".\\src\\test\\resources\\input\\log4j.properties";
	// for mac ./src/test/resources/input/log4j.properties

	// there are three steps involved to read data from a file
	/**
	 * navigate to file -- load (open ) -- read the characters
	 */
	public Base() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(configPath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger = logger.getLogger(log4JPath);  // they define how the console or report should be
		PropertyConfigurator.configure(log4JPath);

	}
	
	/**
	 *  String url = http://tek-school.com/retail
	 * @return
	 */

	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}

	public static void openBrowser() {
		driver.get(getURL());
	}

	public static void selectBrowser() {
		switch (getBrowser()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

}
