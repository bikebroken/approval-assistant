package com.carbon.approvalassistant;

import com.carbon.approvalassistant.model.Role;
import com.carbon.approvalassistant.model.User;
import com.carbon.approvalassistant.model.UserRole;
import com.carbon.approvalassistant.enums.RoleType;
import com.carbon.approvalassistant.respository.RoleRepository;
import com.carbon.approvalassistant.respository.UserRepository;
import com.carbon.approvalassistant.respository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class AaWebApplication implements WebMvcConfigurer, CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        log.info("Starting Approval Assistant... ");
        SpringApplication springApplication = new SpringApplication(AaWebApplication.class);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        //初始化角色信息
        for (RoleType roleType : RoleType.values()) {
            roleRepository.save(new Role(roleType.getName(), roleType.getDescription()));
        }
        // 初始化一个admin角色
        User user = User.builder().fullName("admin").userName("root").password(passwordEncoder.encode("123654")).build();
        userRepository.save(user);
        Role role = roleRepository.findByName(RoleType.ADMIN.getName()).get();
        userRoleRepository.save(new UserRole(user, role));
    }
}
