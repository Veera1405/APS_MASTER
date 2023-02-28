package Pages_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Helpers.WebActionHelperMethods;

public class BasePageClass {
	protected WebDriver driver;
	static WebActionHelperMethods webActionHelperMethods;

	public BasePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webActionHelperMethods = new WebActionHelperMethods(driver);
	}

}
