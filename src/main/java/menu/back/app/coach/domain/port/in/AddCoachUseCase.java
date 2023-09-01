package menu.back.app.coach.domain.port.in;

import menu.back.app.coach.adapter.presentation.AddCoachRequest;

public interface AddCoachUseCase {
        void add(AddCoachRequest addCoachRequest);
}
