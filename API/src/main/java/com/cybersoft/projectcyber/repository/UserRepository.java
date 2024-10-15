package com.cybersoft.projectcyber.repository;

import com.cybersoft.projectcyber.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    Users findByFullName(String username);

//    @Query(value = "SELECT email FROM users", nativeQuery = true)
//    List<Users> findAllUser();
}
