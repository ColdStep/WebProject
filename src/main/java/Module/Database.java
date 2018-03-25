package Module;




import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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
    private PreparedStatement preparedStatement = null;
    private String sqlArray;


    private String name;
    private String surname;
    private Integer age;
    private String login;
    private String loginPassword;
    private String diary = "Please enter here your information";


    public Database() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        } catch (SQLException e) {
            System.out.println("Driver isn't create");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Statement getStatement() throws SQLException{
        statement =connection.createStatement();
        return statement;
    }


    public List<String> getAllInformationAboutUser(String login) throws SQLException{
       List<String> list = new ArrayList<String>();
        resultSet =getStatement().executeQuery("SELECT *FROM webproject.user_account");
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
           preparedStatement = connection.prepareStatement("INSERT INTO webproject.user_account (`name`, `surname`, `age`, `login`, `password`) VALUES (?,?, ?, ?, ?)");
           preparedStatement.setString(1,name);
           preparedStatement.setString(2,surname);
           preparedStatement.setInt(3,age);
           preparedStatement.setString(4,login);
           preparedStatement.setString(5,loginPassword);
           preparedStatement.executeUpdate();

       } catch (SQLException e){
           e.printStackTrace();
       }
    }


    public String getLogin(Integer id)throws SQLException {

        resultSet = getStatement().executeQuery(" select login  from webproject.user_account where id= '"+id+"';");
        while (resultSet.next()){
            login = resultSet.getString(1);
        }
        return login;
    }

    public String getName(String login) throws SQLException{
        resultSet = getStatement().executeQuery(" select name  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
             name = resultSet.getString(1);
        }
        return name;
    }


    public String getSurname(String login) throws SQLException{
        resultSet = getStatement().executeQuery(" select surname  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
        surname = resultSet.getString(1);
    }
        return surname;
    }
    public Integer getAge(String login) throws SQLException{
        resultSet = getStatement().executeQuery(" select age  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
            age = resultSet.getInt(1);
        }
        return age;
    }
    public String getPassword(String login) throws SQLException{
        resultSet = getStatement().executeQuery(" select password  from webproject.user_account where login = '"+login+"';");
        while (resultSet.next()){
            loginPassword = resultSet.getString(1);
        }
        return loginPassword;
    }

    public void setDiary(String diary,String login) throws SQLException, UnsupportedEncodingException {

        sqlArray ="update webproject.user_account set diary = ? where login=?";
        preparedStatement = connection.prepareStatement(sqlArray);
        preparedStatement.setString(1,diary);
        preparedStatement.setString(2,login);

        preparedStatement.executeUpdate();
    }

    public String getDiary(String login) throws  UnsupportedEncodingException {
        try {

            resultSet = getStatement().executeQuery(" select diary  from webproject.user_account where login = '"+login+"'");
            while (resultSet.next()){
                if ( resultSet.getString(1)==null){
                    break;
                }else {
                    diary= resultSet.getString(1);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(diary);
        return diary;
    }
    public boolean isExist(String login ,String loginPassword) throws SQLException{
        boolean result=false;
        resultSet = getStatement().executeQuery("SELECT login,password from webproject.user_account;");
        while (resultSet.next()){
            if (resultSet.getString("login").equals(login) && resultSet.getString("password").equals(loginPassword)){
                result =true;
            }
        }
        return result;
    }


}