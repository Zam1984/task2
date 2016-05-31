package dao;

import dto.TestUser;


public interface H2Connection {
    
    public TestUser getUserById(int userId) throws Exception;
    public TestUser saveUser(TestUser testUser) throws Exception;
    public TestUser updateUser(TestUser testUser) throws Exception;
}