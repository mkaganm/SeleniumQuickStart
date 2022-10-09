package dev.mkaganm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class DriverChrome extends Drivers {

    // TODO: dont forget adding try catch
    // * default constructor for driver

    WebDriverWait wait;
    public DriverChrome() {
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.chromedriver().setup();    // for all OS
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // TODO: dont forget adding try catch
    // * constructor with options
    public DriverChrome(String[] args){
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.chromedriver().setup();    // for all os
        this.driver = new ChromeDriver(optionsChrome(args));
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // * set options
    public ChromeOptions optionsChrome(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(args);
        return options;
    }

    // * setup driver and driver path
    @Override
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", FindPath.driverPath(DriverType.CHROME));
    }

}