package menu.back.app.coach.adapter.presentation;

public class CoachController {
    private final AddCoachController addCoachController;
    private final GetCoachController getCoachController;
    public CoachController() {
        this.addCoachController = new AddCoachController();
        this.getCoachController = new GetCoachController();
    }
    public CoachesNameInfoResponse getCoachesNameInfo() {
        return getCoachController.getCoachesNameInfo();
    }

    public void saveCoachesName(AddCoachNameRequest request) {
        addCoachController.saveCoachesName(request);
    }

    public void saveCoachesDislike(AddCoachDisLikeRequest request) {
        addCoachController.saveCoachesDislike(request);
    }
}
