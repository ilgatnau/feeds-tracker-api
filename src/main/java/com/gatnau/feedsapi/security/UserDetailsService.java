package com.gatnau.feedsapi.security;

import com.gatnau.feedsapi.domain.User;

/**
 * Created by ilgat on 05/01/2019.
 */
public interface UserDetailsService {

     boolean userExists(String userId);

     User checkUserCredentials(String userId, String credentials);
}
