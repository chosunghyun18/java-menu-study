package menu.service;

import static menu.service.MenuService.pickCategory;

import java.util.List;
import menu.constants.enums.Category;
import menu.constants.enums.Day;
import menu.constants.enums.Menus.Menu;
import menu.domain.Coach;
public class CoachService {
  public static Coach makeCoach(String name) throws IllegalArgumentException {
    Coach.validateName(name);
    return Coach.from(name);
  }
  public static Coach setImpossibleMenu(Coach coach, Menu menu) {
    coach.addImpossibleMenu(menu);
    return coach;
  }

  public static List<Coach> recommendMenu(List<Coach> coaches) {
    for (Day day : Day.values()) {
      boolean invalidMenu = false;
      Category category = null;
      while(invalidMenu) {
        try {
          category = pickCategory();
          for (Coach coach : coaches) {
            Menu menu = category.pickRandomMenu();
            coach.addRecommendedMenu(menu);
          }
        } catch (IllegalStateException | IllegalAccessException e) {
          invalidMenu = true;
        }
      }
      day.setCategory(category);
    }
    return coaches;
  }
}
