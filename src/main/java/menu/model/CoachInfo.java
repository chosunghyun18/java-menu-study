package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoachInfo {
    private List<String> coachNames;
    private List<List<String>> coachRestrictions;

    public CoachInfo(){
        this.coachNames = new ArrayList<>();
        this.coachRestrictions = new ArrayList<>();
    }

    public List<String> getCoachNames() {
        return coachNames;
    }

    public List<List<String>> getCoachRestrictions(){
        return coachRestrictions;
    }

    public void validateCoachNumber(String coachString){
        List<String> coaches = Arrays.stream(coachString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        if(coaches.size() <2 || coaches.size() >5)
            throw new IllegalArgumentException("2~5명의 코치를 입력해주세요.");
        validateCoachNameLength(coaches);
    }

    private void validateCoachNameLength(List<String> coaches){
        for(String coach:coaches){
            if(coach.length() <2 || coach.length()>4)
                throw new IllegalArgumentException("각 코치의 이름은 2~4글자로 입력해주세요.");
        }
        this.coachNames = coaches;
    }

    public void validateCoachRestrictionNumber(String foodString){
        List<String> foods = Arrays.stream(foodString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        if(foods.size()>2)
            throw new IllegalArgumentException("0~2개의 메뉴를 입력해주세요.");
        validateCoachRestrictionMenu(foods);
    }

    private void validateCoachRestrictionMenu(List<String> foods){
        List<String> notInMenu = foods.stream()
                .filter(food -> FoodList.menus.stream().noneMatch(category -> category.contains(food)))
                .collect(Collectors.toList());
        if (!notInMenu.isEmpty() && !foods.get(0).isEmpty())
            throw new IllegalArgumentException("입력한 메뉴가 메뉴판에 존재하지 않습니다.");
        this.coachRestrictions.add(foods);
    }

}
