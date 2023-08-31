package menu.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void startMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void weekdayMessage(List<String> weekday){
        System.out.println("메뉴 추천 결과입니다.");
        String result = String.join(" | ", weekday);
        System.out.println("[ "+ result+ " ]");
    }

    public void categoryOutcomeMessage(List<String> categories){
        List<String> s = new ArrayList<>(categories);
        s.add(0, "카테고리");
        String result = String.join(" | ", s);
        System.out.println("[ "+ result+ " ]");
    }

    public void menuOutcomeMessage(List<List<String>> menus){
        menus.stream().map(individualMenu -> String.join(" | ", individualMenu)).map(result -> "[ " + result + " ]").forEach(System.out::println);
    }

    public void endMessage(){
        System.out.println("\n추천을 완료했습니다.");
    }

    public void errorMessage(String e){
        System.out.println("[ERROR] " + e);
    }
}
