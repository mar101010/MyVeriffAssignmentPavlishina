package veriff;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class VerificationPageModal extends VerificationPage{

    //elements
    public SelenideElement frame = $("iframe");
    private SelenideElement closeIconModal = $("button.l1nc0txa");
    private SelenideElement exitBtnModal = $("div.bxo4sd4 button.b1c7psjy");

    public void switchToVerificationPageIframe(){
        switchTo().frame(frame);
    }

    public void closeVerificationPage(){
        closeIconModal.click();
    }

    public void confirmExit(){
        exitBtnModal.click();
    }


}




























