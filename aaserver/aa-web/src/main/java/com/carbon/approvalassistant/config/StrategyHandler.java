package com.carbon.approvalassistant.config;

/**
 * @Author carbon
 * @Date 2021-01-27 23:21
 */
public interface StrategyHandler<T, R> {

    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);
}
