package Module;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/webproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD= "root";
    private String name;
    private String surname;
    private int age;
    private String login;
    private String loginPassword;

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            System.out.println("Driver is create");
        } catch (SQLException e) {
            System.out.println("Driver isn't create");
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM account");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name")+" "+resultSet.getString("surname")+" ("+resultSet.getInt("Age")+") \n Login - "+ resultSet.getString("login")+"\n Password - "+resultSet.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
