package perfomance;

import java.util.ArrayList;

/**
 * Created by a.talismanov on 04.08.2016.
 */
public class testcontinue {
    private static int trueConditionContinueWins = 0;
    private static int trueConditionContinueLooses = 0;
    private static int falseConditionContinueWins = 0;
    private static int falseConditionContinueLooses = 0;


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            checkContinuePerfomance();
        }
        System.out.println("trueConditionContinueWins " + trueConditionContinueWins);
        System.out.println("trueConditionContinueLooses " + trueConditionContinueLooses);
        System.out.println("falseConditionContinueWins " + falseConditionContinueWins);
        System.out.println("falseConditionContinueLooses " + falseConditionContinueLooses);
    }

    private static void checkContinuePerfomance() {
        long start1 = System.nanoTime();

        long accum = 0;
        for (int i = 0; i < 1000000; i++) {
            if (10 > 5) {
                accum++;
            }
        }
        long finish1 = System.nanoTime();
        long result1 = finish1 - start1;
        System.out.println("Without continue time true condition " + result1);


        long start2 = System.nanoTime();

        long accum2 = 0;
        for (int i = 0; i < 1000000; i++) {
            if (!(10 > 5)) {
                continue;
            }
            accum2++;
        }
        long finish2 = System.nanoTime();
        long result2 = finish2 - start2;
        System.out.println("With continue time true condition " + result2);

        if (result2 < result1) {
            System.out.println("continue wins perfomance battle");
            trueConditionContinueWins++;
        } else {
            System.out.println("continue losses perfomance battle");
            trueConditionContinueLooses++;
        }

        System.out.println();
        System.out.println();


        long start3= System.nanoTime();

        long accum3 = 0;
        for (int i = 0; i < 1000000; i++) {
            if (10 < 5) {
                accum++;
            }
        }
        long finish3 = System.nanoTime();
        long result3 = finish3 - start3;
        System.out.println("Without continue time false condition " + result3);


        long start4 = System.nanoTime();

        long accum4 = 0;
        for (int i = 0; i < 1000000; i++) {
            if (!(10 > 5)) {
                continue;
            }
            accum4++;
        }
        long finish4 = System.nanoTime();
        long result4 = finish4 - start4;
        System.out.println("With continue time false condition " + result4);

        if (result4 < result3) {
            System.out.println("continue wins perfomance battle");
            falseConditionContinueWins++;
        } else {
            System.out.println("continue losses perfomance battle");
            falseConditionContinueLooses++;
        }

        System.out.println("done");
    }
}
