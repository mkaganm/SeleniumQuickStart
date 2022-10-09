package dev.mkaganm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;


public class DriverEdge extends Drivers {

    // * default constructor for driver
    public DriverEdge() {
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.edgedriver().setup(); // for all OS
        this.driver = new EdgeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // * constructor with options
    public DriverEdge(String[] args){
        //setupDriver();    // for select my driver in bin folder
        WebDriverManager.edgedriver().setup(); // for all OS
        this.driver = new EdgeDriver(optionsEdge(args));
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // * set options
    public EdgeOptions optionsEdge(String[] args){
        EdgeOptions options = new EdgeOptions();
        options.addArguments(args);
        return options;
    }

    // * setup driver and driver path
    @Override
    public void setupDriver(){
        System.setProperty("webdriver.edge.driver", FindPath.driverPath(DriverType.EDGE));
    }


}
