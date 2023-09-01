package menu.domain;

import static java.lang.System.exit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.constants.enums.Menus.Menu;

public class Coach {

  private String name;
  private List<Menu> impossibleMenus = new ArrayList<>();;
  private List<Menu> recommendedMenus = new ArrayList<>();;

  private Coach(String name) {
    this.name = name;
  }

  public static Coach from(String name) {
    return new Coach(validateName(name));
  }

  public String getName() {
    return this.name;
  }

  public static String validateName(String name) throws IllegalArgumentException {
    if (name.length() < 2 || name.length() > 4) {
      throw new IllegalArgumentException();
    }
    return name;
  }

  public Menu validateMenu(Menu menu) throws IllegalStateException {
    if (impossibleMenus.contains(menu) || recommendedMenus.contains(menu)) {
      throw new IllegalStateException();
    }
    return menu;
  }
  public void addImpossibleMenu(Menu menu) {
    this.impossibleMenus.add(menu);
  }

  public void addRecommendMenu(Menu menu) throws IllegalStateException {
    this.recommendedMenus.add(validateMenu(menu));
  }
  public List<Menu> getRecommendMenus() {
    return this.recommendedMenus;
  }
}
