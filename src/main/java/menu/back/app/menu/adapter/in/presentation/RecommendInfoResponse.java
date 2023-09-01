package menu.back.app.menu.adapter.in.presentation;

import menu.back.app.coach.domain.Coach;
import menu.back.app.menu.domain.Category;

public class RecommendInfoResponse {
    Category category;
    Coach coach;
    public RecommendInfoResponse(Category category,Coach coach){
        this.category = category;
        this.coach = coach;
    }
    public Category getCategory() {
        return category;
    }
    public Coach getCoach() {
        return coach;
    }
}
