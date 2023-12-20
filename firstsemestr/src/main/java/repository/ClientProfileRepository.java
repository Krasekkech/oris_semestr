package repository;

import model.ClientProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientProfileRepository {
    public ClientProfile save(ClientProfile clientProfile) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into clientProfile (username, name, age, birthdate, userinfo) " +
                            "values (?, ?, ?, ?, ?)"
            );

            statement.setString(1, clientProfile.getUsername());
            statement.setString(2, clientProfile.getName());
            statement.setString(3, clientProfile.getAge());
            statement.setString(4, clientProfile.getBirthdate());
            statement.setString(5, clientProfile.getUserinfo());

            int resultSet = statement.executeUpdate();

            statement.close();

            return clientProfile;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClientProfile update(ClientProfile clientProfile){
        try {
            Connection connection = DBConnection.getConnection();

            String updateQuery = "update clientprofile set name = ?, age = ?, birthdate = ?, userinfo = ? where username = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                preparedStatement.setString(1, clientProfile.getName());
                preparedStatement.setString(2, clientProfile.getAge());
                preparedStatement.setString(3, clientProfile.getBirthdate());
                preparedStatement.setString(4, clientProfile.getUserinfo());
                preparedStatement.setString(5, clientProfile.getUsername());

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return clientProfile;
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String findById(Long id) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select username, name, age, birthdate from clientprofile where id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            String result = resultSetToJson(resultSet);

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select * from clientprofile"
            );

            ResultSet resultSet = statement.executeQuery();

            String result = resultSetToJson(resultSet);

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private String resultSetToJson(ResultSet resultSet) throws Exception {
        StringBuilder json = new StringBuilder();
        while (resultSet.next()) {
            json.append("{");
            json.append("\"username\":\"").append(resultSet.getString("username")).append("\",");
            json.append("\"name\":\"").append(resultSet.getString("name")).append("\",");
            json.append("\"age\":\"").append(resultSet.getString("age")).append("\",");
            json.append("\"birthdate\":\"").append(resultSet.getString("birthdate")).append("\",");
            json.append("\"userinfo\":\"").append(resultSet.getString("userinfo")).append("\"");
            json.append("},");
        }
        json.deleteCharAt(json.length() - 1);
        return json.toString();
    }

    public String findByUserName(String username) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select username, name, age, birthdate, userinfo from clientprofile where username = ? "
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            String result = resultSetToJson(resultSet);

//            if (resultSet.next()) {
//                result = resultSetToJson(resultSet);
//            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ClientProfile delete(String username){
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "delete from clientprofile where username = ?"
            );


            statement.setString(1, username);

            int resultSet = statement.executeUpdate();

            statement.close();

            return null;
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
