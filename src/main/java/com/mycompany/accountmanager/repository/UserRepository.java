package com.mycompany.accountmanager.repository;

import com.mycompany.accountmanager.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);

    UserEntity findUserEntityByEmail(String email);

}
