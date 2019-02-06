package com.gatnau.feedsapi.security;

import com.gatnau.feedsapi.domain.Customer;
import com.gatnau.feedsapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ilgat on 08/01/2019.
 */
@RestController
public class UserDetailsApi {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/users/{id}")
    public User getUserDetails(@PathVariable String id) {
<<<<<<< HEAD

        Customer customer = customerRepository.findById(id).get();

        User user = new User();
        user.setId(customer.getId());
=======
        User user = new User();
        user.setName(id);
>>>>>>> e8113965c32cee2a24a1e98cebe0d821b470af81

        return user;
    }
}
