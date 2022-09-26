package com.fullstack.pollsystem.repo;

import com.fullstack.pollsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
//    This will transform into sql such as
//    Select * from student where email = what we pass...
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);
}
