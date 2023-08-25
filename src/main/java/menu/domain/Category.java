package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Category  {
    private List<String> categories ;

    public Category(){
        this.categories = new ArrayList<>(List.of("카테고리:","일식","한식","중식","중식","아시안","양식"));
    }

    public String getCategory(){
        return categories.get(Randoms.pickNumberInRange(1, 5));
    }
}
