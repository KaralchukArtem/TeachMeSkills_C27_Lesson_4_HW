import javax.swing.text.html.parser.Parser;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int[] input1 = new int[]{8,9,8,9,4};
        System.out.println(Arrays.toString(input1));
        int[] output1 = addOne(input1);
        System.out.println(Arrays.toString(output1));
        System.out.println("\n\nforward");
        forward(input1);
        System.out.println("\n\nminMax");
        minMax(input1);
        System.out.println("\nzero");
        zero(input1);
        System.out.println("\nswap");
        swap(input1);
        System.out.println("\nincrease");
        increase(input1);
        System.out.println("\nswap");
        swap(input1);
        System.out.println("\nincrease");
        increase(input1);
    }

    //... *
    public static int[] addOne(int[] arr){
        int pow = 0;
        int div = 0;
        int result = 0;
        int[] resultArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i == 0)
                pow = (int) Math.pow(10,arr.length - 1);
            else
                pow = (int) Math.pow(10,arr.length - (i+1));
            result += arr[i] * pow;
        }
        System.out.println(result + "sdg");
        int count = 0;
        for (int i = 0; i < resultArr.length; i++) {
            if(i == 0) {
                div = (int) Math.pow(10, arr.length - 1);
                resultArr[i] = (result / div);
            }
            else {
                div = (int) Math.pow(10, arr.length - (i + 1));
                count += resultArr[i] ;
                resultArr[i] = (result / div) - ((result / (div*10)) * 10);
            }
        }
        boolean truth = true;
        int i = arr.length - 1;
        int[] newArr = new int[]{};

        while (truth){
            resultArr[i] +=1;
            if(resultArr[i] >= 10 && i >=1){
                resultArr[i] = 0;
                resultArr[i-1] +=1;
                i--;
            }
            if(resultArr[i] < 10){
                truth = false;
            }
            if (resultArr[i] >=10 && i == 0) {
                System.out.println("Haloy");
                newArr = Arrays.copyOf(resultArr,resultArr.length+1);
                newArr[0] = 1;
                truth = false;
            }
        }
        System.out.println(Arrays.toString(resultArr));
        System.out.println(Arrays.toString(newArr));


        return newArr;
    }

    public static int[] forward(int[] arr){
        System.out.println("Вперед");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nНазад");
        for (int i = arr.length-1; i >= 0 ; i--) {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static int[] minMax(int[] arr){
        int min = arr[0];
        int max = arr[0];
        int indexMin = 0;
        int indexMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
                indexMin = i;
            }else if (max < arr[i]){
                max = arr[i];
                indexMax = i;
            }
        }
        System.out.println("min = " + min + " индекс = " + indexMin);
        System.out.println("max = " + max + " индекс = " + indexMax);
        return arr;
    }

    public static  int[] zero(int[] arr){
        int zeroCunt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                zeroCunt++;
            }
        }
        if (zeroCunt == 0){
            System.out.println("Нулей нет");
        }else {
            System.out.println("Нулей - " + zeroCunt);
        }
        return arr;
    }

    public static int[] swap(int[] arr){
        System.out.println(Arrays.toString(arr));
        int lengthArr = arr.length/2;
        int between = 0;
        for (int i = 0, j=arr.length-1; i < lengthArr; i++,j--) {
            between = arr[i];
            arr[i] = between + arr[j] - between;
            arr[j] = arr[j] + between - arr[j];
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] increase(int[] arr){
        int count = 0;
        for (int i = arr.length-1; i >0; i--) {
            if (arr[i]>arr[i-1]){
                count++;
            }
        }
        if (count == arr.length-1){
            System.out.println("Возрастающий");
        }
        else {
            System.out.println("Не возрастающий");
        }
        return arr;
    }


}