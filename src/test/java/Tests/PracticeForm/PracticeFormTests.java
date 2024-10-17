package Tests.PracticeForm;

import Models.PracticeForm.*;
import Page.Forms.PracticeFormPage;
import Tests.BaseTest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PracticeFormTests extends BaseTest {

    protected PracticeFormPage practiceFormPage;
    protected PracticeForm practiceForm;

    @Test(description = "verify Submit form successfully with all field")
    public void VerifySubmitFormSuccessFullyWithAllField(){
        practiceForm = new PracticeForm();
        practiceForm.FirstName = faker.name().firstName();
        practiceForm.LastName = faker.name().lastName();
        practiceForm.Email = String.format("%s%s@gmail.com", faker.name().firstName(), faker.number().digits(5));
        practiceForm.Gender = Gender.MALE;
        practiceForm.Mobile = faker.number().digits(10);
        practiceForm.DateOfBirth =  new GregorianCalendar(1995, Calendar.JUNE, 24).getTime();
        practiceForm.Subject = "Math";
        practiceForm.Hobbies = new ArrayList<Hobbies>();
        practiceForm.Hobbies.add(Hobbies.MUSIC);
        practiceForm.Hobbies.add(Hobbies.READING);
        practiceForm.PicturePath = Paths.get(System.getProperty("user.dir"), "src\\main\\resources\\picture.png").toString();
        practiceForm.CurrentAddress = faker.address().fullAddress();
        practiceForm.State = State.NCR;
        practiceForm.City = City.DELHI;

        practiceFormPage.SubmitForm(practiceForm);
        practiceFormPage.VerifySubmitFormSuccess();
    }

    @Test(description = "Verify Submit form unsuccessfully without mobile number")
    public void VerifySubmitFormUnSuccessFullyWithoutMobileNumber(){
        practiceForm = new PracticeForm();
        practiceForm.FirstName = faker.name().firstName();
        practiceForm.LastName = faker.name().lastName();
        practiceForm.Email = faker.address().mailBox();
        practiceForm.Gender = Gender.MALE;
        practiceForm.Mobile = "";
        practiceForm.DateOfBirth =  new GregorianCalendar(1995, Calendar.JUNE, 24).getTime();
        practiceForm.Subject = "Math";
        practiceForm.Hobbies = new ArrayList<Hobbies>();
        practiceForm.Hobbies.add(Hobbies.MUSIC);
        practiceForm.Hobbies.add(Hobbies.READING);
        practiceForm.PicturePath = Paths.get(System.getProperty("user.dir"), "src\\main\\resources\\picture.png").toString();
        practiceForm.CurrentAddress = faker.address().fullAddress();
        practiceForm.State = State.NCR;
        practiceForm.City = City.DELHI;

        practiceFormPage.SubmitForm(practiceForm);
        practiceFormPage.VerifyFormShowErrorMissingMobileNumber();
    }

    @BeforeTest
    public void InitTest(){
        practiceFormPage = new PracticeFormPage(driver);
    }
}
