package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Category  {
    private List<String> originCategories ;
    private List<String> selectedCategories;

    public Category(){
        this.originCategories = new ArrayList<>(List.of("카테고리","일식","한식","중식","중식","아시안","양식"));
    }

    public String getCategory(){
        return originCategories.get(Randoms.pickNumberInRange(1, 5));
    }

    public List<String> getSelectedForResult() {
        return selectedCategories;
    }
}
