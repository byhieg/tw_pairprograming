package org.coach.tdd.template;

/**
 * Created by byhieg on 17/6/2.
 * Mail to byhieg@gmail.com
 */
public class FizzBuzz {

    public void fb() {
        for (int i = 1; i <= 100; i++) {
            if (isFizzBuzz(i)) {
                System.out.println("FizzBuzz");
            } else if (isFizz(i)) {
                System.out.println("Fizz");
            } else if (isBuzz(i)) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public boolean isFizz(int a) {
        if (a < 0 || a > 100) {
            throw new RuntimeException();
        }
        return a % 3 == 0 && a % 5 != 0;
    }

    public boolean isBuzz(int a) {
        if (a < 0 || a > 100) {
            throw new RuntimeException();
        }
        return a % 5 == 0 && a % 3 != 0;
    }

    public boolean isFizzBuzz(int a) {
        if (a < 0 || a > 100) {
            throw new RuntimeException();
        }
        return a % 3 == 0 && a % 5 == 0;
    }
}
