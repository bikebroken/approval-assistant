package com.carbon.approvalassistant.respository;

import com.carbon.approvalassistant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author carbon
 * @Date 2020/12/22 下午10:22
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String username);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void deleteByUserName(String userName);

    boolean existsByUserName(String username);

}
