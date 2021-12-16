package veriff;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class ConfigurationPage {

    //elements
    private SelenideElement titleHeader = $( "h3.text-center");
    private SelenideElement titleText = $( "p.text-center");
    private SelenideElement descriptionText = $( "section.no-new-line");
    private SelenideElement breakWordText = $( "section.break-word.m-t");
    private SelenideElement submitButton = $(".UnstyledButton-module_base__1a3SB");
    private SelenideElement nameTextField = $("input.TextField-module_input__3FXIK");
    private SelenideElement languageField = $("button.Select-module_select__1qWxd", 0);//---
    private SelenideElement languageDropdown = $("div.Select-module_dropdown__20VO4", 0);//---
    private SelenideElement countryField = $(By.name("documentCountry"));
    private SelenideElement countryValue = $(byText("Algeria"));
    private SelenideElement documentTypeField = $("div.Select-module_wrapper__Qs5Lu", 1);//---
    private SelenideElement documentTypeValue1 = $("li#downshift-2-item-0");
    private SelenideElement documentTypeValue2 = $("li#downshift-2-item-1");
    private SelenideElement documentTypeValue3 = $("li#downshift-2-item-2");
    private SelenideElement documentTypeValue4 = $("li#downshift-2-item-3");
    private SelenideElement launchTypeInContext = $("input.Radio-module_radio__2iYyp", 0);
    private SelenideElement launchTypeRedirect = $("input.Radio-module_radio__2iYyp", 1);

    @DataProvider(name = "config_fullname")
    public Object[][] wrongNameEntries(){
        return new Object[][]{
        {"@lex E"},
        {"Hanna1"}
        };
    }

    public SelenideElement getTitleHeader() {
        return titleHeader;
    }

    public SelenideElement getTitleText() {
        return titleText;
    }

    public SelenideElement getDescriptionText() {
        return descriptionText;
    }

    public SelenideElement getBreakWordText() {
        return breakWordText;
    }

    public void clearNameField(){
        nameTextField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    public void setCorrectName() { nameTextField.setValue("Anna Smith"); }

    public void setWrongName(String name) { nameTextField.setValue(name); }

    public void setLanguage(){
        languageField.click();
        languageDropdown.click();
    }

    public void setCountry(){
        countryField.click();
        countryValue.click();
    }

    public void setBasicData(){
        setCorrectName();
        setLanguage();
        setCountry();
    }

    public void setDocumentType(int option){
        documentTypeField.click();
        switch (option) {
            case 1:
                documentTypeValue1.click();
                break;
            case 2:
                documentTypeValue2.click();
                break;
            case 3:
                documentTypeValue3.click();
                break;
            case 4:
                documentTypeValue4.click();
                break;
        }
    }

    public void setLaunchTypeInContext(){
        launchTypeInContext.click();
    }

    public void setLaunchTypeRedirect(){
        launchTypeRedirect.click();
    }

    public SelenideElement getSubmitButton(){ return submitButton; }

    public void submit() { submitButton.click(); }

}
