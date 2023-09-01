package menu.front.app.controller;

import java.util.List;
import menu.front.app.validate.InputViewValidate;
import menu.front.resources.view.InputView;

public class InputViewController {
    private final InputView inputView;
    private final InputViewValidate inputViewValidate;

    public InputViewController(){
        this.inputView = new InputView();
        this.inputViewValidate = new InputViewValidate();
    }
    public List<String> readCoachesName() {
        try {
            String given = inputView.readCoachesName();
            return inputViewValidate.validateCoachesName(given);
        } catch (IllegalArgumentException e) {
            inputView.showInputErrorMessage(e.toString());
            return readCoachesName();
        }
    }

    public List<String> readCoachesDislike(String name) {
        try {
            String given = inputView.readDisLike(name);
            return inputViewValidate.validateDislike(given);
        } catch (IllegalArgumentException e) {
            inputView.showInputErrorMessage(e.toString());
            return readCoachesDislike(name);
        }
    }
}
