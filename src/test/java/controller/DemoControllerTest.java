package controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import service.TestUserService;
import service.TestUserServiceImpl;
import dto.TestUser;




public class DemoControllerTest {
	@InjectMocks DemoController demoController = new DemoController();
	 
	@Mock TestUserService testUserService = new TestUserServiceImpl();
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetUserById () {
		int userId = 2;
		try {
			Mockito.when(testUserService.getUserById(2)).thenReturn(populateTestUser());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		TestUser testUser = new TestUser();
		try {
			testUser = demoController.getUser(userId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(populateTestUser().getUserId(), testUser.getUserId());
		assertEquals(populateTestUser().getUserName(), testUser.getUserName());
	}
	
	@Test
	public void testSaveUser () {
		TestUser testUser = populateTestUser();
		try {
			testUserService.saveUser(testUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	private TestUser populateTestUser() {
		TestUser testUser = new TestUser();
		testUser.setUserId(2);
		testUser.setUserName("Ibrahimovic");
		return testUser;
	}

}
