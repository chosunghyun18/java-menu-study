package menu.back.app.coach.adapter.persistence;

import menu.back.app.coach.application.port.out.LoadCoachPort;
import menu.back.app.coach.application.port.out.SaveCoachPort;
import menu.back.app.coach.domain.Coach;

//JPA 이용시 세부적으로 분할이 필요함
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
