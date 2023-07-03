package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage{

  public SidePanel(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath="//span[.='Alerts']")
  WebElement alerts;

  public AlertsPage selectAlerts() {
    clickWithJSExecutor(alerts, 0, 300);
    return new AlertsPage(wd);
  }

  @FindBy(xpath = "//span[.='Browser Windows']")
  WebElement browserWindows;

  public BrowserWindowsPage selectBrowserWindows() {
    clickWithJSExecutor(browserWindows, 0, 300);
    return new BrowserWindowsPage(wd);
  }

  @FindBy(xpath = "//span[.='Select Menu']")
  WebElement selectMenu;

  public SelectMenuPage selectSelectMenu() {
    clickWithJSExecutor(selectMenu, 0, 600);
    return new SelectMenuPage(wd);
  }
}
