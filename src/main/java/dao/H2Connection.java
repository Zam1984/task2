package dao;

import dto.TestUser;


public interface H2Connection {
    
    public TestUser getUserById(String userId) throws Exception;
    public void saveUser(TestUser testUser) throws Exception;
    public void updateUser(TestUser testUser) throws Exception;
}