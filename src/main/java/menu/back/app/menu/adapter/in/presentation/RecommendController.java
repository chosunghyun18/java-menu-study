package menu.back.app.menu.adapter.in.presentation;

import menu.back.app.menu.application.port.in.GetMenuRecommendUseCase;
import menu.back.app.menu.application.service.GetMenuService;

public class RecommendController {
    private final GetMenuRecommendUseCase getMenuRecommendUseCase;

    public RecommendController() {
        this.getMenuRecommendUseCase = new GetMenuService();
    }
    public RecommendInfoResponse getRecommendMenu() {
        return getMenuRecommendUseCase.getRecommendMenu();
    }


}
