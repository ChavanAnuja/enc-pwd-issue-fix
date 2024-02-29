package org.dnyanyog.service;

import java.util.List;

import javax.crypto.SecretKey;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UsersRepository userRepo;
	@Autowired
	Users user;
    @Autowired
    EncryptionService encryptionService;
	
    public LoginResponse validateUser(LoginRequest loginRequest) throws Exception {
		LoginResponse response = new LoginResponse();

		List<Users> receivedData = userRepo.findByUsername(loginRequest.getUsername());

		if (receivedData.size() == 1) {
			Users userData = receivedData.get(0);
			String encryptedPassword = userData.getPassword();
			String requestPassword = encryptionService.encryp(loginRequest.getPassword());

			if (requestPassword.equalsIgnoreCase(encryptedPassword)) {
				response.setStatus("Success");
				response.setMessage("Login successful");
			} else {
				response.setStatus("Fail");
				response.setMessage("Username & Password Do Not Match");
			}
		} else {
			response.setStatus("Fail");
			response.setMessage("Request Username is Not present in the database");
		}

		return response;
	}
}
