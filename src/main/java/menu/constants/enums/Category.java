package menu.constants.enums;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.InvocationTargetException;
import menu.constants.enums.Menus.AsianMenu;
import menu.constants.enums.Menus.ChineseMenu;
import menu.constants.enums.Menus.JapaneseMenu;
import menu.constants.enums.Menus.KoreanMenu;
import menu.constants.enums.Menus.Menu;
import menu.constants.enums.Menus.WesternMenu;

public enum Category {
  Korean(KoreanMenu.class),
  Japanese(JapaneseMenu.class),
  Chinese(ChineseMenu.class),
  Asian(AsianMenu.class),
  Western(WesternMenu.class);

  private final Class<? extends Menu> menuClass;

  Category(Class<? extends Menu> menuClass) {
    this.menuClass = menuClass;
  }
  public static Category pickRandomCategory() {
    return values()[Randoms.pickNumberInRange(1, 5) - 1];
  }

  public Menu pickRandomMenu() throws IllegalAccessException {
    try {
      return (Menu) menuClass.getMethod("pickRandomMenu").invoke(null);
    } catch (NoSuchMethodException | InvocationTargetException e) {
      throw new IllegalAccessException();
    }
  }
}
