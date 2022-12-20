package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends BaseTest {
    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    DurationOfStayPage durationOfStayPage;
    ResultPage resultPage;
    WorkTypePage workTypePage;


    @BeforeMethod(alwaysRun = true)
    public void init() {
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        durationOfStayPage = new DurationOfStayPage();
        workTypePage=new WorkTypePage();

    }

    @Parameters({"nationality1", "reason1", "message1"})
    @Test(priority = 1,groups = {"smoke","sanity","Regression"})
    public void anAustralianComingToUKForTourism(String nationality,String reason,String message) {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickNextStepButton();
        resultPage.confirmResultMessage(message);

    }

   @Parameters ({"nationality2", "reason2", "message2", "durationOfStay", "planning"})
    @Test(priority = 2,groups = {"Regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(String nationality,String reason,String expmessage,String time,String plan) {
       startPage.clickStartNow();
       selectNationalityPage.selectNationality(nationality);
       selectNationalityPage.clickNextStepButton();
       reasonForTravelPage.selectReasonForVisit(reason);
       reasonForTravelPage.clickNextStepButton();
       durationOfStayPage.selectLengthOfStay(time);
       durationOfStayPage.clickNextStepButton();
       workTypePage.selectPlanningToWorkType(plan);
       workTypePage.clickOnContinue();
       resultPage.confirmResultMessage(expmessage);
   }

    @Parameters ({"nationality3", "reason3", "message3"})
   @Test(priority = 3,groups = {"sanity","Regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(String nationality, String reason, String message){
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickNextStepButton();
        resultPage.confirmResultMessage(message);


   }
}

