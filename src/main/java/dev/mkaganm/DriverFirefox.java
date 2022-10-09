package dev.mkaganm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class DriverFirefox extends Drivers {



    // * default constructor for driver
    public DriverFirefox() {
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.firefoxdriver().setup(); // for all OS
        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // * constructor with options
    public DriverFirefox(String[] args){
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.firefoxdriver().setup(); // for all OS
        this.driver = new FirefoxDriver(optionsFirefox(args));
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // * set options
    public FirefoxOptions optionsFirefox(String[] args){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(args);
        return options;
    }

    // * setup driver and driver path
    @Override
    public void setupDriver(){
        System.setProperty("webdriver.gecko.driver", FindPath.driverPath(DriverType.FIREFOX));
    }


}
