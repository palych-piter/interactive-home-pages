package dao;

import org.junit.Test;

import java.sql.*;

/**
 * Created by Andrey on 10/8/2015.
 */
public class JDBCConnect {

    @Test
    public void testConnection() throws SQLException {

        //initialize driver
        Driver driver = new org.postgresql.Driver();

        //establish connection
        Connection conn = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/HomeBoardDB", "postgres", "Cure1995");

        Statement stmt = conn.createStatement();

        //update records
        /* stmt.executeUpdate("UPDATE \"message\" " +
                "SET Author = 'No Available' WHERE Author = 'Masha'"); */


        //DELETE from User and Message Tables
        stmt.executeUpdate("DELETE FROM \"Message\" WHERE id = 1");
        stmt.executeUpdate("DELETE FROM \"Message\" WHERE id = 2");
        stmt.executeUpdate("DELETE FROM \"User\" WHERE id = 1");
        stmt.executeUpdate("DELETE FROM \"User\" WHERE id = 2");


        //INSERT TEST User records
        stmt.executeUpdate("INSERT INTO \"User\" " +
                "(id, email, name, status)" +
                "VALUES (1, 'andr.bespalov@gmail.com', 'Andrey', 'active')");

        stmt.executeUpdate("INSERT INTO \"User\" " +
                "(id, email, name, status)" +
                "VALUES (2, 'mbespalova@gmail.com', 'Masha', 'active')");

        //INSERT TEST Message records
        stmt.executeUpdate
                ("INSERT INTO \"Message\" " +
                        "(id, content, picture_link, \"timestamp\", user_pkey) " +
                        "VALUES (1, 'content of the message2', 'link1', '2015-10-23', 1)");


        //INSERT TEST Message records
        stmt.executeUpdate
                ("INSERT INTO \"Message\" " +
                        "(id, content, picture_link, \"timestamp\", user_pkey) " +
                        "VALUES (2, 'content of the message2', 'link2', '2015-10-23', 2)");


        //select records
        ResultSet resultSet =
                stmt.executeQuery
                        (
                                "SELECT * FROM \"Message\" " +
                                        "LEFT JOIN \"User\" " +
                                        "ON (\"User\".id = \"Message\".user_pkey)"
                        );
        //Handle result set
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        //Close a connection
        conn.close();

    }
}
