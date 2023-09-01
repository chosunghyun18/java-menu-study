package menu.service;

import static java.lang.System.exit;
import static menu.presentation.OutputView.result;
import static menu.service.MenuService.pickCategory;

import java.util.Arrays;
import java.util.List;
import menu.constants.enums.Category;
import menu.constants.enums.Day;
import menu.constants.enums.Menus.Menu;
import menu.constants.strings.ErrorString;
import menu.domain.Coach;
import menu.presentation.OutputView;

public class CoachService {
  public static Coach makeCoach(String name) throws IllegalArgumentException {
    Coach.validateName(name);
    return Coach.from(name);
  }
  public static Coach setImpossibleMenu(Coach coach, Menu menu) {
    coach.addImpossibleMenu(menu);
    return coach;
  }
}
