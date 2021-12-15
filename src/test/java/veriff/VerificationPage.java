package veriff;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private SelenideElement verifHeader = $( "div.s1ueymsd h1");
    private SelenideElement closeIcon = $("div.c47svn3 button");
    private SelenideElement exitBtn = $("a.l15dgtse");

    public SelenideElement getVerifHeader(){ return verifHeader; }

    public void closeVerificationPage(){
        closeIcon.click();
    }

    public void confirmExit(){
        exitBtn.click();
    }

}
