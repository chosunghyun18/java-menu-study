package menu.presentation;

import java.util.List;
import java.util.stream.Collectors;
import menu.constants.enums.Day;
import menu.constants.enums.Menus.Menu;
import menu.constants.strings.OutputString;
import menu.domain.Coach;

public class OutputView {

  public static void start() {
    System.out.println(OutputString.START);
    InputView.getCoach();
  }

  public static void result(List<Day> days, List<Coach> coaches) {
    System.out.println(OutputString.RESULT);
    System.out.println("[ 구분 | " + days.stream()
        .map(Day::toString)
        .collect(Collectors.joining(" | ")) + " ]");
    System.out.println("[ 카테고리 | " + days.stream()
        .map(day -> day.getCategory().getName())
        .collect(Collectors.joining(" | ")) + " ]");
    coaches.forEach(
        coach -> System.out.println("[ " + coach.getName() + " | " + coach.getRecommendMenus().stream()
            .map(Menu::getName)
            .collect(Collectors.joining(" | ")) + " ]"));
    System.out.println();
    finish();
  }

  private static void finish() {
    System.out.println(OutputString.FINISH);
  }
}
