package com.ujianminggukeempat;

import com.ujianminggukeempat.drivers.DriverSingleton;
import com.ujianminggukeempat.pages.AddCart;
import com.ujianminggukeempat.pages.Login;
import com.ujianminggukeempat.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainApp {

    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Login login = new Login();
        AddCart addCart = new AddCart();

        // Login Account
        driver.get(Constants.URL_LOGIN);
        login.loginForm("aul2", "@Aulia999_888");

        //Item list one product
        driver.get(Constants.URL_SHOP);
        js.executeScript("window.scrollBy(0,550)");
        addCart.shopItemDetail();

        // Add item to cart
        driver.get(Constants.URL_DETAIL_SHOP);
        js.executeScript("window.scrollBy(0,500)");
        addCart.addToCart();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        driver.quit();
    }
}
