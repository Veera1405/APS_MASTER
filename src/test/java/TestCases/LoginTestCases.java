package TestCases;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.Constant.Aps_project_constant;

public class LoginTestCases extends BaseTest {

	static Logger log = Logger.getLogger(LoginTestCases.class);

	@Test(groups = "unit")
	public void Login_to_DashBoard() throws Exception {

		log.info("Get the URL :" + Aps_project_constant.URL);
		driver.get(Aps_project_constant.URL);
		log.info("sending the username =   " + Aps_project_constant.USERNAME + " and password= "
				+ Aps_project_constant.PASSWORD);
		loginPage.Logindetails(Aps_project_constant.USERNAME, Aps_project_constant.PASSWORD);
	}

}