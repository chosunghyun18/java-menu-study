package menu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.constants.enums.Category;
import menu.constants.enums.Menus.AsianMenu;
import menu.constants.enums.Menus.ChineseMenu;
import menu.constants.enums.Menus.JapaneseMenu;
import menu.constants.enums.Menus.KoreanMenu;
import menu.constants.enums.Menus.Menu;
import menu.constants.enums.Menus.WesternMenu;

public class MenuService {
    public static Menu getMenu(String name) throws IllegalArgumentException {
      List<Menu> allMenus = new ArrayList<>();
      allMenus.addAll(Arrays.asList(KoreanMenu.values()));
      allMenus.addAll(Arrays.asList(JapaneseMenu.values()));
      allMenus.addAll(Arrays.asList(ChineseMenu.values()));
      allMenus.addAll(Arrays.asList(AsianMenu.values()));
      allMenus.addAll(Arrays.asList(WesternMenu.values()));
      for (Menu menu : allMenus) {
        if (menu.getName().equalsIgnoreCase(name)) {
          return menu;
        }
      }
      throw new IllegalArgumentException();
    }

    public static Category pickCategory() {
      return Category.pickRandomCategory();
    }
}
