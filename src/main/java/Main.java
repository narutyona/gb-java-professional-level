import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var oranges = new Box<Orange>();

        oranges.put(new Orange());
        oranges.put(new Orange());
        System.out.println("Вес коробки с двумя апельзинами: " + oranges.getWeightAsString());

        var apples = new Box<Apple>();

        apples.put(new Apple());
        apples.put(new Apple());
        apples.put(new Apple());
        System.out.println("Вес коробки с тремя яблоками: " + apples.getWeightAsString());

        System.out.println("Результат сранения этих двух коробок: " + apples.compare(oranges));

        var secondApples = new Box<Apple>();

        apples.put(new Apple());
        apples.put(new Apple());

        System.out.println("Вес второй коробки с двумя яблоками: " + secondApples.getWeightAsString());

        System.out.println("Пересыпаем все яблоки в первую коробку");

        secondApples.pourOut(apples);

        System.out.println("Вес второй пустой коробки: " + secondApples.getWeightAsString());
        System.out.println("Вес первой коробки с пятью яблоками: " + apples.getWeightAsString());

        //Проверяем перестановку элементов массива
        System.out.println();
        var arr = new Integer[]{1, 2, 3};
        System.out.println("В массиве " + Arrays.toString(arr) + " меняем первые два элемента местами");
        replaceElements(0, 1, arr);

        System.out.println("Получили: " + Arrays.toString(arr));

        //Проверяем конвертацию
        var list = convertArrayToList(arr);

        System.out.println();
        System.out.print("Результат конвертации в ArrayList ");
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();

    }


    public static <T> ArrayList<T> convertArrayToList(T... arr) {
        if (arr == null) return null;

        var result = new ArrayList<T>(arr.length);
        for (var element : arr) {
            result.add(element);
        }

        return result;
    }

    public static <T> void replaceElements(int firstPosition, int secondPosition, T... arr) {
        if (!(arr != null
                && canBePosition(firstPosition, arr.length)
                && canBePosition(secondPosition, arr.length)
                && firstPosition != secondPosition))
            return;

        var first = arr[firstPosition];
        arr[firstPosition] = arr[secondPosition];
        arr[secondPosition] = first;

    }

    private static boolean canBePosition(int position, int arraySize) {
        return position >= 0 && position < arraySize;
    }
}
