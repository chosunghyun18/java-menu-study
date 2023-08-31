package menu.presentation;

import menu.constants.strings.OutputString;

public class OutputView {
  public static void Start() {
    System.out.println(OutputString.start);
    InputView.getCoach();
  }

  private static void Finish() {
    System.out.println("추천을 완료했습니다.");
  }

  private static void printResult() {
    System.out.println("추천 결과입니다.");
  }
}
