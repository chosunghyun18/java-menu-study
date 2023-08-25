package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class RecommendController {

    private int numberOfCoaches;
    private final Category categories;
    private final Coach coaches;
    private final Menu menu;
    private final ViewController viewController;

    public RecommendController() {
        viewController = new ViewController();
        coaches = new Coach();
        categories = new Category();
        menu = new Menu();
    }

    public void startRecommend() {
        viewController.showIntroMessage();
    }

    public void prosses() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)\n");
        readName();
        readDislike();
        recommendCategory();
        recommendMenu();
    }

    private void readName() {
        List<String> names = viewController.readCoachesName();
        this.numberOfCoaches = names.size();
        coaches.storeCoaches(names);
    }

    private void readDislike() {
        List<List<String>> disLikesMenus = new ArrayList<>();
        for (int i = 0; i < numberOfCoaches; i++) {
            List<String> dislikes = viewController.readCoachesDislike(coaches.getCoachesName(i));
            disLikesMenus.add(dislikes);
        }
        coaches.storeDislikeMenus(disLikesMenus);
    }

    private void recommendCategory() {
        categories.selectCategory();
    }

    private void recommendMenu() {
        for (int i = 0; i < 5; i++) {
            String category = categories.getCategoriesByDay(i);
            List<String> menusAll = menu.getOriginMenuByCategory(category);
            for (int j = 0; j < numberOfCoaches; j++) {
                boolean selceted = false;
                List<String> dislikes = coaches.getCoachesDislikeByOrder(j);
                while (!selceted) {
                    String menuSelected = menu.getMenuFromMenus(removeDislike(menusAll, dislikes));
                    if (storeSelected(menuSelected, j)) {
                        selceted = true;
                    }
                }
            }
        }
    }

    private boolean storeSelected(String menuSelected, int j) {
        String name = coaches.getCoachesName(j);
        if (coaches.isSelected(menuSelected, name)) {
            return false;
        }
        coaches.storeRecommand(menuSelected, name);
        return true;
    }

    private List<String> removeDislike(List<String> menusAll, List<String> dislikes) {
        for (String menuDilike : dislikes) {
            menusAll.remove(menuDilike);
        }
        return menusAll;
    }

    public void showResult() {
        viewController.showEndMessage(categories, coaches);
    }
}
