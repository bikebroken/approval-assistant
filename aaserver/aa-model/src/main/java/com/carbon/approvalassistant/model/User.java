package com.carbon.approvalassistant.model;

import com.carbon.approvalassistant.bean.UserRepresentation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author carbon
 * @Date 2020/12/20 22:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="user")
public class User extends AbstractAuditBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    private String nickName;
    @Column
    private String password;
    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean status;
    @Column(nullable = false)
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserRole> userRoles = new ArrayList<>();

    public UserRepresentation toUserRepresentation() {
        return UserRepresentation.builder().nickName(this.nickName)
                .userName(this.userName).build();
    }

}
