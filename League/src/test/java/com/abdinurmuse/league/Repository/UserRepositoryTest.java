package com.abdinurmuse.league.Repository;

import com.abdinurmuse.league.Models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmail() {

        User user = new User(1, "abidnurplus@gmail.com", "123456", "Abdinur", "Muse");

        userRepository.save(user);

        User retrievedUser = userRepository.findByEmail(user.getEmail());

        assertEquals(retrievedUser, user);
    }
}