package lesson2;

import homework_1.task_3.Box;
import homework_1.task_3.Orange;
import lesson2.database.ConnectionService;
import lesson2.database.FruitRepository;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        FruitRepository fruitRepository = new FruitRepository();
        int row = fruitRepository.create(new Box<Orange>(1.5f));
        System.out.println(row);


        ConnectionService.disconnect();
    }
}
