package menu.front.app.controller;

import java.util.ArrayList;
import java.util.List;

import menu.back.app.coach.adapter.presentation.AddCoachDisLikeRequest;
import menu.back.app.coach.adapter.presentation.AddCoachNameRequest;
import menu.back.app.coach.adapter.presentation.CoachController;
import menu.back.app.coach.adapter.presentation.CoachesNameInfoResponse;
import menu.back.app.menu.adapter.in.presentation.RecommendController;
import menu.back.app.menu.adapter.in.presentation.RecommendInfoResponse;

public class ViewController {

    private final InputViewController inputViewController;
    private final OutputViewController outputViewController;
    private final RecommendController recommendController; // call controller as like api
    private final CoachController coachController;

    public ViewController() {
        this.inputViewController= new InputViewController();
        this.outputViewController = new OutputViewController();
        this.recommendController = new RecommendController();
        this.coachController = new CoachController();
    }
    public void showIntroMessage() {
        outputViewController.showIntroMessage();
    }
    public void readCoachesInfo() {
        saveCoachesName();
        saveCoachesDislike();
    }
    public void saveCoachesName() {
        List<String> inputNames =  inputViewController.readCoachesName();
        AddCoachNameRequest request = new AddCoachNameRequest(inputNames);
        coachController.saveCoachesName(request);
    }

    public void saveCoachesDislike() {
        CoachesNameInfoResponse response = coachController.getCoachesNameInfo();
        List<List<String>> disLikesMenus = new ArrayList<>();
        for (int i = 0; i < response.numberOfCoaches(); i++) {
            String coachName = response.getName(i);     // 정석은 front 에서 파서 에서 한번 더 풀어줘야 할 것 같음
            List<String> dislikes = inputViewController.readCoachesDislike(coachName);
            disLikesMenus.add(dislikes);
        }
        AddCoachDisLikeRequest request = new AddCoachDisLikeRequest(disLikesMenus);
        coachController.saveCoachesDislike(request);
    }

    public void showResult() {
        RecommendInfoResponse recommendInfo = recommendController.getRecommendMenu();
        outputViewController.showEndMessage(recommendInfo.getCategory(),recommendInfo.getCoach());
    }
}
