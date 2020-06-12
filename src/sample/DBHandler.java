package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler extends DBConnection {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        //String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String name, String firstName, String secondName, String address, String email, String password, String accessLevel){
        /**String Wronginsert = "INSERT INTO " + dbConstants.USERS_TABLE + "(" + dbConstants.USERS_FIRSTNAME + "," + dbConstants.USERS_NAME +
                "," + dbConstants.USERS_SECONDNAME + "," + dbConstants.USERS_ADDRES + "," + dbConstants.USERS_EMAIL+
                "," + dbConstants.USERS_PASS + "," + "," + dbConstants.USERS_LEVEL +")" + "VALUES(?,?,?,?,?,?,?)"; **/


        String insert = "INSERT INTO `"+dbConstants.USERS_TABLE+"`(`"+dbConstants.USERS_ID+"`, `"+dbConstants.USERS_NAME+"`, `"+dbConstants.USERS_FIRSTNAME+"`, `"+dbConstants.USERS_SECONDNAME+"`, `"+dbConstants.USERS_EMAIL+"`, `"+dbConstants.USERS_ADDRES+"`, `"+dbConstants.USERS_PASS+"`, `object_id`, `"+dbConstants.USERS_LEVEL+"`, `user_bday`) VALUES (NULL, '?', '?', '?', '?', '?', '?', '?', '2', '2020-06-09')";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, firstName);
            prSt.setString(3, secondName);
            prSt.setString(4, address);
            prSt.setString(5, email);
            prSt.setString(6, password);
            prSt.setString(7, accessLevel);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
