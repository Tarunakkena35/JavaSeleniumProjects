package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SellIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com/");
		Duration duration= Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(duration);
		
		/*
		 * Step 1: Creating the new account 
		 * Step 2: Filling the details 
		 * Step 3: Deleting the account 
		 * */
		
		//Creating the new account 
		driver.findElement(By.cssSelector("ul.nav li a[href*='login']")).click();
		driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='name']")).sendKeys("DammyJoseph");
		driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='email']")).sendKeys("Dammy1995@gmail.com");
		driver.findElement(By.xpath("//div[@class='signup-form']//button[text()='Signup']")).click();
		
		//Filling the details 
		driver.findElement(By.xpath("//form[@action='/signup']//label[@for='id_gender1']")).click();
		driver.findElement(By.cssSelector("form[action*='signup'] input[type='password']")).sendKeys("Dammy@123");
		WebElement days = driver.findElement(By.cssSelector("form[action*='signup'] select[id='days']"));
		WebElement months = driver.findElement(By.cssSelector("form[action*='signup'] select[id='months']"));
		WebElement years = driver.findElement(By.cssSelector("form[action*='signup'] select[id='years']"));
		Select dropdown1=new Select(days);
		Select dropdown2=new Select(months);
		Select dropdown3=new Select(years);
		dropdown1.selectByValue("5");
		dropdown2.selectByIndex(5);
		dropdown3.selectByValue("2005");
        driver.findElement(By.cssSelector("form[action*='signup'] input[name='optin']")).click();
		driver.findElement(By.cssSelector("form[action*='signup'] input[name ='first_name']")).sendKeys("DammyName");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name ='last_name']")).sendKeys("DammySurname");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name ='company']")).sendKeys("XYZ-Company");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name ='address1']")).sendKeys("1-5, main road");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name ='address2']")).sendKeys("vizag");
		WebElement country = driver.findElement(By.cssSelector("form[action*='signup'] select[name='country']"));
		Select dropdown4=new Select(country);
		dropdown4.selectByValue("India");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name='state']")).sendKeys("Andhra Pradesh");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name='city']")).sendKeys("Parvathipuram");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name='zipcode']")).sendKeys("535463");
		driver.findElement(By.cssSelector("form[action*='signup'] input[name='mobile_number']")).sendKeys("6315666387");
		driver.findElement(By.xpath("//form[@action='/signup']//button[text()='Create Account']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//b")).getText());
		driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//a[@href='/']")).click();
		
		//Deleting the account 
		driver.findElement(By.cssSelector("ul.nav li a[href*='delete']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//b")).getText());
		driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//a[@href='/']")).click();
		
		
	}

}

