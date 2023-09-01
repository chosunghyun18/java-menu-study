package menu.back.app.coach.converter;

import java.util.List;
import menu.back.app.coach.adapter.persistence.CoachEntity;
import menu.back.app.coach.adapter.presentation.AddCoachDisLikeRequest;
import menu.back.app.coach.adapter.presentation.AddCoachNameRequest;
import menu.back.app.coach.adapter.presentation.CoachesNameInfoResponse;
import menu.back.app.coach.domain.Coach;

public class CoachConverter {
    public static CoachesNameInfoResponse getCoachNameResponse(Coach coach) {
        return new CoachesNameInfoResponse(coach.getCoachesNames());
    }
    public static Coach toCoach(CoachEntity coachEntity) {
        return coachEntity.getCoach();
    }
    public static CoachEntity  toCoachEntity(Coach coach) {
        return CoachEntity.getInstance(coach);
    }

    public static List<String> getCoachNameFromRequest(AddCoachNameRequest addCoachRequest) {
        return addCoachRequest.getCoachesName();
    }


    public static List<List<String>> getCoachDislikeFromRequest(AddCoachDisLikeRequest request) {
        return request.getDislikes();
    }
}
