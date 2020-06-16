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
        //String insert = "INSERT INTO `"+dbConstants.USERS_TABLE+"`(`"+dbConstants.USERS_ID+"`, `"+dbConstants.USERS_NAME+"`, `"+dbConstants.USERS_FIRSTNAME+"`, `"+dbConstants.USERS_SECONDNAME+"`, `"+dbConstants.USERS_EMAIL+"`, `"+dbConstants.USERS_ADDRES+"`, `"+dbConstants.USERS_PASS+"`, `object_id`, `"+dbConstants.USERS_LEVEL+"`, `user_bday`) VALUES (NULL, '?', '?', '?', '?', '?', '?', '?', '2', '2020-06-09')";
        String insert = "INSERT INTO `users_tb` (`user_id`, `user_name`, `user_firstname`, `user_secondname`, `user_email`, `user_addres`, `pass`, `object_id`, `access_level`, `user_bday`) VALUES"
                +" (NULL, '"+firstName+"', '"+name+"', '"+secondName+"', '"+email+"', '"+address+"', '"+password+"', '1', '"+accessLevel+"', '1985-06-10');";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
