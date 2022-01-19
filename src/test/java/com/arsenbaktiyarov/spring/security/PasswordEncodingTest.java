package com.arsenbaktiyarov.spring.security;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testNoOp() {
        PasswordEncoder noOp = NoOpPasswordEncoder.getInstance();
        log.info(noOp.encode(PASSWORD));
    }

    @Test
    void testLdap() {
        PasswordEncoder ldap = new LdapShaPasswordEncoder();
        log.info(ldap.encode(PASSWORD));
        log.info(ldap.encode(PASSWORD));

        String encoded = ldap.encode(PASSWORD);
        assertTrue(ldap.matches(PASSWORD, encoded));
    }

    @Test
    void testSha256() {
        PasswordEncoder sha256 = new StandardPasswordEncoder();
        log.info(sha256.encode(PASSWORD));
        log.info(sha256.encode(PASSWORD));
    }

    @Test
    void testBcrypt() {
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        log.info(bcrypt.encode(PASSWORD));
        log.info(bcrypt.encode(PASSWORD));
    }
}
