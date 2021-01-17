package com.carbon.approvalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author carbon
 * @Date 2020/12/20 下午11:00
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role extends AbstractAuditBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserRole> userRoles = new ArrayList<>();

    public Role(String name, String description) {
        this.name = name;
        this. description = description;
    }
}
