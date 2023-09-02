package menu.back.app.menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Menu {
    private List<String> jpm;
    private List<String> krm;
    private List<String> chm;
    private List<String> asm;
    private List<String> wesm;

    public Menu() {
        this.jpm = new ArrayList<>(List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        this.krm = new ArrayList<>(List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        this.chm = new ArrayList<>(List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        this.asm = new ArrayList<>(List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        this.wesm = new ArrayList<>(List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }
    public String getMenuFromMenus(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }

    public List<String> getOriginMenuByCategory(String category) {
        if ("일식 ".equals(category)) return jpm;
        if ("한식 ".equals(category)) return krm;
        if ("중식 ".equals(category)) return chm;
        if ("아시안 ".equals(category)) return asm;
        if ("양식 ".equals(category)) return wesm;
        throw new IllegalArgumentException("Invalid category: " + category);
    }
}
