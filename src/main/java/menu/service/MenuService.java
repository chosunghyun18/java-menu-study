package menu.service;

import static java.lang.System.exit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import menu.constants.enums.Category;
import menu.constants.enums.Day;
import menu.constants.enums.Menus.AsianMenu;
import menu.constants.enums.Menus.ChineseMenu;
import menu.constants.enums.Menus.JapaneseMenu;
import menu.constants.enums.Menus.KoreanMenu;
import menu.constants.enums.Menus.Menu;
import menu.constants.enums.Menus.WesternMenu;
import menu.domain.Coach;
import menu.presentation.OutputView;

public class MenuService {

  public static Menu getMenu(String name) throws IllegalArgumentException {
    List<Menu> allMenus = new ArrayList<>();
    allMenus.addAll(Arrays.asList(KoreanMenu.values()));
    allMenus.addAll(Arrays.asList(JapaneseMenu.values()));
    allMenus.addAll(Arrays.asList(ChineseMenu.values()));
    allMenus.addAll(Arrays.asList(AsianMenu.values()));
    allMenus.addAll(Arrays.asList(WesternMenu.values()));
    for (Menu menu : allMenus) {
      if (Objects.equals(menu.getName(), name)) {
        return menu;
      }
    }
    throw new IllegalArgumentException();
  }

  public static void recommendMenu(List<Coach> coaches) {
    Category category = null;
    for (Day day : Day.values()) {
      boolean valid = false;
      while (!valid) {
        try {
          category = pickCategory();
          day.setCategory(category);
          for (Coach coach : coaches) {
            Menu menu = category.pickRandomMenu();
            coach.addRecommendMenu(menu);
          }
          valid = true;
        } catch (IllegalStateException | IllegalAccessException e) {
          //
        }
      }
    }
    OutputView.result(Arrays.asList(Day.values()), coaches);
  }

  public static Category pickCategory() {
    return Category.pickRandomCategory();
  }
}
