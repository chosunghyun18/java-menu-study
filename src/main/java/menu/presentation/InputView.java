package menu.presentation;

import static menu.service.CoachService.recommendMenu;
import static menu.service.CoachService.setImpossibleMenu;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.constants.strings.ErrorString;
import menu.constants.strings.InputString;
import menu.domain.Coach;
import menu.service.CoachService;
import menu.service.MenuService;

public class InputView {

  static void getCoach() {
    boolean validInput = false;
    while (!validInput) {
      try {
        System.out.println(InputString.REQUIRE_COACH);
        getImpossibleMenu(
            Arrays.stream(Console.readLine().trim().split(","))
                .map(CoachService::makeCoach)
                .collect(Collectors.toList())
        );
        validInput = true; // Input was successfully processed without errors
      } catch (IllegalArgumentException e) {
        System.out.println(ErrorString.INVALID_COACH);
      }
    }
  }

  static void getImpossibleMenu(List<Coach> coaches) {
    coaches
        .forEach(c -> {
          boolean validInput = false;
          while (!validInput) {
            System.out.println(c.getName() + InputString.INPUT_IMPOSSIBLE_MENU);
            try {
              Arrays.stream(Console.readLine().trim().split(","))
                  .map(MenuService::getMenu)
                  .forEach(menu -> setImpossibleMenu(c, menu));
              validInput = true; // Input was successfully processed without errors
            } catch (IllegalArgumentException e) {
              System.out.println(ErrorString.INVALID_MENU);
            }
          }
        });
    recommendMenu(coaches);
  }
}
