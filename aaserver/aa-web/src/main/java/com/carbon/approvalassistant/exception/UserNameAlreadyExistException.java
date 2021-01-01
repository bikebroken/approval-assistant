package com.carbon.approvalassistant.exception;

import java.util.Map;

/**
 * @Author carbon
 * @Date 2020/12/23 下午11:03
 */
public class UserNameAlreadyExistException extends BaseException {

    public UserNameAlreadyExistException(Map<String, Object> data) {
        super(ErrorCode.USER_NAME_ALREADY_EXIST, data);
    }
}
