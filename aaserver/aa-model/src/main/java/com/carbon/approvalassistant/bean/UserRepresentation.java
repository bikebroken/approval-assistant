package com.carbon.approvalassistant.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author carbon
 * @Date 2020/12/22 下午10:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRepresentation {
    private String userName;
    private String nickName;
}
