package com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AdsFandomObject extends AdsBaseObject {

  public static final String TOP_LEADERBOARD = "TOP_LEADERBOARD";
  public static final String BOTTOM_LEADERBOARD = "BOTTOM_LEADERBOARD";
  public static final String TOP_BOXAD = "TOP_BOXAD";
  public static final String INCONTENT_BOXAD = "INCONTENT_BOXAD";
  public static final String BOTTOM_BOXAD = "BOTTOM_BOXAD";

  public static final Map<String, String> SLOT_SELECTORS;

  static {
    SLOT_SELECTORS = new HashMap<>();
    SLOT_SELECTORS.put(TOP_LEADERBOARD, "div[id$='TOP_LEADERBOARD_0__container__']");
    SLOT_SELECTORS.put(BOTTOM_LEADERBOARD, "div[id$='BOTTOM_LEADERBOARD_0__container__']");
    SLOT_SELECTORS.put(TOP_BOXAD, "div[id$='TOP_BOXAD_0__container__']");
    SLOT_SELECTORS.put(INCONTENT_BOXAD, "div[id$='INCONTENT_BOXAD_0__container__']");
    SLOT_SELECTORS.put(BOTTOM_BOXAD, "div[id$='BOTTOM_BOXAD_0__container__']");
  }

  @FindBy(css = "div[id$='TOP_LEADERBOARD_0__container__']")
  protected WebElement topLeaderboardElement;

  @FindBy(css = "div[id$='BOTTOM_LEADERBOARD_0__container__']")
  protected WebElement bottomLeaderboardElement;

  @FindBy(css = "div[id$='TOP_BOXAD_0__container__']")
  protected WebElement topBoxadElement;

  @FindBy(css = "div[id$='BOTTOM_BOXAD_0__container__']")
  protected WebElement bottomBoxadElement;

  public AdsFandomObject(WebDriver driver, String testedPage) {
    super(driver, testedPage);
  }

  public void verifyTopLeaderboard() {
    verifyAdVisibleInSlot(SLOT_SELECTORS.get(TOP_LEADERBOARD), topLeaderboardElement);
  }

  public void verifyBottomLeaderboard() {
    String selector = SLOT_SELECTORS.get(BOTTOM_LEADERBOARD);

    jsActions.scrollToElement(wait.forElementVisible(By.cssSelector(selector)));
    verifyAdVisibleInSlot(selector, bottomLeaderboardElement);
  }

  public void verifyTopBoxad() {
    String selector = SLOT_SELECTORS.get(TOP_BOXAD);

    jsActions.scrollToElement(wait.forElementVisible(By.cssSelector(selector)));
    verifyAdVisibleInSlot(selector, topBoxadElement);
  }

  public void verifyBottomBoxad() {
    String selector = SLOT_SELECTORS.get(BOTTOM_BOXAD);

    jsActions.scrollToElement(wait.forElementVisible(By.cssSelector(selector)));
    verifyAdVisibleInSlot(selector, bottomBoxadElement);
  }

  public WebElement getSlot(String slotName) {
    String selector = SLOT_SELECTORS.get(slotName);

    if (isElementOnPage(By.cssSelector(selector))) {
      return driver.findElement(By.cssSelector(selector));
    }

    return null;
  }
}
