package service;

import dto.TestUser;

public interface TestUserService {

	public TestUser getUserById(String userId) throws Exception;
	
	public void saveUser(TestUser testUser) throws Exception;
	
	public void updateUser(TestUser testUser) throws Exception;
}
