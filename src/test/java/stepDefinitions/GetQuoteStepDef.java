package stepDefinitions;

import hooks.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.GetQuotePage;

public class GetQuoteStepDef {

    GetQuotePage getQuotePage;

    public GetQuoteStepDef(TestContext testContext) {
        getQuotePage = testContext.getQuotePage();
    }

    @Given("user navigate to Get Quote screen {string}")
    public void userNavigateToGetQuoteScreenHttpsOrientalInsurance(String url) {
        getQuotePage.openPageUrl(url);
    }

    @When("user select date of birth with {string} on {string}")
    public void userSelectDateOfBirth(String day, String member) {
        getQuotePage.selectToDateOfBirth(member, day);
    }

    @And("user select Sum insured for {string} with amount {string}")
    public void userSelectSumInsuredForPersonalDetailsWithAmount(String member, String sumInsured) {
        getQuotePage.selectSumInsured(member, sumInsured);
    }

    @Then("user select amount {string} for PA sum insured if {string} is yes")
    public void userSelectAmountForPASumInsuredIfIsYes(String sumInsured, String option) {
        if (option.equalsIgnoreCase("Yes")) getQuotePage.selectSumInsuredForPA("personal", sumInsured);
    }

    @And("user choose {string} option for {string} area")
    public void userChooseOptionForPersonalArea(String option, String member) {
        if (option.equalsIgnoreCase("Yes")) getQuotePage.clickToExtendPaWithYes(member);
    }

    @When("user choose {string} option for extra insure on {string} area")
    public void userChooseOptionForExtraInsureOnSpouseArea(String option, String member) {
        if (option.equalsIgnoreCase("Yes")) getQuotePage.clickToInsureOtherMember(member);
    }

    @Then("user select date of birth with {string} if {string} is yes on {string} area")
    public void userSelectDateOfBirthWithMarIfIsYesOnSpouseArea(String day, String option, String member) {
        if (option.equalsIgnoreCase("Yes")) getQuotePage.selectToDateOfBirth(member, day);
    }

    @And("user select Sum insured with amount {string} if {string} is yes on {string} area")
    public void userSelectSumInsuredWithAmountIfIsYesOnSpouseArea(String sumInsured, String option, String member) {
        if (option.equalsIgnoreCase("Yes")) getQuotePage.selectSumInsured(member, sumInsured);
    }
}
