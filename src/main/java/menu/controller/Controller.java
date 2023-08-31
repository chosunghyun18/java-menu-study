package menu.controller;

import menu.model.CoachInfo;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Controller {

    public InputView inputView;
    public OutputView outputView;
    public CoachInfo coachInfo;

    private Controller(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.coachInfo = new CoachInfo();
//        outputView.startMessage();
//        coachNameInput();
        process();
    }

    public static Controller start() {
        return new Controller();
    }

    private void process(){
        outputView.startMessage();
        coachNameInput();
        coachRestrictionInput(coachInfo.getCoachNames());
    }

    private void coachNameInput(){
        try {
            coachInfo.validateCoachNumber(inputView.coachNameInputMessage());
            //coachRestrictionInput(coachInfo.getCoachNames());
        }catch (IllegalArgumentException e){
            outputView.errorMessage(e.getMessage());
            coachNameInput();
        }
    }

    private void coachRestrictionInput(List<String> coachNames) {
        for(String coach:coachNames) {
            try {
                coachRestrictionInputIndividual(coach);
            } catch (IllegalArgumentException e) {
                outputView.errorMessage(e.getMessage());
                coachRestrictionInputIndividual(coach);
            }
        }
    }

    private void coachRestrictionInputIndividual(String coach){
        coachInfo.validateCoachRestrictionNumber(inputView.foodThatCantEat(coach));
    }

}
