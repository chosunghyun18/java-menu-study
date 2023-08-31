package menu.constants.enums.Menus;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.constants.enums.Category;

public interface Menu {
  Category getCategory();
  String getName();

  Menu pickRandomMenu();
}
