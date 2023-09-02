package menu.back.app.coach.application.service;

import java.util.List;
import menu.back.app.coach.adapter.out.persistence.CoachPersistenceAdapter;
import menu.back.app.coach.adapter.in.presentation.AddCoachDisLikeRequest;
import menu.back.app.coach.application.port.in.AddCoachDisLikeUseCase;
import menu.back.app.coach.application.port.out.LoadCoachPort;
import menu.back.app.coach.converter.CoachConverter;
import menu.back.app.coach.domain.Coach;

public class AddCoachDislikeService implements AddCoachDisLikeUseCase {
    private final LoadCoachPort loadCoachPort;

    public AddCoachDislikeService() {
        this.loadCoachPort = new CoachPersistenceAdapter();
    }
    @Override
    public void add(AddCoachDisLikeRequest request) {
        List<List<String>> dislikes = CoachConverter.getCoachDislikeFromRequest(request);
        Coach coach = loadCoachPort.getCoach();
        coach.storeDislikeMenus(dislikes);
    }
}
