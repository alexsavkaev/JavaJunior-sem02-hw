import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Animal[] animals = {
                new Dog("Шарик", 5, "Немецкая овчарка"),
                new Cat("Кузя", 1, "Черный"),
                new Dog("Бобик", 4, "Дворняга"),
                new Cat("Рыжий", 2, "Сиамский"),
                new Dog("Пепс", 3, "Французский бульдог"),
                new Cat("Мурзик", 5, "Сибирская кошка")
        };

        for (Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(clazz.getName()+" - " + "Поле: " + field.getName() + ", Значение: " + field.get(animal));
            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.getName().equals("makeSound")) {
                    method.invoke(animal);
                }
            }
        }
    }
}