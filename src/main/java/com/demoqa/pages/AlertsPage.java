package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{

  public AlertsPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id="promtButton")
  WebElement promtButton;

  public AlertsPage sendMessageToAlert(String message) {
    click(promtButton);

    if (message != null) {
      wd.switchTo().alert().sendKeys(message);
      wd.switchTo().alert().accept();
    }
    return this;
  }

  @FindBy(id = "promptResult")
  WebElement promptResult;

  public AlertsPage assertMessage(String message) {
    Assert.assertTrue(promptResult.getText().contains(message));
    return this;
  }

  @FindBy(id = "alertButton")
  WebElement alertButton;

  public AlertsPage clickSimpleAllertButton() {
    click(alertButton);
    return this;
  }

  public void clickOkInAllert() {
    wd.switchTo().alert().accept();
  }

  @FindBy(id = "timerAlertButton")
  WebElement timerAlertButton;

  public AlertsPage clickOnAlertWithDelayButton() {
    click(timerAlertButton);
    pause(6000);
    return this;
  }

  @FindBy(id = "confirmButton")
  WebElement confirmButton;

  public AlertsPage clickAlertWithConfirm() {
    click(confirmButton);
    wd.switchTo().alert().accept();
    return this;
  }

  @FindBy(id = "confirmResult")
  WebElement confirmResult;

  public AlertsPage assertConfirmAlert() {
    Assert.assertTrue(confirmResult.getText().contains("Ok"));
    return this;
  }
}
