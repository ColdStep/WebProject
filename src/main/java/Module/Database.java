package Module;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/webproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public Database() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            System.out.println("Driver is create");
        } catch (SQLException e) {
            System.out.println("Driver isn't create");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public List<String> getAllInformation(String login) throws SQLException{
       List<String> list = new ArrayList<String>();
       try {

           resultSet = statement.executeQuery("select *from account where login='"+login+"'");
       }catch (SQLException e){
           e.printStackTrace();
       }
       while (resultSet.next()) {
           list.add(resultSet.getString("name"));
           list.add(resultSet.getString("surname"));
           list.add(resultSet.getString("age".toString()));
           list.add(resultSet.getString("login"));
           list.add(resultSet.getString("password"));
       }
        return list;
    }

    public void setAllIndormation(String name, String surname , Integer age, String login , String loginPassword){
       try{

           statement.executeUpdate("INSERT INTO `webproject`.`account` (`name`, `surname`, `age`, `login`, `password`) VALUES ('"+name+"', '"+surname+"', '"+age+"', '"+login+"', '"+loginPassword+"')");

       } catch (SQLException e){
           e.printStackTrace();
       }
    }

    public String getLogin(String login) throws Exception{
        resultSet = statement.executeQuery("select *from account where login=login");
        return resultSet.getString("");
    }

}