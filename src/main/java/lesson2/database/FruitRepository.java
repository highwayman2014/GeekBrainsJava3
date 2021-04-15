package lesson2.database;

import homework_1.task_3.Box;
import homework_1.task_3.Fruit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// CRUD - create, read, update, delete
public class FruitRepository<T extends Box<? extends Fruit>> {

    public int create(T box){
        Connection connection = ConnectionService.getConnection();
        int result = -1;
        try {
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO boxes (name, type, weight) VALUES (?, ?, ?)"
            );

            float weight = box.getWeight();

            statement.setString(1, "box2");
            statement.setInt(2, 2);
            statement.setFloat(3, weight);

            result = statement.executeUpdate();
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Fruit> findAll() {
        List<Fruit> fruits = new ArrayList<>();
        Connection connection = ConnectionService.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM fruits"
            );

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                fruits.add(
                        new Fruit(
                                rs.getInt(1),
                                rs.getString("name")
                        )
                );
            }
            statement.close();
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return fruits;
    }

}
