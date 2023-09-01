package menu.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Utils {
  public static String[] Input() {
    return Arrays.stream(Console.readLine().split(","))
        .map(String::trim)
        .toArray(String[]::new);
  }
}
