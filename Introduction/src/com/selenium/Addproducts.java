package com.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addproducts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/* 
		 * Step 1: Login into Existing account
		 * Step 2: Clicking on the products button
		 * Step 3: Fetching the products available in the page
		 * Step 4: Selecting the Required products and Add them to cart
		 * Step 5: Viewing the cart page 
		 * Step 6: Proceed to checkout 
		 * Step 7: Viewing the Payment page 
		 */
		
		//Login into Existing account
		driver.findElement(By.cssSelector("ul.nav li a[href*='login']")).click();
		driver.findElement(By.xpath("//form[@action='/login']//input[@name='email']")).sendKeys("Dammy2025@gmail.com");
		driver.findElement(By.xpath("//form[@action='/login']//input[@name='password']")).sendKeys("Dammy@123");
		driver.findElement(By.xpath("//form[@action='/login']//button[text()='Login']")).click();
		
		//Click on the products button and fetching the products available in the page
		driver.findElement(By.cssSelector("ul.nav li a[href*='products']")).click();
		List<WebElement> productWebelementList = driver.findElements(By.xpath("//div[@class='productinfo text-center']//p"));
		ArrayList<String> requiredList =  new ArrayList<String>(Arrays.asList("Winter Top","Frozen Tops For Kids","Pure Cotton V-Neck T-Shirt"));
		List<String> productList = productWebelementList.stream().map(item->item.getText()).collect(Collectors.toList());
		
	    //Selecting the Required products and Add them to cart
		int j=0;
		while(j<requiredList.size()) {
			for(int i=0;i<productList.size();i++) {
				if(productList.get(i).contains(requiredList.get(j))) {
					WebElement addToCartBtn = driver.findElements(By.xpath("//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']")).get(i);
		            // Scroll + JS Click to avoid iframe overlap
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
			        break;
				}
			}
			driver.findElement(By.xpath("//div[@class='modal-content']//button[text()='Continue Shopping']")).click();
			j++;
		}
		
		//Viewing the cart page
		driver.findElement(By.cssSelector("ul.nav li a[href*='view_cart']")).click();
		//Proceed to checkout 
		driver.findElement(By.xpath("//div[@class='col-sm-6']//a[@class='btn btn-default check_out']")).click();
		//Viewing the Payment page 
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		
	}

}
