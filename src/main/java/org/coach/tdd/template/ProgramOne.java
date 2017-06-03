package org.coach.tdd.template;


/**
 * Created by byhieg on 17/6/2.
 * Mail to byhieg@gmail.com
 */
public class ProgramOne {

    private  int[] list = new int[10];

    
    public boolean isOdd(int i) {

        return i % 2 != 0;
    }

    public boolean isEven(int i) {
        return i % 2 == 0;
    }

    public void createList(int[] list) {
        for (int i = 0; i < 10; i++) {
            list[i] = i + 1;
        }
    }

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }
}
