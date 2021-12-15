package veriff;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.asserts.SoftAssert;

public class VeriffBaseTest {

    public SoftAssert softAssert = new SoftAssert();
    public ConfigurationPage configPage = new ConfigurationPage();
    public VerificationPage verifPage = new VerificationPage();
    public VerificationPageModal verifPageModal = new VerificationPageModal();

    public VeriffBaseTest() {

        // Chrome browser version 96.0.4664.93
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverWin.exe");
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverLinux");
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverMac");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://demo.veriff.me/";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.reportsFolder = System.getProperty("user.dir") + "/build/reports";
    }

    public void openBrowser() {
        Selenide.open("/");
    }

    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    public void refreshBrowser() { Selenide.refresh(); }

}
