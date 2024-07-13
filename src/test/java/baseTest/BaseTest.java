package baseTest;

import chromeRegistry.ChromeRegistry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import util.ScreenshotUtil;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {
        protected static WebDriver driver;

        public void defineTestResultEquals(Object expected, Object actual) {
            String name = this.getClass().getName();
            try {
                assertEquals(expected, actual);
            } catch (AssertionError e) {
                ScreenshotUtil.captureScreen(driver, name);
                fail("TEST FAILED");
            }
        }

        public void defineTestResultTrue(boolean condition) {
            String name = this.getClass().getName();
            try {
                assertTrue(condition);
            } catch (AssertionError e) {
                fail("TEST FAILED");
            }
        }

        public void defineTestResultFalse(boolean condition) {
            String name = this.getClass().getName();
            try {
                assertFalse(condition);
            } catch (AssertionError e) {
                fail("TEST FAILED");
            }
        }

        @BeforeAll
    public static void startBeforeTest(){
            setUpDriver();
        }
     private static void setUpDriver(){
            driver = ChromeRegistry.registerDriver();
            driver.manage().window().maximize();
            driver.get("http://chatty.telran-edu.de:8089/login");
     }

     @AfterAll
    public static void quitAfterTest(){
            driver.quit();
     }
    }

