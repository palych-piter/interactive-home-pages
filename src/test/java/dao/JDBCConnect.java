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
        //Driver driver = new org.postgresql.Driver();
        //establish connection
        Connection conn =
                DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/HomeBoardDB", "postgres", "Cure1995");

        //select records
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM \"Message\"");
        //Handle result set
        while (resultSet.next()) {
            System.out.println(resultSet.getString("author"));
        }

        //update records
        stmt.executeUpdate("UPDATE \"Message\" " +
                "SET Author = 'No Available' WHERE Author = 'Masha'");

        conn.close();
    }
}
