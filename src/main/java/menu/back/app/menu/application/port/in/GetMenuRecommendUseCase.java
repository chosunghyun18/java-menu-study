package menu.back.app.menu.application.port.in;

import menu.back.app.menu.adapter.in.presentation.RecommendInfoResponse;

public interface GetMenuRecommendUseCase {
    void initMenu();
    RecommendInfoResponse getRecommendMenu();
}
