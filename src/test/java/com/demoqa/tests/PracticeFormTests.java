package com.demoqa.tests;

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
        .typeData("14 Jul 1960")
        .addSubject(new String[]{"Maths", "English", "Chemistry"})
        .selectHobby(new String[]{"Sports", "Music"})
        .uploadFile("C:/Users/AIT TR Student/Downloads/Java_logo_PNG1.png")
        .enterAddress("street 1")
        .selectSatate("NCR")
        .selectCity("Delhi")
        .submit();
  }
}
