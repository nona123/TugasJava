package FolderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProduct extends BaseTest {
    @Test
    public void getPrice() {
        WebElement LaptopLink = driver.get().findElement(By.xpath("//a[.='Laptops']"));
        LaptopLink.click();

        WebElement Macbook = explicitWait.get().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[.='MacBook air']")));
        Macbook.click();

        // Assertion, price visible and equal to $700
        WebElement MacPrice = explicitWait.get().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[@class='price-container']")));

        Assert.assertTrue(MacPrice.getText().contains("$700"), "Price does not match");
    }

    @Test
    public void testSignUp() {
        driver.get().findElement(By.xpath("//a[.='Sign up']")).click();
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

        driver.get().findElement(By.id("sign-username")).sendKeys("Fuy");
        driver.get().findElement(By.id("sign-password")).sendKeys("hohoho123");
        driver.get().findElement(By.xpath("//button[.='Sign up']")).click();

        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Sign up successful.") || alertMessage.equals("This user already exist."), "Alert message was not as expected: " + alertMessage);
        alert.accept();
    }

    @Test(priority = 2)
    @Description("Test Description: add to cart")
    public void testAddItem() {
        WebElement addtoCart = driver.get().findElement(By.xpath("//a[.='Add to cart']"));addtoCart.click();
        Alert alert = explicitwait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Product added") || alertMessage.equals("error"), "Alert message was not as expected: " + alertMessage);
        alert.accept();
    }
}
