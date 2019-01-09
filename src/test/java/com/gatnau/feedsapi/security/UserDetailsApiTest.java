package com.gatnau.feedsapi.security;

import com.gatnau.feedsapi.domain.User;
import com.gatnau.feedsapi.security.UserDetailsApi;
import com.gatnau.feedsapi.security.UserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.*;

/**
 * Created by ilgat on 08/01/2019.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserDetailsApi.class)
public class UserDetailsApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserDetailsService service;


    @Test
    public void givenValidUser_whenGetEmployee_thenReturnJson() throws Exception {
        User user = new User();
        user.setId("ilgatnau@gmail.com");

        //List<Employee> allEmployees = Arrays.asList(alex);

        given(service.checkUserCredentials("ilgatnau@gmail.com", "correctPwd")).willReturn(user);

        mvc.perform(get("/user/ilgatnau@gmail.com")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$", hasSize(1)))
                //.andExpect(jsonPath("$id", is(user.getId())));
    }
}
