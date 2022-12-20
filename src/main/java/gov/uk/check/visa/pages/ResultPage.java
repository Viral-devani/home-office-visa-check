package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultPage extends Utility {
    public ResultPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    //@FindBy(xpath = "//h2[normalize-space()='You will not need a visa to come to the UK']")
    @FindBy(xpath = "//div[@data-flow-name='check-uk-visa']//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultMessage;
public String getResultMessage(){
    String result=getTextFromElement(resultMessage);
    return result;

}
public void confirmResultMessage(String expectedMessage){
    if(getResultMessage().equalsIgnoreCase(expectedMessage)) {
        Assert.assertTrue(true);
    }else {
        Assert.fail();
    }

}

}
