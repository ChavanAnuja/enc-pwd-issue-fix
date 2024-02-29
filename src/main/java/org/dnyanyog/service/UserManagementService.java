package org.dnyanyog.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserManagementService {

	Optional<AddUserResponse> addUpdateUser(AddUserRequest request) throws Exception;

	AddUserResponse getSingleUser(Long userId) throws Exception;

	List<Users> getAllUser();

	List<Long> getAllUserIds();

	AddUserResponse updateUser(Long userID, Users request) throws Exception;
}