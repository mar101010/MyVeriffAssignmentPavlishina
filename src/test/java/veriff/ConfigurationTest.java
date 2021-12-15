package veriff;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class ConfigurationTest extends VeriffBaseTest{

    @BeforeClass
    public void openPage() {
        openBrowser();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }

    @AfterMethod
    public void refresh() { refreshBrowser(); }

    @AfterGroups ("redirectLaunch") //log out after logged in users test
    public void  goBackToBaseUrl() {
        //
    }


    //user sees all elements on Configuration page
    @Test
    public void userSeesTextElements() {

        configPage.getSubmitButton().waitUntil(Condition.visible, 5000);
        softAssert.assertTrue(configPage.getTitleHeader().isDisplayed());
        softAssert.assertTrue(configPage.getTitleText().isDisplayed());
        softAssert.assertTrue(configPage.getDescriptionText().isDisplayed());
        softAssert.assertTrue(configPage.getBreakWordText().isDisplayed());
        softAssert.assertAll();
    }

   /* @Test (groups = { "redirectLaunch" })
    public void UserCannotSubmitEmptyData(){
       configPage.clearNameField();
       configPage.setLaunchTypeInContext();
       configPage.submit();
       Selenide.sleep(5000);
       //iframe switch
       softAssert.assertTrue(configPage.getTitleHeader().isDisplayed());
       refreshBrowser();
       configPage.clearNameField();
       configPage.setLaunchTypeRedirect();
       configPage.submit();
       Selenide.sleep(5000);
       softAssert.assertTrue(configPage.getTitleHeader().isDisplayed());
       softAssert.assertAll();
    } */

//!!!       @Test(dataProvider = "config_fullname", dataProviderClass = ConfigurationPage.class) (groups = { "redirectLaunch" })
    public void UserCannotSubmitWrongNameValue(String nameValue){
        configPage.setWrongName(nameValue);
        configPage.setLanguage();
        configPage.setCountry();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        Selenide.sleep(5000);
        softAssert.assertFalse(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void UserSubmitsWithPassportAndInContext(){

        configPage.setBasicData();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void UserSubmitsWithIdCardAndInContext(){
        configPage.setBasicData();
        configPage.setDocumentType(2);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void UserSubmitsWithResidenceAndInContext(){
        configPage.setBasicData();
        configPage.setDocumentType(3);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void UserSubmitsWithLicenseAndInContext(){
        configPage.setBasicData();
        configPage.setDocumentType(4);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void UserGoesBackFromInContext(){

        configPage.setBasicData();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeInContext();
        configPage.submit();
        verifPageModal.switchToVerificationPageIframe();
        Selenide.sleep(5000);
        verifPageModal.getVerifHeader().waitUntil(Condition.visible, 5000);
        verifPageModal.closeVerificationPage();
        verifPageModal.confirmExit();
        Selenide.sleep(5000);
        softAssert.assertFalse(verifPageModal.getFrame().isDisplayed());
        softAssert.assertFalse(verifPageModal.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    }

 /*   @Test (groups = { "redirectLaunch" })
    public void UserSubmitsWithPassportAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(1);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    } */

/*    @Test (groups = { "redirectLaunch" })
    public void UserSubmitsWithIdCardAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(2);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    } */

 /*   @Test (groups = { "redirectLaunch" })
    public void UserSubmitsWithResidenceAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(3);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    } */

 /*   @Test (groups = { "redirectLaunch" })
    public void UserSubmitsWithLicenseAndRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(4);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        Selenide.sleep(5000);
        softAssert.assertTrue(verifPage.getVerifHeader().isDisplayed());
        softAssert.assertAll();
    } */

 /*   @Test (groups = { "redirectLaunch" })
    public void UserGoesBackFromRedirect(){

        configPage.setBasicData();
        configPage.setDocumentType(4);
        configPage.setLaunchTypeRedirect();
        configPage.submit();
        verifPage.getVerifHeader().waitUntil(Condition.visible, 5000);
        verifPage.closeVerificationPage();
        verifPage.confirmExit();
        Selenide.sleep(5000);
        softAssert.assertTrue(configPage.getTitleHeader().isDisplayed());
        softAssert.assertAll();
    } */

}
