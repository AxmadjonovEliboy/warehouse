package uz.pdp.warehouse;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import uz.pdp.warehouse.config.encryption.PasswordEncoderConfigurer;
import uz.pdp.warehouse.entity.auth.AuthRole;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.repository.auth.AuthRoleRepository;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;

/**
 * @Author Aziza Tojiboyeva
 */
//@Component
@RequiredArgsConstructor
public class Init implements CommandLineRunner {

    private final PasswordEncoderConfigurer passwordEncoderConfigurer;
    private final AuthUserRepository repository;
    private final AuthRoleRepository roleRepository;



    @Override
    public void run(String... args) throws Exception {
        AuthRole admin = roleRepository.findByCode("ADMIN");
        AuthUser authUser =new AuthUser();
        authUser.setFullName("Axmadjonov Eliboy");
        authUser.setEmail("axmadjonoveliboy@gmail.com");
        authUser.setPhoneNumber("+998991061671");
        authUser.setRole(admin);
        authUser.setPassword(passwordEncoderConfigurer.passwordEncoder().encode("123"));
        repository.save(authUser);
    }

}
