import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < 20000; i++) {
            set.add(random.nextInt(9999999));
        }
        System.out.println(set.size());
        Integer[] arr = set.toArray(new Integer[set.size()]);
        Arrays.sort(arr);
        Integer[] arr4 = Arrays.copyOf(arr,arr.length);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);

        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        long l3 = System.currentTimeMillis();
        bubbleSort(arr2);
        long l4 = System.currentTimeMillis();
        long l5 = System.currentTimeMillis();
        selectionSort(arr3);
        long l6 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr4));
        long l7 = System.currentTimeMillis();
        insertionSort(arr4);
        long l8 = System.currentTimeMillis();
        System.out.println("Lung tung sort "+(l2-l1));
        System.out.println("Bubble sort "+(l4-l3));
        System.out.println("Selection "+ (l6-l5));
        System.out.println("Insert Sort "+(l8-l7));


    }
    public static void sort(Integer[] array){
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if(array[i]>array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }
    public static void bubbleSort(Integer[] array){
        boolean check = true;
        for (int i = 1; i < array.length && check; i++) {
            check = false;
            for (int j = 0; j < array.length-1-i ; j++) {
                if(array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    check = true;
                }
            }
        }
    }
    public static void selectionSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            Integer min = array[i];
            int indexMin = i;
            // tìm phần tử nhỏ nhất bên phải phần tử được chọn
            for (int j = i+1; j <array.length; j++) {
                if(min>array[j]){
                    min = array[j];
                    indexMin = j;
                }
            }
            // kiểm tra index và đổi chỗ
            if(indexMin!=i){
                array[indexMin] = array[i];
                array[i] = min;
            }
        }



    }
    public static void insertionSort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            Integer currentValue = array[i];
            int j ;
            for (j = i-1; j>=0 && currentValue<array[j]; j--) {
                    array[j+1] = array[j];
            }
            array[j+1] = currentValue;
        }
    }


}