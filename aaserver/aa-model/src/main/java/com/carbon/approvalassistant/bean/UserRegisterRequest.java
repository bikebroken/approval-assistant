package com.carbon.approvalassistant.bean;

import com.carbon.approvalassistant.model.User;
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
    private String nickName;

    public User toUser() {
        return User.builder().nickName(this.getNickName())
                .userName(this.userName)
                .status(true).build();
    }

}
