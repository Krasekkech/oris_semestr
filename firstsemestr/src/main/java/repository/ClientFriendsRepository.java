package repository;

import model.ClientFriends;
import model.ClientProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientFriendsRepository {
    public ClientFriends save(ClientFriends clientFriends) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into clientfriends (username, friendusername) " +
                            "values (?, ?)"
            );

            //statement.setLong(1, clientProfile.getId());
            statement.setString(1, clientFriends.getUsername());
            statement.setString(2, clientFriends.getFriendusername());

            int resultSet = statement.executeUpdate();

//            if (resultSet.next()) {
//                clientProfile.setId(resultSet.getLong("id"));
//            }

            //resultSet.close();
            statement.close();

            return clientFriends;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String findByUserName(String username) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select username, friendusername from clientfriends where username = ? "
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

    private String resultSetToJson(ResultSet resultSet) throws Exception {
        // Преобразуем ResultSet в формат JSON
        StringBuilder json = new StringBuilder();
        json.append("[");
        while (resultSet.next()) {
            json.append("{");
            //json.append("\"id\":\"").append(resultSet.getString("id")).append("\",");
            json.append("\"username\":\"").append(resultSet.getString("username")).append("\",");
            json.append("\"friendusername\":\"").append(resultSet.getString("friendusername")).append("\"");
            // Добавьте другие поля по необходимости
            json.append("},");
        }
        json.deleteCharAt(json.length() - 1); // Удаляем последнюю запятую
        json.append("]");
        return json.toString();
    }
}
