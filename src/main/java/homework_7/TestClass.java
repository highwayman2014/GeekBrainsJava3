package homework_7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        start("homework_7.TestableClass");
    }

    public static void start(String className){
        try {
            Class aClass= Class.forName(className);
            start(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void start(Class TestableClass){

        // Создадим объект из переданного класса
        Object object = initObject(TestableClass);
        if (object == null){
            throw new RuntimeException("Can't init class");
        }

        // Получим методы с аннотациями BeforeSuit и AfterSuit
        // Если количество методов по каждой аннотацией окажется более одного, бросим RuntimeException
        List<Method> beforeSuitMethod = findMethodsWithAnnotation(TestableClass, BeforeSuit.class);
        if (beforeSuitMethod.size() > 1){
            throw new RuntimeException("Must be only one method with BeforeSuit annotation");
        }
        List<Method> afterSuitMethod = findMethodsWithAnnotation(TestableClass, AfterSuit.class);
        if (afterSuitMethod.size() > 1){
            throw new RuntimeException("Must be only one method with AfterSuit annotation");
        }

        // Найдем методы с аннотацией Test и отсортируем их по приоритету
        List<Method> testMethods = findMethodsWithAnnotation(TestableClass, Test.class);
        Collections.sort(testMethods, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
            }
        });

        // Выполним метод BeforeSuit, методы Test и метод AfterSuit
        if (beforeSuitMethod.size() > 0) {
            executeMethod(beforeSuitMethod.get(0), object);
        }

        for(Method method : testMethods) {
            executeMethod(method, object);
        }

        if (afterSuitMethod.size() > 0) {
            executeMethod(afterSuitMethod.get(0), object);
        }

    }

    private static void executeMethod(Method method, Object object, Object... args) {
        try {
            method.setAccessible(true);
            method.invoke(object, args);
            method.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object initObject(Class aClass) {
        try {
            return aClass.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Method> findMethodsWithAnnotation(Class aClass, Class<? extends Annotation> annotationClass) {

        List<Method> foundMethods = new ArrayList<>();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods){
            Annotation annotation = method.getAnnotation(annotationClass);
            if(annotation != null){
                foundMethods.add(method);
            }
        }
        return foundMethods;
    }

}
