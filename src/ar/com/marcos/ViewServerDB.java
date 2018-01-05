package ar.com.marcos;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

/**
 * Created by Marcos.Ladino on 11/13/2017.
 */
public class ViewServerDB {

    public static void main(String ... args){
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;user=UserName;password=*****";

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSet cachedRowSet;

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT TOP 10 * FROM Person.Contact";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString(4) + " " + rs.getString(6));
            }
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

}
