package menu.back.app.coach.adapter.presentation;

import java.util.List;

public class AddCoachNameRequest {
    private final List<String> coachesName;
    public AddCoachNameRequest(List<String> given) {
        coachesName = given;
    }
    public List<String> getCoachesName() {
        return coachesName;
    }
}
