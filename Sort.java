package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("    Введите длину массива. Например - 214748364");
        String s1 = "1";
        int Long = 0;
        while (s1.isEmpty() == false) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s1 = br.readLine();
            try {
                if (s1.isEmpty() == false) {
                    Long = Integer.parseInt(s1);
                    if(Long<0 || Long==0) { System.out.println("Значение не может быть меньше или равно нулю."); break;}
                    break;
                }
            } catch (Exception e) {
                System.out.println("Слишком большое значение для int");
            }
        }
        System.out.println("    Заполнение массива.");
        int[] x = new int[Long];

        for (int i = 0; i < Long; i++) {
            int random = (int) (Math.random() * 100);
            x[i] = random;
        }
        int[] x1 = Arrays.copyOf(x, x.length);
        int[] x2 = Arrays.copyOf(x, x.length);
        System.out.println("    Массив создан.");
        //System.out.println("Было");
        //System.out.println(Arrays.toString(x));//раскомментировать чтобы вывести массив

        int low = 0;
        int high = x.length - 1;
        System.out.println("\n    Ведётся подсчёт времени для QuickSoft.\n");

        long startT = System.currentTimeMillis();
        long startM = mem();
        quickSort(x, low, high);
        System.out.println("Quicksoft занял времени " + ((float) (System.currentTimeMillis() - startT)) / 1000 + " s");
        long delta = mem() - startM;
        long usedMBytes = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) / 1048576;
        System.out.println("Quicksoft занял памяти " + usedMBytes + " Mb");

        System.out.println("\n    Ведётся подсчёт времени для Array.Sort.\n");
        startT = System.currentTimeMillis();
        //System.out.println(Arrays.toString(x));//раскомментировать чтобы вывести массив
        startM = mem();
        Arrays.sort(x1);
        
        System.out.println("Класс Array метод Sort занял времени " + ((float) (System.currentTimeMillis() - startT)) / 1000 + " s");
        usedMBytes = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) / 1048576;
        System.out.println("Класс Array метод Sort занял памяти " + usedMBytes + " Mb");
        //System.out.println("Стало");
        //System.out.println(Arrays.toString(x1));//раскомментировать чтобы вывести массив

        startT = System.currentTimeMillis();
        startM = mem();
        System.out.println("\n    Ведётся подсчёт времени для Самописного метода.\n");
        x2 = Sort.function_sort(x2);
        System.out.println("Самописный метод занял времени " + ((float) (System.currentTimeMillis() - startT)) / 1000 + " s");
        usedMBytes = (Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) / 1048576;
        System.out.println("Самописный метод занял памяти " + usedMBytes + " Mb");
        //System.out.println(Arrays.toString(x2));//раскомментировать чтобы вывести массив

    }

    public static long mem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static int min_element(int array[]) {
        var min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int min_index(int array[]) {
        var min = array[0];
        
        for (int num : array) {
            if(num==220){continue;}
            if (num < min) {
                min = num;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]==220){continue;}
            if (array[i] == min) {
                return i;
            }
        }
        return 0;
    }

    public static int[] function_sort(int array[]) {
        int[] result = new int[array.length];

            for (int i = 0; i < array.length; i++) {
                result[i] = array[Sort.min_index(array)];
                array[Sort.min_index(array)] = 220;
                //System.out.println( result[i]+" ");
            }
        
        return result;
    }

}
