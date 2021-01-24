package com.carbon.approvalassistant.service;

import com.carbon.approvalassistant.bean.UserRegisterRequest;
import com.carbon.approvalassistant.exception.UserNameAlreadyExistException;
import com.carbon.approvalassistant.respository.RoleRepository;
import com.carbon.approvalassistant.respository.UserRepository;
import com.carbon.approvalassistant.respository.UserRoleRepository;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author carbon
 * @Date 2020/12/22 下午10:32
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    public static final String USERNAME = "username:";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(UserRegisterRequest userRegisterRequest) {

    }

    private void ensureUserNameNotExist(String userName) {
        boolean exist = userRepository.existsByUserName(userName);
        if (exist) {
            throw new UserNameAlreadyExistException(ImmutableMap.of(USERNAME, userName));
        }
    }
}
