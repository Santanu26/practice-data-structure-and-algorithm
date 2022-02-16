package design_pattern.solid.open_close;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bird1 b = new European();
        System.out.println(b.getBaseSpeed());

        Bird1 b2 = new Indian();
        System.out.println(b2.getBaseSpeed());


        List<Integer> integers = Arrays.asList(-4, 3, - 9, 0, 4, 1);
        plusMinus(integers);
    }
    public static void plusMinus(List<Integer> arr) {

        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int i = 0;i< arr.size();i++) {
            if (arr.get(i)>0) {
                positive++;
            } else if (arr.get(i)<0) {
                negative++;
            } else {
                zero++;
            }
        }
        float i = positive / arr.size();
        System.out.println((double)(positive/arr.size()));
        System.out.println(negative/arr.size());
        System.out.println(zero/arr.size());
    }
}
