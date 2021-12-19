package com.mycompany.accountmanager.service.impl;

import com.mycompany.accountmanager.domain.UserEntity;
import com.mycompany.accountmanager.domain.UserPrincipal;
import com.mycompany.accountmanager.repository.UserRepository;
import com.mycompany.accountmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    public static final String USER_WITH_NAME_S_NOT_FOUND = "User with name: %s, not found";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository
                .findUserEntityByUsername(username)
                .orElseThrow(
                        () -> {
                            log.error("User with username: {}, not found", username);
                            return new UsernameNotFoundException(String.format(USER_WITH_NAME_S_NOT_FOUND, username));
                        });
        userEntity.setLastLoginDateDisplay(userEntity.getLastLoginDate());
        userEntity.setLastLoginDate(LocalDateTime.now());
        userRepository.save(userEntity);
        UserPrincipal userPrincipal = new UserPrincipal(userEntity);
        log.info("Returning found user by username: {}", username);
        return userPrincipal;
    }

}
