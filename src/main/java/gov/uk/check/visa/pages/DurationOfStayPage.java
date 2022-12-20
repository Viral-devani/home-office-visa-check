package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);

    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='response-0'])[1]")
    WebElement lessThanSixMonth;

    @CacheLookup
    @FindBy(xpath = "//div[@class='gem-c-radio govuk-radios__item']//input[@id='response-1']")
    WebElement moreThanSixMonth;

    public void selectLengthOfStay(String moreOrLess) {
        switch (moreOrLess) {
           case "longer than 6 months":
               clickOnElement(moreThanSixMonth);
                break;
            case "6 months or less":
                clickOnElement(lessThanSixMonth);
                break;
            default:
                System.out.println("Selection is wrong");
        }

    }
    public void clickNextStepButton(){
        clickOnElement(nextStepButton);
    }
}
