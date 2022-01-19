package com.arsenbaktiyarov.spring.security;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

@Slf4j
public class PasswordEncodingTest {
    static final String PASSWORD = "password1";

    @Test
    void hashing() {
      log.info(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
      log.info(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));

      String salted = PASSWORD + "HereIsSaltValue";

        log.info(DigestUtils.md5DigestAsHex(salted.getBytes()));
    }
}
