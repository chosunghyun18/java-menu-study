package menu.back.app.menu.adapter.in.presentation;

import java.util.List;

public class RecommendController {

    public RecommendController() {

    }
    public RecommendInfoResponse getRecommendMenu() {
//        recommendCategory();
//        recommendMenu();
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
    private List<String> removeDislike(List<String> menusAll, List<String> dislikes) {
        for (String menuDilike : dislikes) {
            menusAll.remove(menuDilike);
        }
        return menusAll;
    }

    private boolean storeSelected(String menuSelected, int j) {
        String name = coaches.getCoachesName(j);
        if (coaches.isSelected(menuSelected, name)) {
            return false;
        }
        coaches.storeRecommand(menuSelected, name);
        return true;
    }

}
