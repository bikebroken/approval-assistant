package com.carbon.approvalassistant.respository;

import com.carbon.approvalassistant.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author carbon
 * @Date 2020/12/22 下午10:20
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
}
