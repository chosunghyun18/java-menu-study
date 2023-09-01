package menu.back.app.coach.application.service;

import java.util.List;
import menu.back.app.coach.adapter.persistence.CoachPersistenceAdapter;
import menu.back.app.coach.adapter.presentation.AddCoachNameRequest;
import menu.back.app.coach.application.port.in.AddCoachNameUseCase;
import menu.back.app.coach.application.port.out.LoadCoachPort;
import menu.back.app.coach.converter.CoachConverter;
import menu.back.app.coach.domain.Coach;

public class AddCoachNameService implements AddCoachNameUseCase {
    private final LoadCoachPort loadCoachPort;

    public AddCoachNameService() {
        this.loadCoachPort = new CoachPersistenceAdapter();
    }

    @Override
    public void add(AddCoachNameRequest addCoachRequest) {
        List<String> names =CoachConverter.getCoachNameFromRequest(addCoachRequest);
        Coach coach = loadCoachPort.getCoach();
        coach.storeCoaches(names);
    }
}
