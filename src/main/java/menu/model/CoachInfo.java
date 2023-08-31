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
        //this.coachRestrictions = new ArrayList<>();
        //코치 인원을 알아야 init 가능...
    }

    public List<String> getCoachNames() {
        return coachNames;
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


}
