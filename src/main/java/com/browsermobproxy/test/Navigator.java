package com.browsermobproxy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Navigator
 */
public class Navigator {

    public WebDriver openUrl(WebDriver driver,String url) {

        driver.get(url);



        return driver;
        
    }

	public WebDriver findFlights(WebDriver driver, String url) {

        WebElement fromCity = driver.findElement(By.xpath("/html/body/div[3]/form/div/input"));
        fromCity.click();
        return driver;

	}
}