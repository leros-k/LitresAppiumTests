
import org.junit.Test;
import org.openqa.selenium.By;

public class MyBooks extends LoginTest {

    @Test
    public void openMyBooks(){
        authorizationTestForAll();
        //click my books button
        waitForElementAndClick(By.id("ru.litres.android:id/nav_my_audiobooks"), "Cannot find my books button", 30);
    }

    @Test
    public void searchBooksInMy(){
        //authorization and call method for opening my books
        openMyBooks();

        //click search field and add wrong value
        waitForElementAndClick(By.id("ru.litres.android:id/search"), "Cannot find search field", 10).sendKeys("ыыы");

        //click search field and add wrong value
        waitForElementAndClick(By.id("ru.litres.android:id/search"), "Cannot find search field", 10).sendKeys("&!@#$%ˆˆ*(");

        //click search field and add right value
        waitForElementAndClick(By.id("ru.litres.android:id/search"), "Cannot find search field", 10).sendKeys("Не прощаюсь");
        waitForElementAndClick(By.id("ru.litres.android:id/search"), "Cannot find search field_1", 10).clear();

    }

    @Test
    public void useBooksFilter(){
        //authorization and call method for opening my books
        openMyBooks();

        //ru.litres.android:id/mainActionButton
        //click download button
        waitForElementAndClick(By.id("ru.litres.android:id/mainActionButton"), "Cannot find download button", 10);

        //click filter button
        waitForElementAndClick(By.id("ru.litres.android:id/filter"), "Cannot find filter button 1", 10);

        //choose switch 1 (not yet read) + 4 (only downloaded)
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch2"), "Cannot find switch 2", 20);
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch3"), "Cannot find switch 3", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch5"), "Cannot find switch 5", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/right_btn"), "Cannot find apply button", 10);

        //click filter button
        waitForElementAndClick(By.id("ru.litres.android:id/filter"), "Cannot find filter button 2", 10);

        //choose switch 2 (reading) + 4 (only downloaded)
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch1"), "Cannot find switch 1", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch2"), "Cannot find switch 2 (second time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/right_btn"), "Cannot find apply button (sec time)", 10);

        //click filter button
        waitForElementAndClick(By.id("ru.litres.android:id/filter"), "Cannot find filter button 3", 10);

        //choose switch 3 (read) + 4 (only downloaded)
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch2"), "Cannot find switch 2 (third time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch3"), "Cannot find switch 3 (second time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/right_btn"), "Cannot find apply button (third time)", 10);

        //click filter button
        waitForElementAndClick(By.id("ru.litres.android:id/filter"), "Cannot find filter button 4", 10);

        //choose switch 3 (read) + 5 (not downloaded)
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch4"), "Cannot find switch 4", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch5"), "Cannot find switch 5 (second time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/right_btn"), "Cannot find apply button (fourth time)", 10);

        //click filter button
        waitForElementAndClick(By.id("ru.litres.android:id/filter"), "Cannot find filter button 5", 10);

        //choose switch 2 (reading) + 5 (not downloaded)
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch3"), "Cannot find switch 3 (third time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch2"), "Cannot find switch 2 (fourth time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/right_btn"), "Cannot find apply button (fifth time)", 10);

        //click filter button
        waitForElementAndClick(By.id("ru.litres.android:id/filter"), "Cannot find filter button 6", 10);

        //choose switch 1 (not yet read) + 5 (not downloaded)
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch2"), "Cannot find switch 2 (fifth time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/filter_switch1"), "Cannot find switch 1 (second time)", 10);
        waitForElementAndClick(By.id("ru.litres.android:id/right_btn"), "Cannot find apply button (sixth time)", 10);
    }

}
