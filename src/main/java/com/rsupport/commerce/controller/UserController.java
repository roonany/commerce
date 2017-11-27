package com.rsupport.commerce.controller;

import com.rsupport.commerce.constants.UriConstants;
import com.rsupport.commerce.exception.UserNotFoundException;
import com.rsupport.commerce.exception.UserPasswordNotMatchedException;
import com.rsupport.commerce.exception.UsernameExistException;
import com.rsupport.commerce.model.Authority;
import com.rsupport.commerce.model.User;
import com.rsupport.commerce.service.AuthorityManager;
import com.rsupport.commerce.service.UserManager;
import com.rsupport.commerce.util.ParameterUtil;
import com.rsupport.commerce.vo.ResponseVO;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CommonsLog
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityManager authorityManager;

    @GetMapping(value = UriConstants.LOGIN)
    public String login() {
        return "login";
    }

    @PostMapping(value = UriConstants.LOGIN)
    public ResponseVO login(@RequestParam String username, @RequestParam String password) {
        log.debug(String.format("url : [%s]", UriConstants.LOGIN));
        User user = userManager.findByUsername(username);

        if(user == null)
            throw new UserNotFoundException();

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserPasswordNotMatchedException();
        }

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities())
        );
        return ResponseVO.ok();
    }

    @PostMapping(value = "/login/success")
    public String loginSuccess() {
        return "login_success";
    }

    @PostMapping(value = UriConstants.JOIN)
    public ResponseVO join(User user){
        log.debug(String.format("url : [%s]", UriConstants.JOIN));
        ParameterUtil.checkParameterEmpty(user.getUsername(), user.getPassword(), user.getName());
        checkUsernameDuplicated(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Authority authority = authorityManager.findByAuthority("user");
        user.getAuthorities().add(authority);
        userManager.save(user);

        return ResponseVO.ok();
    }

    @PostMapping(value =  UriConstants.LOGOUT)
    public ResponseVO logout(HttpServletRequest request){
        log.debug(String.format("url : [%s]", UriConstants.LOGOUT));
//        TODO : session에 담는게 없는데 왜 session을 선언해서 invalidate()를 하는지??
//        HttpSession httpSession = request.getSession(false);
//        log.debug(String.format("sessionId = [%s]", httpSession.getAttribute("")));
//        if(httpSession != null) {
//            httpSession.invalidate();
//        }
        SecurityContextHolder.clearContext();
        return ResponseVO.ok();
    }

    private void checkUsernameDuplicated(String userName) {
        if(userManager.existUserByUsername(userName))
            throw new UsernameExistException();
    }
}
