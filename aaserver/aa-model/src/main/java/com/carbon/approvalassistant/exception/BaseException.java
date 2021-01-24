package com.carbon.approvalassistant.exception;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author carbon
 * @Date 2020/12/23 下午10:56
 */
abstract class BaseException extends RuntimeException {
    private final ErrorCode errorCode;
    private final transient HashMap<String, Object> data = new HashMap<>();

    BaseException(ErrorCode errorCode, Map<String, Object> data) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
