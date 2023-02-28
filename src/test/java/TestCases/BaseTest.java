package TestCases;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Constant.Aps_project_constant;
import com.Utilitiys.utility;

import Pages_objects.Employeepage;
import Pages_objects.LoginPage;
import driverManager.DriverManagerType;
import driverManager.WebDrivers;

public class BaseTest {

	static LoginPage loginPage;
	static Employeepage Emply_page;

	public WebDriver driver;
	static Properties properties;

	@BeforeSuite(groups = "unit")
	public void setUp() {

		try {
			Properties_setup();
			utility.Load_properties();
			PropertyConfigurator.configure(System.getProperty("user.dir") + Aps_project_constant.LOG4J);

			driver = WebDrivers.getDriver(DriverManagerType.CHROME);
			loginPage = new LoginPage(driver);
			Emply_page = new Employeepage(driver);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterSuite
	void destroyDriver() throws InterruptedException {

		// driver.quit();
	}

	void Properties_setup() {
		String propertyPath = System.getProperty("user.dir") + Aps_project_constant.CONFICPATH;
		properties = utility.loadProperties(propertyPath);
	}

}