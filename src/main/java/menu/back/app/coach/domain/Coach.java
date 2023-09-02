package menu.back.app.coach.domain;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    // Get coaches name by - > Set , make selected  and dislike  as  key value : hash map
    private List<String> coachesNames ; // init  with tree set
    private List<List<String>> coachesDiLikes;   // ex )   [ ["aplle "  , "new "  ] ,  // maybe could be map

    private Map<String,List<String>> coachesSelected = new HashMap<>(); // for show result

    public Coach () {

    }
    public void storeCoaches(List<String> names) {
        validateCoachesName(names);
        for(String name : names){
            coachesSelected.put(name,new ArrayList<>());
        }
    }
    public String getCoachesName(int i){
        return coachesNames.get(i);
    }
    public List<String> getCoachesDislikesBySequence(int i) {
        return coachesDiLikes.get(i);
    }
    private void validateCoachesName(List<String> name) {
        coachesNames = name;
    }

    public void storeDislikeMenus(List<List<String>> disLikesMenus) {
        coachesDiLikes = disLikesMenus;
    }

    public Map<String, List<String>> getCoacheSelectedForShow() {
        return coachesSelected;
    }

    public boolean isSelected(String menuSelected, String name) {
        List<String> menus = coachesSelected.get(name);
        return menus.contains(menuSelected) ;

    }

    public void storeRecommand(String menuSelected, String name) {
        List<String> menus =coachesSelected.get(name);
        menus.add(menuSelected);
        coachesSelected.put(name,menus);
    }

    public List<String> getCoachesNames() {
        return coachesNames;
    }
    public int numberOfCoaches(){
        return coachesNames.size();
    }
}
