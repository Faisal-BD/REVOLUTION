package revolution;
import java.sql.*;
public class sqlConnect
{
    public Connection connect;
    public Statement s;

    public sqlConnect ()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql:///RevolutionEHS", "root", "javaproject");
            s = connect.createStatement();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}