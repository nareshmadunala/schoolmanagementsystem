package com.naresh.school.accountservice.repository;

import com.naresh.school.accountservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setFirstName("Naresh");
        user.setLastName("kumar");
        user.setEmail("naresh@kumar.com");
        user.setDateOfBirth("1988-10-10");
        user.setGender("m");
        user.setType("s");
        user.setStatus("active");
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void findByEmail() {
        User user = userRepository.findByEmail("naresh@kumar.com");
        assertEquals("naresh@kumar.com", user.getEmail());
    }
}