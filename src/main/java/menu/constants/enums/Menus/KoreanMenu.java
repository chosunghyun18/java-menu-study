package menu.constants.enums.Menus;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import menu.constants.enums.Category;

public enum KoreanMenu implements Menu {
  김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음;

  @Override
  public Category getCategory() {
    return Category.한식;
  }

  @Override
  public String getName() {
    return this.name().replace('_', ' ');
  }
}
