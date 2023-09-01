package menu.front.app.validate;

import java.util.List;

public class InputViewValidate {
    public InputViewValidate() {

    }
    public List<String> validateDislike(String given) {
        return List.of(given.split(","));
    }

    public List<String> validateCoachesName(String given) {
        List<String> names = List.of(given.split(","));
        if(names.size() < 2) throw new IllegalArgumentException();
        if(names.size() > 5) throw new IllegalArgumentException();
        for(String name : names){
            if(name.length() > 4 || name.length() <2) throw new IllegalArgumentException();
        }
        return List.of(given.split(","));
    }
}
