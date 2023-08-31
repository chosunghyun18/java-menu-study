package menu.constants.enums.Menus;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.constants.enums.Category;

public enum ChineseMenu implements Menu {
  깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토_달걀볶음, 고추잡채;

  @Override
  public Category getCategory() {
    return Category.Chinese;
  }

  @Override
  public String getName() {
    return this.name().replace('_', ' ');
  }

  @Override
  public Menu pickRandomMenu() {
    return Randoms.shuffle(List.of(ChineseMenu.values())).get(0);
  }
}
