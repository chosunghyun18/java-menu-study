package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateCategory {
    private final List<String> categoriesResult;

    public GenerateCategory(){
        this.categoriesResult = generateCategoriesResult();
    }

    public List<String> getCategoriesResult() {
        return this.categoriesResult;
    }

    private List<String> generateCategoriesResult(){
        List<String> categories = new ArrayList<>();
        for(int i=0; i<5; i++){
            String category;
            do{
                category = (FoodList.categories).get(Randoms.pickNumberInRange(1, 5));
            }while(countOccurrence(category, categories));
            categories.add(category);
        }
        return categories;
    }

    private boolean countOccurrence(String category, List<String> categories){
        return (categories.stream().filter(target -> target.equals(category)).count()>2);
    }
}
