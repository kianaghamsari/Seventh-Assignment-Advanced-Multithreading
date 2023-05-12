package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.

     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

    static BigDecimal pi = new BigDecimal(0);

    public static class PiCal implements Runnable {
        MathContext mc;
        int floatingPoint;
        BigDecimal d;

        public PiCal(int floatingPoint, BigDecimal d) {
            this.floatingPoint = floatingPoint;
            this.mc = new MathContext(floatingPoint + 2);
            this.d = d;;
        }

        public static BigDecimal factorial(int n) {
            if (n == 0) {
                return BigDecimal.valueOf(1);
            } else {
                return BigDecimal.valueOf(n).multiply(factorial(n - 1));
            }
        }

        public static synchronized void add(BigDecimal term) {
            pi = pi.add(term);
        }

        @Override
        public void run() {
            BigDecimal firstTerm = factorial(d.intValue());
            firstTerm = firstTerm.pow(2);
            BigDecimal secondTerm = BigDecimal.valueOf(2).pow(d.intValue() + 1);
            BigDecimal numerator = firstTerm.multiply(secondTerm);
            BigDecimal denominator = factorial((2 * d.intValue()) + 1);
            BigDecimal r = numerator.divide(denominator, mc);
            add(r);
        }
    }

    public String calculate(int floatingPoint)
    {
        pi = new BigDecimal(0);
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 4000; i++){
            PiCal task = new PiCal(floatingPoint, BigDecimal.valueOf(i));
            pool.execute(task);
        }
        pool.shutdown();
        try {
            if (pool.awaitTermination(20000, TimeUnit.MILLISECONDS)){
                pi = pi.setScale(floatingPoint, RoundingMode.DOWN);
                return String.valueOf(pi);
            } else {
                pool.shutdownNow();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself
    }
}
