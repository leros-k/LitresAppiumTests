import org.junit.Test;
import org.openqa.selenium.By;

public class Lists extends MyBooks {

    private String newList = "New List";

    @Test
    public void listButton(){
        //tap adding new list button
        waitForElementAndClick(By.id("ru.litres.android:id/fab"), "Cannot find button for adding new list", 10);

        //add name list
        waitForElementAndClick(By.id("ru.litres.android:id/shelfTitleEdit"), "Cannot find field for adding name list", 10).sendKeys(newList);
    }

    @Test
    public void openingList() throws InterruptedException{
        //authorization and call method for opening my books
        openMyBooks();

        //click List Tab
        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='LISTS']"), "Cannot find LISTS tab", 10);

        //click not in list
        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='Not in list']"), "Cannot find not in list", 10);

        //return back to all lists
        driver.navigate().back();

        //click series list
        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='Series']"), "Cannot find Series", 10);

        swipingVertical();

        //return back to all lists
        driver.navigate().back();

        swipingVertical();

        //click authors list
        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='Authors']"), "Cannot find Authors", 10);

    }

    @Test
    public void createNewList(){
        //authorization and call method for opening my books
        openMyBooks();

        //click List Tab
        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='LISTS']"), "Cannot find LISTS tab", 10);

        listButton();

        //tap to cancel button
        waitForElementAndClick(By.id("ru.litres.android:id/cancelButton"), "Cannot find cancel button", 10);

        listButton();

        //tap to create button
        waitForElementAndClick(By.id("ru.litres.android:id/addShelfbutton"), "Cannot find add button", 10);

    }


    @Test
    public void tapActionButton() throws InterruptedException{
        openMyBooks();

        waitForElementAndClick(By.id("ru.litres.android:id/actionsButton"), "Cannot find action button", 10);
        Thread.sleep(2000);
    }

    @Test
    public void tapDownloadActionButton() throws InterruptedException{
        tapActionButton();

        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='Download']"), "Cannot find download button", 10);
        Thread.sleep(2000);
    }

    //над дописать перенос книги в список
    @Test
    public void tapAddToListActionButton() throws InterruptedException{
        tapActionButton();

        //tap to 'Add to list' button in action button
        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='Add to list']"), "Cannot find addToList button", 10);
        Thread.sleep(2000);

        //tap to create list button
        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='Create new list']"), "Cannot find create list button", 10);
        Thread.sleep(2000);

        //tap to create name for new list
        waitForElementAndClick(By.id("ru.litres.android:id/shelfTitleEdit"), "Cannot find shelf title edit field", 10).sendKeys(newList);
        Thread.sleep(2000);

        //tap 'Çreate'
        waitForElementAndClick(By.id("ru.litres.android:id/addShelfbutton"), "Cannot find 'Create' button", 10);
        Thread.sleep(2000);

        waitForElementAndClick(By.id("ru.litres.android:id/putToShelfbutton"), "Cannot find shelf title edit field", 10).sendKeys(newList);


    }

    //чекнуть как работает
    @Test
    public void tapToArchiveActionButton() throws InterruptedException{
        tapActionButton();

        waitForElementAndClick(By.xpath("//android.widget.TextView[@text='To archive']"), "Cannot find toArchive button", 10);
        Thread.sleep(2000);
    }


    @Test
    public void swipingVertical() throws  InterruptedException{
        //Get the size of screen
        size = driver.manage().window().getSize();
        System.out.println(size);

        //Find swipe start and end point from screen's width and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int)(size.height * 0.80);

        //Find endy point which is at top side of screen.
        int endy = (int)(size.width * 0.20);

        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        //Swipe from Bottom to Top.
        driver.swipe(startx, starty, startx, endy, 3000);
        Thread.sleep(2000);

        //Swipe from Top to Bottom.
        driver.swipe(startx, endy, startx, starty, 3000);
        Thread.sleep(2000);
    }



}
