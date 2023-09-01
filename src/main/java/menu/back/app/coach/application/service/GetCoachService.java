package menu.back.app.coach.application.service;

import menu.back.app.coach.adapter.persistence.CoachPersistenceAdapter;
import menu.back.app.coach.adapter.presentation.CoachesNameInfoResponse;
import menu.back.app.coach.application.port.in.GetCoachNameUsecase;
import menu.back.app.coach.application.port.out.LoadCoachPort;
import menu.back.app.coach.converter.CoachConverter;
import menu.back.app.coach.domain.Coach;

public class GetCoachService implements GetCoachNameUsecase {

    private final LoadCoachPort loadCoachPort;
    public GetCoachService(){
        this.loadCoachPort = new CoachPersistenceAdapter();
    }

    @Override
    public CoachesNameInfoResponse getCoachesNameInfo() {
        Coach coach = loadCoachPort.getCoach();
        return CoachConverter.getCoachNameResponse(coach);
    }
}
