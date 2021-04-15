package homework_1.task_3;

/**
 * a. Есть классы Fruit -> Apple, Orange;
 */
public class Fruit {
    private long id;
    private String name;

    public Fruit() {
    }

    public Fruit(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
