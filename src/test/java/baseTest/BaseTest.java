package baseTest;

import org.openqa.selenium.WebDriver;
import util.ScreenshotUtil;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {
        protected WebDriver driver;

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
    }

