package menu.back.app.coach.adapter.persistence;

import menu.back.app.coach.domain.Coach;

public class CoachEntity {

    private static CoachEntity instance = null;
    private static Coach coach;

    private CoachEntity(Coach coach) {
        this.coach = coach;
    }

    public static CoachEntity getInstance(Coach coach) {
        if(instance == null) {
            instance = new CoachEntity(coach);
        }
        return instance;
    }

    public static Coach getCoach() {
        return coach;
    }
}
