package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement>reasonForVisit;
    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Continue']")
    WebElement coninueButton;

 public void selectReasonForVisit(String reason){
     for(WebElement selectReason:reasonForVisit){
         if(selectReason.getText().equalsIgnoreCase(reason)){
             clickOnElement(selectReason);
             break;
         }

     }

 }
 public void clickNextStepButton(){
     Reporter.log("Click on continue button"+coninueButton.toString());
     clickOnElement(coninueButton);

 }
}
