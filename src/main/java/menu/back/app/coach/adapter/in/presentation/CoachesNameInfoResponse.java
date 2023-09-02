package menu.back.app.coach.adapter.in.presentation;

import java.util.List;

public class CoachesNameInfoResponse {
    List<String> name;
    public CoachesNameInfoResponse(List<String> givenNames) {
        this.name = givenNames;
    }
    public int numberOfCoaches() {
        return name.size();
    }
    public String getName(int sequence){
        return name.get(sequence);
    }
}
