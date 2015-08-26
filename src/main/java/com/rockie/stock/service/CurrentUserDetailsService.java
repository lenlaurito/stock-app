package com.rockie.stock.service;

import com.rockie.stock.model.User;
import com.rockie.stock.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by len on 8/18/2015.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findOneByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }
        org.springframework.security.core.userdetails.User userDetails
                = new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),  AuthorityUtils.createAuthorityList());

        return userDetails;
    }
}