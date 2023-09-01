package menu.constants.enums.Menus;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.constants.enums.Category;

public enum JapaneseMenu implements Menu {
  규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼;

  @Override
  public Category getCategory() {
    return Category.일식;
  }

  @Override
  public String getName() {
    return this.name().replace('_', ' ');
  }
}
