package menu.front.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.back.app.coach.domain.Coach;
import menu.back.app.menu.domain.Category;
import menu.front.resources.view.OutputView;

public class OutputViewController {
    List<String> days ;
    private final OutputView outputView ;
    public OutputViewController(){
        this.outputView = new OutputView();
        days = new ArrayList<>(List.of(" 구분 ", "월요일 ", "화요일 ", "수요일 ", "목요일 ", "금요일 "));
    }
    public void showIntroMessage() {
        outputView.showIntroMessage();
    }

    public void showEndMessage(Category categories, Coach coach) {
        outputView.showResultIntroMessage();
        outputView.showDaysHeader(days.toString().replace(",", "|"));
        List<String>  categoriesResult =  categories.getSelectedForResult();
        outputView.showCategoriesResult(categoriesResult.toString().replace(",", "|"));
        showSelectedMenuForCoaches(coach);
        outputView.showEndRecommendMessage();
    }

    private void showSelectedMenuForCoaches(Coach coach) {
        Map<String, List<String>> coachesSelected = coach.getCoacheSelectedForShow();
        coachesSelected.forEach((key, value) -> {
            String result = "[ " + key + " | " + String.join(" | ", value) + " ]";
            outputView.showSelectedMenuForCoaches(result);
        });
    }


}
