package com.carbon.approvalassistant.respository;

import com.carbon.approvalassistant.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author carbon
 * @Date 2020/12/22 下午10:29
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
