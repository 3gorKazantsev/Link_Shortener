package org.egorkazantsev.linkshortener.security;

import org.egorkazantsev.linkshortener.model.User;
import org.egorkazantsev.linkshortener.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LSUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public LSUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        return new LSUserDetails(user);
    }
}
