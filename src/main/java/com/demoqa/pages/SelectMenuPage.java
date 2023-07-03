package com.demoqa.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage extends BasePage{

  public SelectMenuPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id = "oldSelectMenu")
  WebElement oldSelectMenu;

  public SelectMenuPage selectOldStyle(String color) {

    Select select = new Select(oldSelectMenu);
    select.selectByVisibleText(color);

    List<WebElement> options = select.getOptions();
    System.out.println(select.getFirstSelectedOption().getText() + " is first");

    for (int i= 0; i < options.size(); i++) {
      System.out.println(options.get(i).getText());
    }

    return this;
  }
}
