package org.dnyanyog.repo;

import java.util.List;
import java.util.Optional;
import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

  List<Users> findByUsernameAndPassword(String username, String password); // Declaration

  List<Users> findByEmail(String email); // Declaration

  List<Users> findByAge(String age); // Declaration

  @Query("SELECT u FROM Users u WHERE u.email = :email and  u.username = :username")
  List<Users> findByUsingEmailAndUserName(String email, String username);

  @Query(value = "SELECT * FROM Users u WHERE u.email = ?1 or  u.username = ?2", nativeQuery = true)
  List<Users> findByUsingEmailOrUserName(String email, String username);

  @Query(value = "SELECT u.user_id FROM Users u ", nativeQuery = true)
  List<Long> findByIdOfAllUsers();

  List<Users> findByUsername(String username);

  Optional<Users> findByUserId(Long userID);
}
