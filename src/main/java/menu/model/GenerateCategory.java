package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateCategory {
    private List<String> categoriesResult;

    public GenerateCategory(){
        this.categoriesResult = generateCategoriesResult();
    }

    public List<String> getCategoriesResult() {
        return categoriesResult;
    }

    private List<String> generateCategoriesResult(){
        List<String> categories = new ArrayList<>();
        String category;
        do{
            category = FoodList.categories.get(Randoms.pickNumberInRange(0, 4));
        }while(countOccurrence(category, categories) > 2);
        categories.add(category);
        return categories;
    }

    private long countOccurrence(String category, List<String> categories){
        return categories.stream().filter(target -> target.equals(category)).count();
    }

}
