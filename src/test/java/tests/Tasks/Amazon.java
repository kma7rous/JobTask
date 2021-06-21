package tests.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.WebDriverFactory;

public class Amazon {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBox.sendKeys("qa testing for beginners"+ Keys.ENTER);

        driver.findElement(By.xpath("//img[@class='s-image'][1]")).click();

        WebElement price = driver.findElement(By.xpath("//span[@id='newBuyBoxPrice']"));

        String actualPrice = price.getText();
        String expectedPrice = "$47.49";

        Assert.assertEquals(actualPrice,expectedPrice);

        if (actualPrice.equals(expectedPrice)){
            System.out.println("Verification passed");
        }else {
            System.out.println("Verification failed!");
        }



       WebElement addCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addCart.click();

        WebElement finalPrice = driver.findElement(By.xpath("//span[@class='a-color-price hlb-price a-inline-block a-text-bold']"));

        String actualFinalPrice = actualPrice;
        String expectedFinalPrice = "$47.49";

        Assert.assertEquals(actualPrice,expectedFinalPrice,"Passed");

        if (actualPrice.equals(expectedFinalPrice)){
            System.out.println("Verification passed");
        }else {
            System.out.println("Verification failed!");
        }

        WebElement checkout = driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']"));
        checkout.click();


    }
}
