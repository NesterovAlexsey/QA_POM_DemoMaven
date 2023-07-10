package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(wd).getForms();
    new SidePanel(wd).selectPracticeForm().hideIframes();
  }

  @Test
  public void fillPracticeFormTest() {
    new PracticeFormPage(wd)
        .enterPersonalData("Alex", "Tester", "adc@gmail.com", "1234567890")
        .selectGender("Male")
//        .typeData("14 Jul 1960")
        .selectDate("May","2000","19")
        .addSubject(new String[]{"Maths", "English", "Chemistry"})
        .selectHobby(new String[]{"Sports", "Music"})
        .uploadFile("C:/Users/AIT TR Student/Downloads/Java_logo_PNG1.png")
        .enterAddress("street 1")
        .selectSatate("NCR")
        .selectCity("Delhi")
        .submit();
  }

  @Test
  public void fillPracticeFormWithFinalData() {
    new PracticeFormPage(wd)
        .enterPersonalData(StudentData.FIRST_NAME,
            StudentData.LAST_NAME,
            StudentData.EMAIL,
            StudentData.PHONE_NUMBER)
        .selectGender(StudentData.GENDER)
        .typeData(StudentData.B_DAY)
        .addSubject(StudentData.SUBJECTS)
        .selectHobby(StudentData.HOBBIES)
        .uploadFile(StudentData.PHOTO_PATH)
        .enterAddress(StudentData.ADDRESS)
        .selectSatate(StudentData.STATE)
        .selectCity(StudentData.CITY)
        .submit()
        .assertNewTabCheckDataAppear("Thanks for submitting the form");
  }

  //Test commit for check bag with big letter disappear in console
}
