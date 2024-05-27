package umc.spring.mission.response.exception.handler;

import umc.spring.mission.response.code.BaseErrorCode;
import umc.spring.mission.response.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
