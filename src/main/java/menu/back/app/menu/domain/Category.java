package menu.back.app.menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Category  {
    private List<String> originCategories ;
    private List<String> selectedCategories;

    public Category(){
        this.originCategories = new ArrayList<>(List.of(" 카테고리 ","일식 ","한식 ","중식 ","아시안 ","양식 "));
        selectedCategories = new ArrayList<>();
        selectCategory();
    }
    public String getCategoryInRandom(){
        return originCategories.get(Randoms.pickNumberInRange(1, 5));
    }

    public List<String> getSelectedForResult() {
        List<String> result = new ArrayList<>();
        result.add(originCategories.get(0));
        result.addAll(selectedCategories);
        return result;
    }
    public String getCategoriesByDay(int day){
        return selectedCategories.get(day);
    }

    void selectCategory() {
        while (selectedCategories.size()!= 5) {
            String category = getCategoryInRandom() ;
            if(selectedCategories.contains(category)){
                if(categoryOverOne(category)){
                    continue;
                }
            }
            selectedCategories.add(category);
        }
    }

    boolean categoryOverOne(String category) {
        long count = selectedCategories.stream().filter(cat -> cat.equals(category)).count();
        return count > 1;
    }

}
