package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateMenu {

    //월~금의 메뉴 생성
    //TODO
    //"일식", "한식", "중식", "아시안", "양식"
    public static List<String> generateMenu(List<String> categories, List<String> coachRestrictions){
        List<String> menus = new ArrayList<>();
        for(int i=0; i<5; i++){
            int index = FoodList.categories.indexOf(categories.get(i)) -1;
            List<String> selectMenus = new ArrayList<>(FoodList.menus.get(index));
            boolean b = true;
            String menu = null;
            while(b){
                menu = Randoms.shuffle(selectMenus).get(0);
                //예외처리 (중복, 못먹는 음식)
                if(notOverlapped(menu, menus) || cantEat(menu, coachRestrictions))
                    b = false;
            }
            menus.add(menu);
        }
        return menus;
    }

    //중복 안됐을 때
    private static boolean notOverlapped(String menu, List<String> menus) {
        long count = menus.stream().filter(target -> target.equals(menu)).count();
        return count==0;
    }

    //먹을수 있는 음식일 때
    private static boolean cantEat(String menu, List<String> restrict){
        return restrict.stream().noneMatch(target -> target.equals(menu));
    }

}
