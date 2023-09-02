package menu.back.app.coach.adapter.in.presentation;

import java.util.List;

public class AddCoachDisLikeRequest {
    private List<List<String>> disLikesMenus ;
    public AddCoachDisLikeRequest(List<List<String>> given){
        this.disLikesMenus = given;
    }

    public List<List<String>> getDislikes() {
        return disLikesMenus;
    }
}
