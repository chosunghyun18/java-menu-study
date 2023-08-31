package menu.model;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateMenu {
    private List<List<String>> menusResult;

    public GenerateMenu(List<String> coachNames, List<String> categories, List<List<String>> coachRestrictions){
        this.menusResult = initMenuList(coachNames);
        this.generateMenu(categories, coachRestrictions);
    }

    public List<List<String>> getMenusResult() {
        return menusResult;
    }

    private List<List<String>> initMenuList(List<String> coachNames){
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i<coachNames.size(); i++){
            result.add(new ArrayList<>());
            result.get(i).add(coachNames.get(i));
        }
        return result;
    }

    private void generateMenu(List<String> categories, List<List<String>> coachRestrictions){
        for(int i=0; i<5; i++){
            int index = FoodList.categories.indexOf(categories.get(i)) -1;
            generateIndividualMenu(index, coachRestrictions);


        }
    }

    private void generateIndividualMenu(int index, List<List<String>> coachRestrictions){
        for(int j=0; j<this.menusResult.size(); j++){
            List<String> selectMenus = new ArrayList<>(FoodList.menus.get(index));
            String menu;
            do{
                menu = Randoms.shuffle(selectMenus).get(0);
            }while(overlapped(menu, this.menusResult.get(j))||cantEat(menu, coachRestrictions.get(j)));
            this.menusResult.get(j).add(menu);
        }
    }

    //중복 됐을 때
    private static boolean overlapped(String menu, List<String> menus) {
        long count = menus.stream().filter(target -> target.equals(menu)).count();
        return count!=0;
    }

    //먹을수 없는 음식일 때
    private static boolean cantEat(String menu, List<String> restrict){
        return restrict.stream().anyMatch(target -> target.equals(menu));
    }

}
