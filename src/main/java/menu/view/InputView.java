package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public String coachNameInputMessage(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public List<String> foodThatCantEat(List<String> coachName){
        List<String> restrictions = new ArrayList<>();
        for(String name:coachName){
            System.out.println(name+ "(이)가 못 먹는 메뉴를 입력해 주세요.");
            restrictions.add(Console.readLine());
        }
        return restrictions;
    }
}
