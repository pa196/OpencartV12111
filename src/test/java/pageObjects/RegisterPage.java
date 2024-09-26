package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtuserFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtuserLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmaillnk;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephnlnk;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassWordlnk;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPasswordCnfrmlnk;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPrivacylnk;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmationlnk;
	
	public void setfrstName(String fname) {
		txtuserFirstName.sendKeys(fname);
	}
	
	public void setlastName(String lname) {
		txtuserLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmaillnk.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephnlnk.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassWordlnk.sendKeys(pwd);
	}
	
	public void setCnfrmPassword(String pwd) {
		txtPasswordCnfrmlnk.sendKeys(pwd);
	}
	
	public void checkPrivacybox() {
		chkPrivacylnk.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getCnfrmMesssage() {
		try {
			return(msgConfirmationlnk.getText());
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	
	
	
	
	
	
	
	
	

}

