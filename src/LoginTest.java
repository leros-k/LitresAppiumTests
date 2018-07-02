import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    public AppiumDriver driver;
    Dimension size;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.1.0");
        desiredCapabilities.setCapability("deviceName", "Nexus 5X");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("app", "/Users/Valeria/IdeaProjects/LitresAppiumTests/apks/googlePlayLitresRelease-3.11-x86.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void registrationTest(){

        //click profile button in tapbar
        waitForElementAndClick(By.id("ru.litres.android:id/nav_profile"), "Cannot find Profile button", 5);

        //click login/auth button in profile
        waitForElementAndClick(By.id("ru.litres.android:id/login_button"), "Cannot find login button", 10);

        //click login/auth button for registration
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find sign_up button", 10);

        //click terms of service button
        waitForElementAndClick(By.id("ru.litres.android:id/terms_of_service"), "Cannot terms of service", 10);

        //return back to registration window
        driver.navigate().back();

        //click login/auth button
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find sign_up button_2", 10);

        //empty email field and full password field and click registration button
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field in registration window", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find registration button_1", 10);

        //empty password and full email and click registration button
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field in registration window", 10).sendKeys("ololo@ol.lo");
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field in registration window", 10).clear();
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find registration button_2", 10);

        //already busy email for registration
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field in registration window", 10).sendKeys("ololo@ol.lo");
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field in registration window", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find registration button_3", 10);

        //correct email and password and wait for visible positive registration
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field in registration window", 10).sendKeys(getSaltString());
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field in registration window", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find registration button_4", 10);

    }

    @Test
    public void registrationSecondTest(){

        //click profile button in tapbar
        waitForElementAndClick(By.id("ru.litres.android:id/nav_profile"), "Cannot find Profile button", 10);

        //click login/auth button
        waitForElementAndClick(By.id("ru.litres.android:id/login_button"), "Cannot find login button", 10);

        //empty email and full password
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwerty");

        //click login/auth button
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find sign_up button", 10);

        //click back button
        waitForElementAndClick(By.id("ru.litres.android:id/back_arrow"), "Cannot find back button", 10);

        //empty password and full email
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys("qwerty@ol.lo");

        //click login/auth button
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find sign_up button", 10);

        //click back button
        waitForElementAndClick(By.id("ru.litres.android:id/back_arrow"), "Cannot find back button_2", 10);


        //invalid (not available) email
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys("ololo@ol.lo");
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find sign_up button", 10);

        //right email and password
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys(getSaltString());
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_up_btn"), "Cannot find sign_up button", 10);
    }

    @Test
    public void authorizationTest(){

        //click profile button in tapbar
        waitForElementAndClick(By.id("ru.litres.android:id/nav_profile"), "Cannot find Profile button", 10);

        //click login/auth button
        waitForElementAndClick(By.id("ru.litres.android:id/login_button"), "Cannot find login button", 10);

        //click login field
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys("qwerty@ol.lo");

        //click login button
        waitForElementAndClick(By.id("ru.litres.android:id/sign_in_btn"), "Cannot find login field", 10);

        //clear login field and fill password field
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).clear();
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_in_btn"), "Cannot find login field", 10);

        //clear password field and use exists email and wrong password
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys("ololo@ol.lo");
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).clear();
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwertys");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_in_btn"), "Cannot find login field", 10);


        //clear password field and use right password and wrong email
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find password field", 20).clear();
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys("ololo@ol.los");
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).clear();
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_in_btn"), "Cannot find login field", 10);

        //use right password and right email
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find password field", 10).clear();
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys("ololo@ol.lo");
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).clear();
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwerty");
        waitForElementAndClick(By.id("ru.litres.android:id/sign_in_btn"), "Cannot find login field", 10);

    }

    @Test
    public void authorizationTestForAll(){
        //click profile button in tapbar
        waitForElementAndClick(By.id("ru.litres.android:id/nav_profile"), "Cannot find Profile button", 10);

        //click login/auth button
        waitForElementAndClick(By.id("ru.litres.android:id/login_button"), "Cannot find login button", 10);

        //add login
        waitForElementAndClick(By.id("ru.litres.android:id/login"), "Cannot find login field", 10).sendKeys("ololo@ol.lo");

        //add password
        waitForElementAndClick(By.id("ru.litres.android:id/password"), "Cannot find password field", 10).sendKeys("qwerty");

        //click sign in button
        waitForElementAndClick(By.id("ru.litres.android:id/sign_in_btn"), "Cannot find login field", 10);
    }



    public WebElement waitForElementPresent (By by, String error_message, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementAndClick (By by, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    protected String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "@ol.lo";
        return saltStr;
    }



}
