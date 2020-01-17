package seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Watches {
public static void takepicture(WebDriver driver,String filename) throws Exception{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File(".//screenshots//"+filename+".png"));
}
	public static void main(String[]args)throws Exception {
	
	System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("http:www.amazon.in");
	  String parent=driver.getWindowHandle();
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
	 Thread.sleep(2000);
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("img[data-image-index=\"3\"]")).click();
			Set<String> childwindows=driver.getWindowHandles();

			 for (String aa: childwindows)
			 {
			 if(!parent.contentEquals(aa))
			 {
			 driver.switchTo().window(aa);
			 takepicture(driver,"img1");
			 Thread.sleep(1000);
			 driver.close();
			 }
			driver.close();
			
			
			 }
	}
			
	}


