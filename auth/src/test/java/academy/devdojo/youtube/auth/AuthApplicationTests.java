package br.edu.ufrn.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import java.security.SecureRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {

        System.out.println();
        System.out.println("vvvvvvvvvvvvv");
        System.out.println("SENHA: "+new BCryptPasswordEncoder().encode("123"));
        System.out.println("^^^^^^^^^^^");
        System.out.println();
    }

}
