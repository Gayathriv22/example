package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginpage {
	private WebDriver driver;
	public  Loginpage(WebDriver driver2) {
		driver=driver2;
	}
	public Loginpage() {
		// TODO Auto-generated constructor stub
	}
	//targets
	private By username=By.id("ap_email");
	//private By password=By.name("password");
	private By signinbtn=By.id("continue");
	//actions
 private void setUsername() {
	 driver.findElement(username).sendKeys("mercury");
 }
 //private void setPassword() {
	// driver.findElement(password).sendKeys("mercury");
// }
 
private void clickOnSignin() {
	driver.findElement(signinbtn).click();
}

public void login() {
	this.setUsername();
	//this.setPassword();
	this.clickOnSignin();
	
}
public static void main(String[]args) { 
	 System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	  driver.get("https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&switch_account=");
	  Loginpage page=new Loginpage(driver);
	  page.login();
	  
}
}

