package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.H2Connection;
import dto.TestUser;
@Service
public class TestUserServiceImpl implements TestUserService {

	@Autowired private H2Connection h2Connection;
	
	public TestUser getUserById(int userId) throws Exception {
		TestUser testUser = new TestUser();
		 try
		 {
			 testUser = h2Connection.getUserById(userId);
		 } catch (Exception e) {
			 throw new Exception(e);
		 } 
		return testUser;
	}
	
	public TestUser saveUser(TestUser testUser) throws Exception {
		 try
		 {
			 testUser = h2Connection.saveUser(testUser);
		 } catch (Exception e) {
			 throw new Exception(e);
		 } 
		 return testUser;
	}
	
	public TestUser updateUser(TestUser testUser) throws Exception {
		 try
		 {
			 testUser = h2Connection.updateUser(testUser);
		 } catch (Exception e) {
			 throw new Exception(e);
		 } 
		 return testUser;
	}
}
