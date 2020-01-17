package seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDemo {
	 public static void main(String[]args) { 
	MyDemo m =new MyDemo();
	m.get();}
 public void get()
  {
	  System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
  WebDriver driver=new ChromeDriver();
  driver.get("http:www.google.com");
  
  }
}
