package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "Email")
	private WebElement emailTextFiled;
	
	@FindBy(id ="Password")
	private WebElement passwordTextField;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getEmailTextFiled() {
		return emailTextFiled;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

}
