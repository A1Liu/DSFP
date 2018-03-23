package server;

//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sql.UserDAO;
import sql.DAOFactory;
import sql.PassDAO;
import users.User;

/**
 * Test harness for the sql package. This require the following preconditions:
 * <ol>
 * <li>A MySQL server running at localhost:3306 with a database named 'javabase'.
 * <li>A 'user' table in the 'javabase' database which is created as follows:
 * <pre>
 * CREATE TABLE javabase.user (
 *     id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
 *     email VARCHAR(60) NOT NULL,
 *     password VARCHAR(32) NOT NULL,
 *     firstname VARCHAR(40) NULL,
 *     lastname VARCHAR(40) NULL,
 *     birthdate DATE NULL,
 *
 *     PRIMARY KEY (id),
 *     UNIQUE (email)
 * )
 * </pre>
 * <li>A MySQL user with the name 'java' and password 'java' which has sufficient rights on
 * the javabase.user table.
 * <li>A MySQL JDBC Driver JAR file in the classpath.
 * <li>A properties file 'dao.properties' in the classpath with the following entries:
 * <pre>
 * javabase.jdbc.driver = com.mysql.jdbc.Driver
 * javabase.jdbc.url = jdbc:mysql://localhost:3306/javabase
 * javabase.jdbc.username = java
 * javabase.jdbc.password = java
 * </pre>
 * </ol>
 */
public class Server {

    public static void main(String[] args) throws Exception {
        // Obtain DAOFactory.
        DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
        System.out.println("DAOFactory successfully obtained: " + javabase);

        // Obtain UserDAO.
        UserDAO userDAO = javabase.getUserDAO();
        System.out.println("UserDAO successfully obtained: " + userDAO);
        PassDAO passDAO = javabase.getPassDAO();
        System.out.println("PassDAO successfully obtained: " + passDAO);

        // Create user.
        User user = new User();
        user.setUsername("a");
        user.setEmail("a");
        user.setBirthday(new Date());
        user.setFirst("albert");
        user.setLast("Liu");
        userDAO.create(user);
        System.out.println("User successfully created: " + user);
        passDAO.createPass(user.getID(), "hello");

        // Create another user.
        User anotherUser = new User();
        anotherUser.setUsername("helep");
        anotherUser.setEmail("bar@fooa.com");
        anotherUser.setBirthday(new Date());
        anotherUser.setFirst("Bar");
        anotherUser.setLast("Foo");
        //anotherUser.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1978-03-26"));
        userDAO.create(anotherUser);
        System.out.println("Another user successfully created: " + anotherUser);
        passDAO.createPass(anotherUser.getID(), "hello");
        System.out.println(passDAO.checkPass(anotherUser.getID(), "hello"));
        
        

        // Update user.
        user.setFirst("Foo");
        user.setLast("Bar");
        userDAO.update(user);
        System.out.println("User successfully updated: " + user);

        // List all users.
        List<User> users = userDAO.list();
        System.out.println("List of users successfully queried: " + users);
        System.out.println("Thus, amount of users in database is: " + users.size());

        // Check if email exists.
        boolean exist = userDAO.existEmail("foo@bar.com");
        System.out.println("This email should not exist anymore, so this should print false: " + exist);



        // Get another user by email and password.
        User foundAnotherUser = userDAO.find("bar@foo.com");
        System.out.println("Another user successfully queried with new password: " + foundAnotherUser);
    }
}