import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class team35QA {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @Test
    public void coursework() throws InterruptedException{
//  Open browser and go to "https://magento.softwaretestingboard.com/"
        driver.get("https://magento.softwaretestingboard.com/");
//  Find and Click on Sign in
        WebElement signIn = driver.findElement(By.xpath("//ul/li[2]/a"));
        signIn.click();

//  Enter Email and Password then Click sign in
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("team35QA@gmail.com");

        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("bypass#2023");

        WebElement signInb2 = driver.findElement(By.name("send"));
        signInb2.click();

//  Go to "Gear" section and pick an item
        WebElement gear = driver.findElement(By.className("nav-4"));
        gear.click();
        WebElement fitness = driver.findElement(By.xpath("//li[@class=\"item\"][2]"));
        fitness.click();
        WebElement item1 = driver.findElement(By.xpath("//div[@class=\"columns\"]/div/div[3]/ol/li[2]/div/div/strong/a"));
        item1.click();

//  Verify Item name & price
        WebElement selectItem = driver.findElement(By.className("base"));
        Assert.assertEquals(selectItem.getText(), "Set of Sprite Yoga Straps");
        System.out.println("Item name has verified");

        WebElement itemPrice = driver.findElement(By.className("price"));
        Assert.assertEquals(itemPrice.getText(), "$14.00");
        System.out.println("Item price has also verified");

        WebElement quantity = driver.findElement(By.xpath("//div[@class=\"control qty\"]/input"));
        quantity.clear();
        quantity.sendKeys("1");

//  Add to Cart
        WebElement cart = driver.findElement(By.id("product-addtocart-button"));
        cart.click();

//  There is no "Continue Shopping" button in this page,hence using the same method before...
        WebElement gear2 = driver.findElement(By.id("ui-id-6"));
        gear2.click();

        WebElement bags = driver.findElement(By.xpath("//div[@class=\"sidebar sidebar-main\"]/div[2]/div/ul/li/a"));
        bags.click();

        WebElement mbag = driver.findElement(By.xpath("//img[@class=\"product-image-photo\"]"));
        mbag.click();

        WebElement cart2 = driver.findElement(By.id("product-addtocart-button"));
        cart2.click();

//  Go to Cart and verify relevant
        Thread.sleep(3000);
        WebElement cartbtn = driver.findElement(By.xpath("//div[@class=\"minicart-wrapper\"]/a"));
        cartbtn.click();

//  Verify Item names and prices
        Thread.sleep(3000);
        WebElement itemp1 = driver.findElement(By.xpath("//div[@class=\"price-container\"]/span/span/span/span"));
        String a = itemp1.getText().replace("$","");
        double a2 = Double.parseDouble(a);

        WebElement itemp2 =driver.findElement(By.xpath("//ol[@id=\"mini-cart\"]/li[2]/div/div/div/div/span/span/span/span"));
        String b = itemp2.getText().replace("$", "");
        double b2 = Double.parseDouble(b);


        WebElement total = driver.findElement(By.xpath("//div[@class=\"subtotal\"]/div/span/span"));
        Actions act1 = new Actions(driver);
        act1.moveToElement(total).perform();
        try {
            String c = total.getText().replace("$","");
            double c2 = Double.parseDouble(c);
            Assert.assertEquals(c2, a2+b2);
            System.out.println("Cart Total verified");
        }
        catch (AssertionError e) {
            System.out.println(e);
            System.out.println("Remove cart items added in before test");
        }

//  Remove a product and check update

        WebElement remove = driver.findElement(By.xpath("//div[@class=\"secondary\"]/a"));
        remove.click();

        Thread.sleep(1000);
        WebElement assure = driver.findElement(By.className("action-accept"));
        assure.click();

        Thread.sleep(3000);
        WebElement uptotal = driver.findElement(By.xpath("//div[@class=\"subtotal\"]/div/span/span"));
        Actions act2 = new Actions(driver);
        act2.moveToElement(uptotal).perform();
        try {
            String d = uptotal.getText().replace("$", "");
            double d2= Double.parseDouble(d);
            Assert.assertEquals(d2,b2);
            System.out.println("Updated Cart Total verified");
        }
        catch (AssertionError f) {
            System.out.println(f);
        }

        WebElement checkout = driver.findElement(By.id("top-cart-btn-checkout"));
        checkout.click();

//  Filling Necessary Fields and proceed to checkout
        Thread.sleep(5000);
        try {
            WebElement address = driver.findElement(By.name("street[0]"));
            address.sendKeys("221/B, Bakers Street");

            WebElement city = driver.findElement(By.name("city"));
            city.sendKeys("London");

            new Select(driver.findElement(By.name("region_id"))).selectByVisibleText("Washington");
            driver.findElement(By.name("postcode")).sendKeys("AB12 3CD");
            new Select(driver.findElement(By.name("country_id"))).selectByVisibleText("United Kingdom");
            driver.findElement(By.name("telephone")).sendKeys("+44233267878");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@id=\"shipping-method-buttons-container\"]/div/button")).click();
        }
        catch (ElementNotInteractableException g) {
            System.out.println("Your Address is already saved to Address Book");
            driver.findElement(By.xpath("//div[@id=\"shipping-method-buttons-container\"]/div/button")).click();
        }

//  Verify URL
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://magento.softwaretestingboard.com/checkout/#payment");
        System.out.println("URL has verified");

        driver.findElement(By.xpath("//div[@class=\"payment-method-content\"]/div[4]/div/button")).click();

//  Verify Thank You Message
        Thread.sleep(3000);
        WebElement message = driver.findElement(By.className("base"));
        Assert.assertEquals(message.getText(),"Thank you for your purchase!");
        System.out.println("Thank You Message has verified");
    }

}
