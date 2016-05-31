package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import dto.TestUser;


public class H2ConnectionTest {
	@InjectMocks
	private H2Connection h2Connection = new H2ConnectionImpl();

	@Test
	public void testGetUserById () {
		int userId = 2;
		TestUser testUser = new TestUser();
		try {
			testUser = h2Connection.getUserById(userId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testSaveUser () {
		TestUser testUser = populateTestUser();
		try {
			h2Connection.saveUser(testUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	private TestUser populateTestUser() {
		TestUser testUser = new TestUser();
		testUser.setUserId(2);
		testUser.setUserName("Suarez");
		return testUser;
	}


}
