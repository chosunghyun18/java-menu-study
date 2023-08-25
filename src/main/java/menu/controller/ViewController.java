package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
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

    public void showEndMessage(Category categories, Coach coach) {
        System.out.println("메뉴 추천 결과입니다.");
        List<String> days = new ArrayList<>(List.of(" 구분 ", "월요일 ", "화요일 ", "수요일 ", "목요일 ", "금요일 "));
        System.out.println(days.toString().replace(",", "|"));
        System.out.println(categories.getSelectedForResult().toString().replace(",", "|"));
        showSelectedMenuForCoaches(coach);
        System.out.println("추천을 완료했습니다.");
    }

    private void showSelectedMenuForCoaches(Coach coach) {
        Map<String, List<String>> coachesSelected =coach.getCoacheSelectedForShow();
        coachesSelected.forEach((key, value) -> {
            String result = "[ " + key + " | " + String.join(" | ", value)+" ]";
            System.out.println(result);
        });
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

    public List<String> readCoachesDislike(String name) {
        try {
            System.out.println(name+"(이)가 못 먹는 메뉴를 입력해 주세요.");
            String given = inputView.readDisLike();
            return validateDislike(given);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERORR]" + e);
            return readCoachesDislike(name);
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
