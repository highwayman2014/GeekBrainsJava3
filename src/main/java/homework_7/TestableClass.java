package homework_7;

public class TestableClass {

    @BeforeSuit
    public void beforeSuitMethod(){
        System.out.println("Running beforeSuitMethod");
    }

    @AfterSuit
    public void afterSuitMethod(){
        System.out.println("Running afterSuitMethod");
    }

    @Test
    private void test1(){
        System.out.println("Running test1, default priority");
    }

    @Test(priority = 3)
    private void test2(){
        System.out.println("Running test2, priority 3");
    }

    @Test(priority = 2)
    private void test3(){
        System.out.println("Running test3, priority 2");
    }

}
