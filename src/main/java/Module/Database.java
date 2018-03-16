package Module;




import com.google.gson.internal.bind.SqlDateTypeAdapter;

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


    private String name;
    private String surname;
    private Integer age;
    private String login;
    private String loginPassword;
    private String diary;

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



    public List<String> getAllInformationAboutUser(String login) throws SQLException{
       List<String> list = new ArrayList<String>();

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

           statement.executeUpdate("INSERT INTO webproject.user_account (`name`, `surname`, `age`, `login`, `password`) VALUES ('"+name+"', '"+surname+"', '"+age+"', '"+login+"', '"+loginPassword+"')");

       } catch (SQLException e){
           e.printStackTrace();
       }
    }


    public String getLogin(Integer id)throws SQLException {
        resultSet = statement.executeQuery(" select login  from webproject.user_account where id= '"+id+"';");
        while (resultSet.next()){
            login = resultSet.getString(1);
        }
        return login;
    }

    public String getName(String login) throws SQLException{
        resultSet = statement.executeQuery(" select name  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
             name = resultSet.getString(1);
        }
        return name;
    }


    public String getSurname(String login) throws SQLException{
        resultSet = statement.executeQuery(" select surname  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
        surname = resultSet.getString(1);
    }
        return surname;
    }
    public Integer getAge(String login) throws SQLException{
        resultSet = statement.executeQuery(" select age  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
            age = resultSet.getInt(1);
        }
        return age;
    }
    public String getPassword(String login) throws SQLException{
        resultSet = statement.executeQuery(" select password  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
            loginPassword = resultSet.getString(1);
        }
        return loginPassword;
    }

    public String getDiary(String login)throws SQLException{
        resultSet = statement.executeQuery(" select diary  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
            diary = resultSet.getString(1);
        }
        return diary;
    }
    public boolean isExist(String login ,String loginPassword) throws SQLException{
        boolean result=false;
        resultSet = statement.executeQuery("SELECT login,password from webproject.user_account;");
        int i=0;
        while (resultSet.next()){
            if (resultSet.getString("login").equals(login) && resultSet.getString("password").equals(loginPassword)){
                result =true;
            }
        }
        return result;
    }


}