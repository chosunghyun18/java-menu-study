package menu.constants.enums.Menus;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.constants.enums.Category;

public enum AsianMenu implements Menu {
  팟타이, 카오_팟, 나시고렝, 파인애플_볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜;

  @Override
  public Category getCategory() {
    return Category.아시안;
  }

  @Override
  public String getName() {
    return this.name().replace('_', ' ');
  }
}