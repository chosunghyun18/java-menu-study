package menu.back.app.coach.adapter.in.presentation;

import menu.back.app.coach.application.port.in.GetCoachNameUsecase;
import menu.back.app.coach.application.service.GetCoachService;

public class GetCoachController {
    private final GetCoachNameUsecase getCoachNameUsecase;
    public GetCoachController(){
        this.getCoachNameUsecase = new GetCoachService();
    }
    public CoachesNameInfoResponse getCoachesNameInfo() {
        return getCoachNameUsecase.getCoachesNameInfo();
    }
}
