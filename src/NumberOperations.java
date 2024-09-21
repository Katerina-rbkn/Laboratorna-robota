import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class NumberOperations {
    public static void main(String[] args) {
        // Створюємо список для зберігання чисел різних типів
        List<Number> numbers = new ArrayList<>();

        // Додаємо числа різних типів до списку
        numbers.addAll(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));
        numbers.addAll(Arrays.asList(
                (int)55,  // Integer
                (double)15.425d, // Double
                (long)112L, // Long
                (float)4.258f, // Float
                (short) 7 // Short

        ));

        // Виводимо поточний список чисел
        System.out.println("Поточний список чисел: " + numbers);

        // Виводимо числа у форматі цілих чисел
        System.out.println("Список у форматі цілих чисел: ");
        for (Number num : numbers) {
            System.out.print(num.intValue() + "; ");
        }
        System.out.println();
        System.out.println();

        // Виводимо числа у форматі дробних чисел з 2-ма знаками після коми
        System.out.println("Список у форматі дробних чисел з 2-ма знаками після коми: ");
        for (Number num : numbers) {
            System.out.printf("%.2f; ", num.doubleValue());
        }
        System.out.println();
        System.out.println();

        // Створюємо мапу для зберігання списків чисел за типами
        Map<Class<? extends Number>, List<Number>> numberMap = new HashMap<>();

        // Розподіляємо числа за їх типами
        for (Number number : numbers) {
            // Додаємо число до списку відповідного типу у мапі
            numberMap.computeIfAbsent(number.getClass(), k -> new ArrayList<>()).add(number);
        }

        // Виводимо кожен список чисел за типами
        numberMap.forEach((type, numList) -> {
            System.out.println("Числа типу " + type.getSimpleName() + ": " + numList);
        });

        // Обчислюємо суму квадратів всіх чисел
        double sum = 0;
        for (Number number : numbers) {
            sum += Math.pow(number.doubleValue(), 2); // Додаємо квадрат числа до суми
        }

        // Виводимо результат
        System.out.println(" ");
        System.out.println("Сума квадратів всіх чисел: " + sum);
    }
}