package com.rsupport.commerce.test;

import com.rsupport.commerce.constants.UriConstants;
import com.rsupport.commerce.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class TestUserController {

    @Autowired
    private MockMvc mvc;

    @Before
    public void setup(){
        this.mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testLogin() throws Exception {
        this.mvc.perform(post(UriConstants.LOGIN)
                .param("username","jangjunhwan")
                .param("password", "1234").accept(MediaType.APPLICATION_JSON)).andDo(print());
    }
}
