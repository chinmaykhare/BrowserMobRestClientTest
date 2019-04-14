package com.browsermobproxy;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;


public class App {

    public static void main(String[] args) {
        // Initialising objects of reference classes
        Navigator navigator = new Navigator();
        BrowserMobRest restClient = new BrowserMobRest();

        System.setProperty("webdriver.chrome.driver", "D:\\softwares\\chromedriver_win32\\chromedriver.exe");
        Proxy seleniumProxy = new Proxy();
        seleniumProxy.setHttpProxy("localhost:3001");
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PROXY, seleniumProxy);
        WebDriver driver = new ChromeDriver(options);

        String url = "http://blazedemo.com/";

        restClient.startProxy();
        restClient.createHarInstance();

        restClient.addPageRef("OpenBlazeDemoSite");
        navigator.openUrl(driver, url);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        restClient.addPageRef("FindFlights");
        navigator.findFlights(driver,url);


        restClient.getHar();

        driver.close();

    }
}
