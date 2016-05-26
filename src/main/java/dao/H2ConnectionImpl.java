package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.h2.util.StringUtils;
import org.springframework.stereotype.Service;

import dto.TestUser;

@Service
public class H2ConnectionImpl implements H2Connection {
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/D:/H2/WStask1";
    private static final String USER = "Zam";
    private static final String PASSWORD = "123";
    private static final String DRIVER_CLASS="org.h2.Driver";
    
//    public static void main(String[] args) throws Exception {
//        Class.forName(DRIVER_CLASS);
//        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
//        Statement stmt = conn.createStatement();
//
//        stmt.executeUpdate("INSERT INTO TEST_USER VALUES('333','Tom')");
//        stmt.executeUpdate("INSERT INTO TEST_USER VALUES('444','Jerry')");
//        stmt.executeUpdate("INSERT INTO TEST_USER VALUES('555','Terry')");
//        stmt.executeUpdate("INSERT INTO TEST_USER VALUES('666','Drogba')");
//        stmt.executeUpdate("INSERT INTO TEST_USER VALUES('777','Saha')");
//        stmt.executeUpdate("INSERT INTO TEST_USER VALUES('888','Beckham')");
//
//        ResultSet rs = stmt.executeQuery("SELECT * FROM USER_INFO");
//
//        while (rs.next()) {
//            System.out.println(rs.getString("id") + "," + rs.getString("name"));
//        }
//
//        stmt.close();
//
//        conn.close();
//    }
    
    public TestUser getUserById(String userId) throws Exception {
    	String name = "";
    	Class.forName(DRIVER_CLASS);
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        try {
        	ResultSet rs = stmt.executeQuery("SELECT * FROM TEST_USER WHERE USER_ID = " + userId);
        	while (rs.next()) {
        		name = rs.getString("name");
        	}
        }
    	catch (Exception e) {
    		throw new Exception(e);
    	} finally {

            stmt.close();

            conn.close();
    	}
        if (StringUtils.isNullOrEmpty(name)) {
        	throw new Exception("Record not found");
        }
        TestUser testUser = new TestUser();
        testUser.setUserId(userId);
        testUser.setUserName(name);
    	return testUser;
    }
    
    public void saveUser(TestUser testUser) throws Exception {
    	Class.forName(DRIVER_CLASS);
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        try {
        	stmt.executeUpdate("INSERT INTO TEST_USER VALUES(null, '" + testUser.getUserName() + "')");
        }
        	catch (Exception e) {
        		throw new Exception(e);
        	} finally {

                stmt.close();

                conn.close();
        	}
    }
    public void updateUser(TestUser testUser) throws Exception {
    	Class.forName(DRIVER_CLASS);
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        try {
        	stmt.executeUpdate("UPDATE TEST_USER SET NAME = '" + testUser.getUserName() + "' WHERE USER_ID = " + testUser.getUserId());
        }
        	catch (Exception e) {
        		throw new Exception(e);
        	} finally {

                stmt.close();

                conn.close();
        	}
    }
}