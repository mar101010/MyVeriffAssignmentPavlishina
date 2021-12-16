package veriff;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class ConfigurationTest extends VeriffBaseTest{

    @BeforeClass
    public void openPage() { openBaseUrl(); }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }

    //user sees all elements on Configuration page
    @Test
    public void UserCanSeeTextElements() {

        configPage.getSubmitButton().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(configPage.getTitleHeader().isDisplayed());
        softAssert.assertTrue(configPage.getTitleText().isDisplayed());
        softAssert.assertTrue(configPage.getDescriptionText().isDisplayed());
        softAssert.assertTrue(configPage.getBreakWordText().isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void UserCanSubmitEmptyDataInContext(){
        configPage.clearNameField();
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        refreshBrowser();
    }

    @Test(dataProvider = "config_fullname", dataProviderClass = ConfigurationPage.class)
    public void UserCanSubmitWrongNameValueRedirect(String nameValue){

        configPage.setWrongName(nameValue);
        configPage.setLanguage();
        configPage.setCountry();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        openBaseUrl();
    }

    @Test
    public void UserSubmitsWithPassportAndInContext(){

        configPage.setBasicData();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
        refreshBrowser();
    }

    @Test
    public void UserSubmitsWithIdCardAndInContext(){
        configPage.setBasicData();
        configPage.setDocumentType(2);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
        refreshBrowser();
    }

    @Test
    public void UserSubmitsWithResidenceAndInContext(){
        configPage.setBasicData();
        configPage.setDocumentType(3);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
        refreshBrowser();
    }

    @Test
    public void UserSubmitsWithLicenseAndInContext(){
        configPage.setBasicData();
        configPage.setDocumentType(4);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
        refreshBrowser();
    }

    @Test
    public void UserUndoesVerifInContext(){

        configPage.setBasicData();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        verifPageModal.getVerifHeader().waitUntil(Condition.visible, 5000);
        verifPageModal.closeVerificationPage();
        verifPageModal.confirmExit();
        Selenide.sleep(5000);
        softAssert.assertFalse(verifPageModal.getVerifHeader().isDisplayed());
        softAssert.assertAll();
        refreshBrowser();
    }

    @Test
    public void UserSubmitsWithPassportAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        openBaseUrl();
        Selenide.sleep(5000);
        softAssert.assertAll();
    }

    @Test
    public void UserSubmitsWithIdCardAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(2);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        openBaseUrl();
        //Selenide.sleep(5000);
        softAssert.assertAll();
    }

    @Test
    public void UserSubmitsWithResidenceAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(3);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
        openBaseUrl();
    }

    @Test
    public void UserSubmitsWithLicenseAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(4);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        openBaseUrl();
        Selenide.sleep(5000);
        softAssert.assertAll();
    }

    @Test
    public void UserUndoesVerifRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(4);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        verifPage.closeVerificationPage();
        verifPage.confirmExit();
        configPage.getTitleHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(configPage.getTitleHeader().isDisplayed());
        openBaseUrl();
        configPage.getTitleHeader().waitUntil(Condition.visible, 5000);
        softAssert.assertAll();
    }

}
