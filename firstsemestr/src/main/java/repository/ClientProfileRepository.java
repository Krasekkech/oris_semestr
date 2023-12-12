package repository;

import model.Client;
import model.ClientProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientProfileRepository {
    public ClientProfile save(ClientProfile clientProfile) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into clientProfile (id, name, age, birthdate) " +
                            "values ( ?, ?, ?, ? ) returning id "
            );

            statement.setLong(1, clientProfile.getId());
            statement.setString(2, clientProfile.getName());
            statement.setString(3, clientProfile.getAge());
            statement.setString(4, clientProfile.getBirthdate());

            ResultSet resultSet = statement.executeQuery();

//            if (resultSet.next()) {
//                clientProfile.setId(resultSet.getLong("id"));
//            }

            resultSet.close();
            statement.close();

            return clientProfile;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClientProfileUpdate(){
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "update clientprofile set ? where ?"
            );


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClientProfile findById(Long id) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name, age, birthdate from clientprofile where id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            ClientProfile result = null;

            if (resultSet.next()) {
                result = new ClientProfile(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("age"),
                        resultSet.getString("birthdate")
                );
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClientProfile> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name,age,birthdate from clientprofile"
            );

            ResultSet resultSet = statement.executeQuery();

            List<ClientProfile> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new ClientProfile(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("age"),
                        resultSet.getString("birthdate")
                ));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
