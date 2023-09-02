package menu.back.app.coach.adapter.in.presentation;


import menu.back.app.coach.application.port.in.AddCoachDisLikeUseCase;
import menu.back.app.coach.application.port.in.AddCoachNameUseCase;
import menu.back.app.coach.application.service.AddCoachDislikeService;
import menu.back.app.coach.application.service.AddCoachNameService;

public class AddCoachController {
    private final AddCoachNameUseCase addCoachNameUseCase;
    private final AddCoachDisLikeUseCase addCoachDisLikeUseCase;

    public AddCoachController() {
        addCoachNameUseCase = new AddCoachNameService();
        addCoachDisLikeUseCase = new AddCoachDislikeService();
    }

    public void saveCoachesName(AddCoachNameRequest request) {
        addCoachNameUseCase.add(request);
    }

    public void saveCoachesDislike(AddCoachDisLikeRequest request) {
        addCoachDisLikeUseCase.add(request);
    }

}
