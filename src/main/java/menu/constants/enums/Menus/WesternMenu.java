package menu.constants.enums.Menus;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.constants.enums.Category;

public enum WesternMenu implements Menu {
  라자냐, 그라탱, 뇨끼, 끼슈, 프렌치_토스트, 바게트, 스파게티, 피자, 파니니;

  @Override
  public Category getCategory() {
    return Category.Western;
  }

  @Override
  public String getName() {
    return this.name().replace('_', ' ');
  }

  @Override
  public Menu pickRandomMenu() {
    return Randoms.shuffle(List.of(WesternMenu.values())).get(0);
  }
}
