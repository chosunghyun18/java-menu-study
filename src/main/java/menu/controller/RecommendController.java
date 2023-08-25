package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;

public class RecommendController {
// 흐름 관리 및 객체 생성 , 값 전달 +  최소한의 비즈니스 로직
    private int numberOfCoaches;
    private final ViewController viewController;
    private final Coach coaches;
    public RecommendController() {
        viewController = new ViewController();
        coaches = new Coach();
    }

    public void startRecommend() {
        viewController.showIntroMessage();
    }

    public void prosses() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)\n");
        List<String> names = viewController.readCoachesName();
        this.numberOfCoaches = names.size();
        coaches.storeCoaches(names);
        readDislike();
        recommendMenu();
    }

    private void readDislike() {
        List<List<String>> disLikesMenus = new ArrayList<>();
        // get dislikes menu in order of caches
        for (int i = 0; i < numberOfCoaches; i++) {
            List<String> dislikes = viewController.readCoachesDislike();
            disLikesMenus.add(dislikes);
        }
        coaches.storeDislikeMenus(disLikesMenus);
    }


    private void recommendMenu() {

    }

    public void showResult() {

    }
}
