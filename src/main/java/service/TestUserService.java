package service;

import dto.TestUser;

public interface TestUserService {

	public TestUser getUserById(int userId) throws Exception;
	
	public TestUser saveUser(TestUser testUser) throws Exception;
	
	public TestUser updateUser(TestUser testUser) throws Exception;
}
