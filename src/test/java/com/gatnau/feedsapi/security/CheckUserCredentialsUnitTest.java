package com.gatnau.feedsapi.security;

import com.gatnau.feedsapi.domain.Customer;
import com.gatnau.feedsapi.security.CustomerRepository;
import com.gatnau.feedsapi.domain.User;
import com.gatnau.feedsapi.security.UserDetailsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

/**
 * Created by ilgat on 05/01/2019.
 */
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class CheckUserCredentialsUnitTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    UserDetailsServiceImpl userDetailsService;

    @Before
    public void configure(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(customerRepository.existsById("ilgatnau@gmail.com")).thenReturn(true);
        Mockito.when(customerRepository.findById("ilgatnau@gmail.com")).thenReturn(Optional.of(getMockCustomer()));
    }

    @Test
    public void checkUserExistsInDatabase(){
        Assert.assertTrue(userDetailsService.userExists("ilgatnau@gmail.com"));
    }

    @Test
    public void checkUserNotExistsInDatabase(){
        Assert.assertFalse(userDetailsService.userExists("ivan.lopz@gmail.com"));
    }

    @Test
    public void checkUserCredentials() {
        User user = userDetailsService.checkUserCredentials("ilgatnau@gmail.com", "correctPwd");
        Assert.assertEquals(user.getId(), getMockUserDTO().getId());
    }

    @Test(expected = RuntimeException.class)
    public void checkInvalidUserCredentials() {
        User user = userDetailsService.checkUserCredentials("uuoi", "iuoiu");
        Assert.assertEquals(user.getId(), getMockUserDTO().getId());
    }

    private User getMockUserDTO(){
        User dto = new User();
        dto.setId("ilgatnau@gmail.com");
        return dto;
    }

    private Customer getMockCustomer(){
        Customer dto = new Customer();
        dto.id = "ilgatnau@gmail.com";
        dto.credentials = "correctPwd";
        return dto;
    }
}
