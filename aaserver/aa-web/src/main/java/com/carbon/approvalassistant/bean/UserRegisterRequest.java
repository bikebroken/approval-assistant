package com.carbon.approvalassistant.bean;

import com.carbon.approvalassistant.entity.User;
import com.carbon.approvalassistant.validator.FullName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author carbon
 * @Date 2020/12/22 下午10:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @FullName
    @NotBlank
    private String fullName;

    public User toUser() {
        return User.builder().fullName(this.getFullName())
                .userName(this.userName)
                .enabled(true).build();
    }

}
