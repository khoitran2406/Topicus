package Page.Forms;

import Models.Messages;
import Models.PracticeForm.Gender;
import Models.PracticeForm.Hobbies;
import Models.PracticeForm.PracticeForm;
import Page.BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PracticeFormPage extends BasePage {

    protected By Txt_FirstName = By.id("firstName");
    protected By Txt_LastName = By.id("lastName");
    protected By Txt_Email = By.id("userEmail");
    protected By Rdo_Gender(Gender gender) { return By.xpath(String.format("//*[@id='gender-radio-%s']//parent::*", gender.value)); }
    protected By Txt_Mobile = By.id("userNumber");
    protected By Txt_DateOfBirth = By.id("dateOfBirthInput");
    protected By Txt_Subject = By.id("subjectsInput");
    protected By Chk_Hobby(Hobbies hobby) { return By.xpath(String.format("//*[@id='hobbies-checkbox-%s']//parent::*", hobby.value)); }
    protected By Txt_UploadFile = By.id("uploadPicture");
    protected By Txt_CurrentAddress = By.id(("currentAddress"));
    protected By Slt_YearOfBirth = By.className("react-datepicker__year-select");
    protected By Slt_MonthOfBirth = By.className("react-datepicker__month-select");
    protected By Lbl_DateOfBirth(Date date) {
        return By.xpath(String.format("//*[contains(@class, 'react-datepicker__day')][contains(@aria-label, '%s')][normalize-space()='%s']",
                new SimpleDateFormat("MMMM").format(date),
                new SimpleDateFormat("d").format(date)));
    }
    protected By Lbl_StateSelect = By.id("state");
    protected By Lbl_CitiSelect = By.id("city");
    protected By Lbl_DropdownState(String value) { return By.xpath(String.format("//*[@id='stateCity-wrapper']//*[contains(@id,'react-select')][text()='%s']", value)); }
    protected By Btn_Submit = By.id("submit");
    protected By Lbl_Modal = By.cssSelector("[id*='example-modal']");



    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void SubmitForm(PracticeForm form){
        keyword.WaitForElementDisplayed(Txt_FirstName);
        keyword.SendKey(Txt_FirstName, form.FirstName);
        keyword.SendKey(Txt_LastName, form.LastName);
        if (form.Email != null){
            keyword.SendKey(Txt_Email, form.Email);
        }

        keyword.WaitForElementClickable(Rdo_Gender(form.Gender));
        keyword.ClickOn(Rdo_Gender(form.Gender));
        keyword.SendKey(Txt_Mobile, form.Mobile);
        keyword.ClickOn(Txt_DateOfBirth);

        if (form.DateOfBirth != null){
            keyword.SelectDropdown(Slt_YearOfBirth, new SimpleDateFormat("yyyy").format(form.DateOfBirth));
            keyword.SelectDropdown(Slt_MonthOfBirth, new SimpleDateFormat("MMMM").format(form.DateOfBirth));
            keyword.ClickOn(Lbl_DateOfBirth(form.DateOfBirth));
        }

        if (form.Hobbies != null) {
            for (Hobbies hobby : form.Hobbies){
                keyword.WaitForElementClickable(Chk_Hobby(hobby));
                keyword.ClickOn(Chk_Hobby(hobby));
            }
        }

        if (form.PicturePath != null){
            keyword.SendKey(Txt_UploadFile, form.PicturePath);
        }

        if (form.CurrentAddress != null){
            keyword.SendKey(Txt_CurrentAddress, form.CurrentAddress);
        }

        if (form.State != null){
            keyword.ClickOn(Lbl_StateSelect);
            keyword.ClickOn(Lbl_DropdownState(form.State.value));
            keyword.ClickOn(Lbl_CitiSelect);
            keyword.ClickOn(Lbl_DropdownState(form.City.value));
        }

        keyword.SendKey(Txt_Subject, form.Subject);
        keyword.SendActionKey(Keys.ENTER);
        keyword.ClickOn(Btn_Submit);
    }

    public void VerifySubmitFormSuccess(){
        keyword.VerifyElementAppear(Lbl_Modal);
    }

    public void VerifyFormShowErrorMissingMobileNumber(){
        keyword.VerifyElementHasText(Txt_Mobile, Messages.MobileFormValidation);
    }
}
