package pageObject;


import org.openqa.selenium.By;

public class GetQuotePage extends BasePage {

    //Personal Detail
    public By dateOfBirthPersonal = By.cssSelector(" input[id*='primaryInsuedDob_input']");
    public By expendPAPersonalIsNo = By.cssSelector("input[name*='isCoverageExtendedForPa'][value ='0']");
    public By expendPAPersonalIsYes = By.cssSelector("input[name*='isCoverageExtendedForPa'][value ='1']");
    public By sumInsuredPAForPersonal = By.cssSelector("select[id*='selfSumInsuredForPA']");
    public By sumInsuredPersonal = By.xpath("//span[text()='Select sum insured']/../../../..//select");

    public String dateOfBirth = "div[id$='%s'] input[id*='dob']";
    public String insureMemberIsNo = "input[value='0'][onclick*='%s']";
    public String insureMemberIsYes = "input[value='1'][onclick*='%s']";
    public String sumInsured = "div[id$='%s'] select[id*='sumInsured']";
    public String sumInsuredPA = "div[id$='%s'] select[id*='SumInsuredForPA']";
    public String personalAccidentIsNo = "div[id$='%s'] input[value= '0'][name*='ForPa']";
    public String personalAccidentIsYes = "div[id$='%s'] input[value= '1'][name*='ForPa']";

    //calender
    public String dateOfBirthDate = "//table[@class='ui-datepicker-calendar']//a[text()='%s']";
    public By monthOfBirthDate = By.cssSelector("select[class='ui-datepicker-month']");
    public By yearOfBirthDate = By.cssSelector("select[class='ui-datepicker-year']");

    public void selectDayMonthYear(String day) {
        String year = day.substring(7);
        String date = day.substring(0, 2);
        String month = day.substring(3, 6);
        selectItemInDefaultDropdown(yearOfBirthDate, year);
        selectItemInDefaultDropdown(monthOfBirthDate, month);
        waitForElementClickable(replaceStringInXpath(dateOfBirthDate, date));
        clickToElement(By.xpath(String.format(dateOfBirthDate, date)));
    }

    public void selectToDateOfBirth(String member, String day) {
        if (member.equalsIgnoreCase("personal")) clickToDateOfBirthForPersonal(day);
        else clickToDateOfBirthForMember(member, day);
    }

    public void clickToDateOfBirthForPersonal(String day) {
        waitForElementClickable(dateOfBirthPersonal);
        clickToElement(dateOfBirthPersonal);
        selectDayMonthYear(day);
    }

    public void clickToDateOfBirthForMember(String member, String day) {
        waitForElementClickable(replaceStringInCss(dateOfBirth, member));
        clickToElement(replaceStringInCss(dateOfBirth, member));
        selectDayMonthYear(day);
    }

    public void selectSumInsured(String member, String sumInsured) {
        if (member.equalsIgnoreCase("personal")) {
            selectItemInDefaultDropdown(sumInsuredPersonal, sumInsured);
        } else {
            selectItemInDefaultDropdown(replaceStringInXpath(sumInsured, getMemberXpath(member)), sumInsured);
        }
    }


    public void selectSumInsuredForPA(String member, String sumInsured) {
        if (member.equalsIgnoreCase("personal")) {
            waitForElementVisible(sumInsuredPAForPersonal);
            selectItemInDefaultDropdown(sumInsuredPAForPersonal, sumInsured);
        } else {
            waitForElementVisible(replaceStringInXpath(sumInsuredPA, getMemberXpath(member)));
            selectItemInDefaultDropdown(replaceStringInXpath(sumInsuredPA, getMemberXpath(member)), sumInsured);
        }
    }

    public void clickToExtendPaWithYes(String member) {
        if (member.equalsIgnoreCase("personal")) {
            waitForElementClickable(expendPAPersonalIsYes);
            clickToElement(expendPAPersonalIsYes);
        } else {
            waitForElementClickable(replaceStringInXpath(personalAccidentIsYes, getMemberXpath(member)));
            clickToElement(replaceStringInXpath(personalAccidentIsYes, getMemberXpath(member)));
        }
    }

    public void clickToInsureOtherMember(String member) {
        waitForElementClickable(replaceStringInCss(insureMemberIsYes, getMemberXpath(member)));
        clickToElement(replaceStringInCss(insureMemberIsYes, getMemberXpath(member)));
    }

    private String getMemberXpath(String member) {
        switch (member) {
            case "spouse":
                return "pnlSpouse";
            case "father":
                return "pnlFather";
            case "mother":
                return "pnlMother";
            case "father-in-law":
                return "pnlFatherIL";
            case " mother-in-law":
                return "pnlMotherIL";
            default:
                throw new IllegalStateException("Cannot define member: " + member);
        }
    }


}
