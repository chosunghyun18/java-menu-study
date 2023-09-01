package menu.back.app.coach.adapter.persistence;

import menu.back.app.coach.application.port.out.LoadCoachPort;
import menu.back.app.coach.application.port.out.SaveCoachPort;
import menu.back.app.coach.domain.Coach;

public class CoachPersistenceAdapter implements SaveCoachPort, LoadCoachPort {

    @Override
    public Coach getCoach() {
        return CoachEntity.getCoach();
    }

    @Override
    public void add(Coach coach) {
        CoachEntity coachEntity = CoachEntity.getInstance(coach);
    }
}
