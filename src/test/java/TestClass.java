import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class TestClass {
    WebDriver driver;

    @BeforeTest
    public void LogIn() {
        // WebDriver не обязательно использовать, если не используешь Selenium
//        String projectPath = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//        driver.get("https://someurl");
//        driver.findElement(By.name("login")).sendKeys("somelogin");
//        driver.findElement(By.name("password")).sendKeys("somepassword");
//        driver.findElement(By.name("auth_submit")).click();

        // Selenide
        open("https://someurl");
        $(By.name("login")).setValue("somelogin");
        $(By.name("password")).setValue("somepassword");
        $(By.name("auth_submit")).click();
    }

    @Test
    public void Test() {
        // сам тест
        // TODO

        // в конце теста лучше добавить какую-нибудь проверку
        // Selenium
//        Assert.assertEquals(driver.findElement(By.id("_user_menu")).getText().trim(), "somelogin");
        // Selenide
        $x(".//table[@id='_user_menu']").waitUntil(Condition.text("somelogin"), 5000);
        System.out.println($x(".//table[@id='_user_menu']").getText());// можно добавить вывод в консоль для отладки

    }

    @AfterTest
    public void LogOut() {
        // можно добавить выход из приложения
        // TODO
        // если используешь Selenium и WebDriver - нужно закрыть браузер
//        driver.quit();
    }

}
