package com.rsupport.commerce.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestSecurityController {

 @RequestMapping("/admin")
 public Map<String, String> admin() {
   Map<String, String> result = new HashMap<>();
   result.put("message", "This is admin");
   return result;
 }

 @RequestMapping("/api")
 public Map<String, String> api() {
   Map<String, String> result = new HashMap<>();
   result.put("message", "This is api home");
   return result;
 }

}