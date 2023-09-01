package menu.presentation;

import static menu.service.CoachService.setImpossibleMenu;
import static menu.service.MenuService.recommendMenu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.constants.enums.Menus.Menu;
import menu.constants.strings.ErrorString;
import menu.constants.strings.InputString;
import menu.domain.Coach;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.utils.Utils;

public class InputView {
  public static String[] validateCoaches(String[] coaches) throws IllegalArgumentException {
    if (coaches.length < 2 || coaches.length > 5) {
      throw new IllegalArgumentException(ErrorString.INVALID_COACH_NUMBER);
    }
    for (String coach : coaches) {
      if (coach.length() < 2 || coach.length() > 4) {
        throw new IllegalArgumentException(ErrorString.INVALID_COACH_NAME);
      }
    }
    return coaches;
  }

  public static List<Menu> validateMenus(String[] menus) throws IllegalArgumentException {
    if (menus.length > 2) {
      throw new IllegalArgumentException(ErrorString.INVALID_MENU_NUMBER);
    }

    return Arrays.stream(menus)
        .map(MenuService::getMenu)
        .collect(Collectors.toList());
  }
  static void getCoach() {
    boolean valid = false;
    while (!valid) {
      try {
        System.out.println(InputString.REQUIRE_COACH);
        getImpossibleMenu(
            Arrays.stream(validateCoaches(Utils.Input()))
                .map(CoachService::makeCoach)
                .collect(Collectors.toList())
        );
        valid = true;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  static void getImpossibleMenu(List<Coach> coaches) {
    coaches
        .forEach(c -> {
          boolean valid = false;
          while (!valid) {
            System.out.println(c.getName() + InputString.INPUT_IMPOSSIBLE_MENU);
            try {
              validateMenus(Utils.Input())
                  .forEach(menu -> setImpossibleMenu(c, menu));
              valid = true;
            } catch (IllegalArgumentException e) {
              System.out.println(e.getMessage());
            }
          }
        });
    recommendMenu(coaches);
  }
}
