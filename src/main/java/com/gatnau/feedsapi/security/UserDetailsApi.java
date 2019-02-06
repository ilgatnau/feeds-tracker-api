package com.gatnau.feedsapi.security;

import com.gatnau.feedsapi.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ilgat on 08/01/2019.
 */
@RestController
public class UserDetailsApi {

    @GetMapping(value = "/users/{id}")
    public User getUserDetails(@PathVariable String id) {
        User user = new User();
        user.setName(id);

        return user;
    }
}
