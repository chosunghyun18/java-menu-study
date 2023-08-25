package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Coach {
    // Get coaches name by - > Set , make selected  and dislike  as  key value : hash map
    private Set<String> coachesNames = new TreeSet<>(); // init  with tree set
    private List<List<String>> coachesDiLikes;   // ex )   [ ["aplle "  , "new "  ] ,  // maybe could be map

    private Map<String,List<String>> coachesSelected; // for show result

    public Coach () {

    }
    public void storeCoaches(List<String> name) {
        validateCoachesName(name);
    }

    private void validateCoachesName(List<String> name) {
        coachesNames = (Set<String>) name;
    }

    public void storeDislikeMenus(List<List<String>> disLikesMenus) {
        coachesDiLikes = disLikesMenus;
    }

    public Map<String, List<String>> getCoacheSelectedForShow() {
        return coachesSelected;
    }
}
