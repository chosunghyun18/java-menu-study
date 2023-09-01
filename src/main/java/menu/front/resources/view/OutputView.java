package menu.front.resources.view;

public class OutputView<T> {
    public void showIntroMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    public void showResultIntroMessage() {
        System.out.println("메뉴 추천 결과입니다.");
    }
    public void showDaysHeader(T data) {
        System.out.println(data);
    }
    public void showCategoriesResult(T data) {
        System.out.println(data);
    }

    public void showEndRecommendMessage() {
        System.out.println("추천을 완료했습니다.");
    }
    public void showSelectedMenuForCoaches(String selectedMenuResult) {
        System.out.println(selectedMenuResult);
    }
}
