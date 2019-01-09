package com.gatnau.feedsapi.security;

import com.gatnau.feedsapi.domain.Customer;
import com.gatnau.feedsapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ilgat on 05/01/2019.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean userExists(String userId) {
        return customerRepository.existsById(userId);
    }

    public User checkUserCredentials(String userId, String credentials) {

        Customer customer = customerRepository.findById(userId).get();
        if (null != customer && customer.credentials.equals(credentials) ) {
            User dto = new User();
            dto.setId(customer.id);
            return dto;
        }

        throw new RuntimeException("Invalid credentials");
    }
}
