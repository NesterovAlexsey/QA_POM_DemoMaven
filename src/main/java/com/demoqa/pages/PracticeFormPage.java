package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {

  public PracticeFormPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id = "firstName")
  WebElement firstName;

  @FindBy(id = "lastName")
  WebElement lastName;

  @FindBy(id = "userEmail")
  WebElement userEmail;

  @FindBy(id = "userNumber")
  WebElement userNumber;

  public PracticeFormPage enterPersonalData
      (String fName, String lName, String email, String phone) {
    type(firstName, fName);
    type(lastName, lName);
    type(userEmail, email);
    type(userNumber, phone);
    return this;
  }

  @FindBy(css = "[for='gender-radio-1']")
  WebElement male;

  @FindBy(css = "[for='gender-radio-2']")
  WebElement female;

  @FindBy(css = "[for='gender-radio-3']")
  WebElement other;

  public PracticeFormPage selectGender(String gender) {
    if (gender.equals("Male")) {
      click(male);
    } else if (gender.equals("Female")) {
      click(female);
    } else {
      click(other);
    }
    return this;
  }

  @FindBy(id = "dateOfBirthInput")
  WebElement dateOfBirthInput;

  public PracticeFormPage typeData(String bDay) {
    click(dateOfBirthInput);
    selectOS(dateOfBirthInput);
    dateOfBirthInput.sendKeys(bDay);
    dateOfBirthInput.sendKeys(Keys.ENTER);
    return this;
  }

  @FindBy(id = "subjectsInput")
  WebElement subjectsInput;

  public PracticeFormPage addSubject(String[] subject) {
    for (int i = 0; i < subject.length; i++) {
      if (subject[i] != null) {
        type(subjectsInput, subject[i]);
        subjectsInput.sendKeys(Keys.ENTER);
      }
    }
    return this;
  }

  @FindBy(css = "[for='hobbies-checkbox-1']")
  WebElement sports;

  @FindBy(css = "[for='hobbies-checkbox-2']")
  WebElement reading;

  @FindBy(css = "[for='hobbies-checkbox-3']")
  WebElement music;

  public PracticeFormPage selectHobby(String[] hobbies) {
    for (int i = 0; i < hobbies.length; i++) {
      if (hobbies[i].equals("Sports")) {
        click(sports);
      }
      if (hobbies[i].equals("Reading")) {
        click(reading);
      }
      if (hobbies[i].equals("Music")) {
        click(music);
      }
    }
    return this;
  }

  @FindBy(id = "uploadPicture")
  WebElement uploadPicture;

  public PracticeFormPage uploadFile(String path) {
    uploadPicture.sendKeys(path);
    return this;
  }

  @FindBy(id = "currentAddress")
  WebElement currentAddress;

  public PracticeFormPage enterAddress(String address) {
    type(currentAddress, address);
    return this;
  }

  @FindBy(id = "state")
  WebElement stateContainer;

  @FindBy(id = "react-select-3-input")
  WebElement inputState;

  public PracticeFormPage selectSatate(String state) {
    click(stateContainer);
    inputState.sendKeys(state);
    inputState.sendKeys(Keys.ENTER);
    return this;
  }

  @FindBy(id = "city")
  WebElement cityContainer;
  @FindBy(id = "react-select-4-input")
  WebElement cityInput;

  public PracticeFormPage selectCity(String city) {
    click(cityContainer);
    cityInput.sendKeys(city);
    cityInput.sendKeys(Keys.ENTER);
    return this;
  }

  @FindBy(id = "submit")
  WebElement submit;

  public PracticeFormPage submit() {
    click(submit);
    return this;
  }

  @FindBy(css = ".react-datepicker__month-select")
  WebElement month;

  @FindBy(css = ".react-datepicker__year-select")
  WebElement year;

  public PracticeFormPage selectDate(String m, String y, String day) {
    click(dateOfBirthInput);

    Select select = new Select(month);
    select.selectByVisibleText(m);

    Select select1 = new Select(year);
    select1.selectByVisibleText(y);

    wd.findElement(By.xpath("//div[.='" + day + "']")).click();

    return this;
  }
}
