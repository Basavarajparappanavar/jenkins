package Maven_demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework_utility.Base_Test;
import Framework_utility.Utility_methods;

public class Register_Test extends Base_Test {
	@DataProvider(name="Testdata")
	public Object[][] testdata() throws IOException {
		Object[][]data=Utility_methods.get_test_data("Register");
		return data;
	}
@Test(dataProvider = "Testdata")

	public void register(String firstname,String Lastname,String email,String pwd,String cpwd) throws IOException {
		Utility_methods.Test_configuration();
		WebElement register_link=driver.findElement(By.className("ico-register"));
		Utility_methods.click_element(register_link);
		WebElement first_name=driver.findElement(By.id("FirstName"));
		Utility_methods.Enter_value_to_edit_field(first_name, firstname);
		WebElement last_name=driver.findElement(By.id("LastName"));
		Utility_methods.Enter_value_to_edit_field(last_name, Lastname);
		WebElement Email=driver.findElement(By.id("Email"));
		Utility_methods.Enter_value_to_edit_field(Email, email);
		WebElement password=driver.findElement(By.id("Password"));
		Utility_methods.Enter_value_to_edit_field(password, pwd);
		WebElement confrm_password=driver.findElement(By.id("ConfirmPassword"));
		Utility_methods.Enter_value_to_edit_field(confrm_password, cpwd);
		WebElement submit=driver.findElement(By.id("register-button"));
		Utility_methods.click_element(submit);
	
	
}
}
