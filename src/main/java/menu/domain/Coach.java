package menu.domain;

import java.util.List;
import menu.constants.enums.Menus.Menu;

public class Coach {

  private String name;
  private List<Menu> impossibleMenus;
  private List<Menu> recommendedMenus;

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

  public void addRecommendedMenu(Menu menu) {
    this.recommendedMenus.add(menu);
  }


}
