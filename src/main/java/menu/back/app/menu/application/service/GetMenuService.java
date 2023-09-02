package menu.back.app.menu.application.service;

import java.util.List;
import menu.back.app.coach.adapter.persistence.CoachPersistenceAdapter;
import menu.back.app.coach.application.port.out.LoadCoachPort;

import menu.back.app.coach.domain.Coach;
import menu.back.app.menu.adapter.in.presentation.RecommendInfoResponse;
import menu.back.app.menu.adapter.out.persistence.GetCategoryPersistenceAdapter;
import menu.back.app.menu.adapter.out.persistence.GetMenuPersistenceAdapter;
import menu.back.app.menu.adapter.out.persistence.SaveCategoryPersistenceAdapter;
import menu.back.app.menu.adapter.out.persistence.SaveMenuPersistenceAdapter;
import menu.back.app.menu.application.port.in.GetMenuRecommendUseCase;
import menu.back.app.menu.application.port.out.LoadCategoryPort;
import menu.back.app.menu.application.port.out.LoadMenuPort;
import menu.back.app.menu.application.port.out.SaveCategoryPort;
import menu.back.app.menu.application.port.out.SaveMenuPort;
import menu.back.app.menu.domain.Category;
import menu.back.app.menu.domain.Menu;

public class GetMenuService implements GetMenuRecommendUseCase {
    private final LoadMenuPort loadMenuPort;
    private final SaveMenuPort saveMenuPort;
    private final LoadCoachPort loadCoachPort;
    private final LoadCategoryPort loadCategoryPort;
    private final SaveCategoryPort saveCategoryPort;

    public GetMenuService(){
        this.loadMenuPort = new GetMenuPersistenceAdapter();
        this.saveMenuPort = new SaveMenuPersistenceAdapter();
        this.loadCoachPort = new CoachPersistenceAdapter();
        this.loadCategoryPort = new GetCategoryPersistenceAdapter();
        this.saveCategoryPort = new SaveCategoryPersistenceAdapter();
        initMenu();
    }

    @Override
    public void initMenu() {
        saveMenuPort.add(new Menu());
        saveCategoryPort.add(new Category());
    }

    @Override
    public RecommendInfoResponse getRecommendMenu() {
        Coach coaches = loadCoachPort.getCoach();
        Menu menu = loadMenuPort.getMenu();
        Category categories = loadCategoryPort.getCategory();
        int numberOfCoaches = coaches.numberOfCoaches();
        for (int i = 0; i < 5; i++) {
            String category = categories.getCategoriesByDay(i);
            List<String> menusAll = menu.getOriginMenuByCategory(category);
            for (int j = 0; j < numberOfCoaches; j++) {
                boolean selceted = false;
                List<String> dislikes = coaches.getCoachesDislikesBySequence(j);
                while (!selceted) {
                    String menuSelected = menu.getMenuFromMenus(removeDislike(menusAll, dislikes));
                    if (storeSelected(menuSelected, j,coaches)) {
                        selceted = true;
                    }
                }
            }
        }
        return new RecommendInfoResponse(categories,coaches);
    }
    private List<String> removeDislike(List<String> menusAll, List<String> dislikes) {
        for (String menuDilike : dislikes) {
            menusAll.remove(menuDilike);
        }
        return menusAll;
    }

    private boolean storeSelected(String menuSelected, int j,Coach coaches) {
        String name = coaches.getCoachesName(j);
        if (coaches.isSelected(menuSelected, name)) {
            return false;
        }
        coaches.storeRecommand(menuSelected, name);
        return true;
    }
}
