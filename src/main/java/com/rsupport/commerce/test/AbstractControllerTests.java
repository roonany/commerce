package com.rsupport.commerce.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

@ContextConfiguration
public class AbstractControllerTests extends AbstractTest {

  @Inject
  private WebApplicationContext wac;

  protected MockMvc mockMvc;

  protected MessageSourceAccessor messages;

  @Inject
  public void setMessages(MessageSource messageSource) {
    messages = new MessageSourceAccessor(messageSource);
  }

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  public MockHttpServletRequest newPost(String url) {
    return new MockHttpServletRequest("POST", url);
  }

  public MockHttpServletRequest newGet(String url) {
    return new MockHttpServletRequest("GET", url);
  }

  @After
  public void teardown() {
    SecurityContextHolder.clearContext();
  }

}