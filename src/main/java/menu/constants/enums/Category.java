package menu.constants.enums;

import static java.lang.System.exit;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import menu.constants.enums.Menus.AsianMenu;
import menu.constants.enums.Menus.ChineseMenu;
import menu.constants.enums.Menus.JapaneseMenu;
import menu.constants.enums.Menus.KoreanMenu;
import menu.constants.enums.Menus.Menu;
import menu.constants.enums.Menus.WesternMenu;

public enum Category {
  한식(KoreanMenu.class),
  일식(JapaneseMenu.class),
  중식(ChineseMenu.class),
  아시안(AsianMenu.class),
  양식(WesternMenu.class);
  private final Class<? extends Menu> menuClass;

  Category(Class<? extends Menu> menuClass) {
    this.menuClass = menuClass;
  }

  public static Category pickRandomCategory() {
    return values()[Randoms.pickNumberInRange(1, 5) - 1];
  }

  public Menu pickRandomMenu() throws IllegalAccessException {
    try {
      Menu[] menus = (Menu[]) menuClass.getMethod("values").invoke(null);
      return Randoms.shuffle(Arrays.asList(menus)).get(0);
    } catch (NoSuchMethodException | InvocationTargetException e) {
      throw new IllegalStateException();
    }
  }

  public String getName() {
    return this.name();
  }
}
