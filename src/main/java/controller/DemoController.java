package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.TestUserService;
import dto.TestUser;

/* 
 * Created on: 2016/5/26
 * Created by: Zam Song
 * Demo Controller is introduced to control the request/response between the 
 * client and the database. The Controller could either:
 * 1. get the User object by sending a GET request with a userId parameter or
 * URL:<baseurl>/user/{id}
 * 2. Insert a new user record by sending a POST request 
 * URL:<baseurl>/user
 * */
@Controller
@RequestMapping(value = "/user")
public class DemoController {

@Autowired private TestUserService testUserService;

 @RequestMapping(value = "toPage1.htm")

 public ModelAndView toPage1() {

	 ModelAndView returnValue = new ModelAndView("page1");
	 
  return returnValue;

 }
 
 @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
 @ResponseBody
 public TestUser saveUser(@RequestBody TestUser testUser) {
	 try
	 {
		 testUserService.saveUser(testUser);
		 
	 } catch (Exception e) {
		 System.out.print(e);
	 } 

	 
	 System.out.println("save user name ==== " + testUser.getUserName());
	 return testUser;
 }
 
 @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
 @ResponseBody
 public TestUser getUser(@PathVariable(value = "id") int userId) {
	 
	 
	 TestUser testUser = new TestUser();
	 testUser.setUserId(userId);
	 try
	 {
		 testUser = testUserService.getUserById(userId);
	 } catch (Exception e) {
		 System.out.print(e);
		 testUser.setUserName(e.getMessage());
	 } 

	 
	 System.out.println("get user name ==== " + testUser.getUserName());
	 
  return testUser;

 }
 @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
 @ResponseBody
 public String updateUser(@RequestBody TestUser testUser) {
	 String message = "";
	 try
	 {
		 testUserService.updateUser(testUser);
		 message = "Success";
	 } catch (Exception e) {
		 System.out.print(e);
		 message = e.getMessage();
	 } 

	 
	 System.out.println("update user ==== " + testUser.getUserName());
	 
  return message;

 }
}