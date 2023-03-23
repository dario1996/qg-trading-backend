package net.tradingDiary.tradingdiarybackend;

import net.tradingDiary.tradingdiarybackend.controller.UserController;
import net.tradingDiary.tradingdiarybackend.entity.User;
import net.tradingDiary.tradingdiarybackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)

@SpringBootTest
public class UserControllerTest {
	@Autowired
	private UserController userController;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testRegisterUser() {
		User user = new User();
		user.setName("Mario Rossi");
		user.setEmail("test@example.com");
		user.setPassword("password");

		ResponseEntity<String> response = userController.registerUser(user);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Registrazione effettuata con successo", response.getBody());

		Optional<User> savedUser = userRepository.findByEmail(user.getEmail());
		assertTrue(savedUser.isPresent());
		assertEquals(user.getEmail(), savedUser.get().getEmail());
		assertEquals(user.getPassword(), savedUser.get().getPassword());
	}
}
