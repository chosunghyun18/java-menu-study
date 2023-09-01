package menu.back.app.coach.application.service;

import java.util.List;
import menu.back.app.coach.adapter.persistence.CoachPersistenceAdapter;
import menu.back.app.coach.adapter.presentation.AddCoachNameRequest;
import menu.back.app.coach.application.port.in.AddCoachNameUseCase;
import menu.back.app.coach.application.port.out.LoadCoachPort;
import menu.back.app.coach.application.port.out.SaveCoachPort;
import menu.back.app.coach.converter.CoachConverter;
import menu.back.app.coach.domain.Coach;

public class AddCoachNameService implements AddCoachNameUseCase {
    private final LoadCoachPort loadCoachPort;
    private final SaveCoachPort saveCoachPort;
    public AddCoachNameService() {
        this.loadCoachPort = new CoachPersistenceAdapter();
        this.saveCoachPort = new CoachPersistenceAdapter();
    }
    // 이름만 저장을해야 하지만 시스템상 어쩔수 없이 코치 엔터티를 같이 생성하는 함수의 형태
    @Override
    public void add(AddCoachNameRequest addCoachRequest) {
        List<String> names =CoachConverter.getCoachNameFromRequest(addCoachRequest);
        saveCoachPort.add(new Coach());
        Coach coach = loadCoachPort.getCoach();
        coach.storeCoaches(names);
    }
}
