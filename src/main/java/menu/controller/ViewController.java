package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;

public class ViewController {

    private final InputView inputView;
    private final OutputView outputView;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void showIntroMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void showEndMessage(List<String> categories, List<List<String>> selected) {
        List<String> days = new ArrayList<>(List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일"));
        System.out.println(days.toString().replace(",", "|"));
        System.out.println(categories.toString().replace(",", "|"));
    }

    public List<String> readCoachesName() {
        try {
            String given = inputView.readCoachesName();
            return validateCoachesName(given);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERORR]" + e);
            return readCoachesName();
        }
    }

    public List<String> readCoachesDislike() {
        try {
            String given = inputView.readDisLike();
            return validateDislike(given);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERORR]" + e);
            return readCoachesDislike();
        }
    }

    // validate and parser string to list
    private List<String> validateDislike(String given) {
        return List.of(given.split(","));
    }

    private List<String> validateCoachesName(String given) {
        return List.of(given.split(","));
    }


}
