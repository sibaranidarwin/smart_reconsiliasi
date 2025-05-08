package com.hackathon.smart_reconsiliasi.service.auth;


import com.hackathon.smart_reconsiliasi.dto.auth.UserDetailsResponse;
import com.hackathon.smart_reconsiliasi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        try {
            return userRepository.findByUsername(username)
                    .map(UserDetailsResponse::new)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        } catch (UsernameNotFoundException e) {
            throw e;
        }
    }

}

