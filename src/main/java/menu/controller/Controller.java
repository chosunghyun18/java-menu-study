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
        outputView.startMessage();
        coachInput();
    }

    public static Controller start() {
        return new Controller();
    }

    private void coachInput(){
        try {
            coachInfo.validateCoachNumber(inputView.coachNameInputMessage());
            coachRestriction(coachInfo.getCoachNames());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]" + e);
            coachInput();
        }
    }


    //여기 예외 처리 수정 (하니씩 예외 걸아야 한다.)
    private void coachRestriction(List<String> coachNames) {
        try{
            inputView.foodThatCantEat(coachNames);  //param : coach 이름
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]" + e);
            coachRestriction(coachNames);
        }
    }

    //public void


}
