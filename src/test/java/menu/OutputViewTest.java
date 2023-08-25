package menu;

import java.util.List;
import java.util.Map;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void show_result_test(){
         Map<String, List<String>> coachesSelected = new TreeMap<>();
         coachesSelected.put("dog",List.of("apple","car"));
         coachesSelected.put("구구",List.of("appless","car"));

        coachesSelected.forEach((key, value) -> {
            String result = "[ " + key + " | " + String.join(" | ", value)+" ]";
            System.out.println(result);
        });
    }

}
