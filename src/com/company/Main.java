package com.company;

public class Main {

    public static void main(String[] args)
    {
        long startTime1 = System.nanoTime();

        unhandledFun();

        long endTime1 = System.nanoTime();

        long durationInNano1 = (endTime1 - startTime1);
        System.out.println("Unhandled " + durationInNano1);

        long startTime = System.nanoTime();
        optimized1();
        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);
        System.out.println("Opt1      " + durationInNano);
        long startTime2= System.nanoTime();
        optimized2();
        long endTime2 = System.nanoTime();
        long durationInNano2 = (endTime2 - startTime2);
        System.out.println("Opt2      " + durationInNano2);
    }

    public static void unhandledFun(){

        int[] vector = new int[2];
        int res = 0;

        for (int j = 500000000; j > 0; j--)
        {
            vector [0]++;
            vector [0]++;
        }

        vector[1] = vector[0];

        for (int j = 0; j < 10000000; j++)
        {
            vector [0]--;
            vector [0]--;
        }

        vector[1] = vector[0];

    }
    public static void optimized1(){
        int[] vector = new int[2];
        int res = 0;

        for (int j = 500000000; j > 0; j--)
        {
            vector [0]+= 2;
        }

        vector[1] = vector[0];

        for (int j = 0; j < 10000000; j++)
        {
            vector [0]-=2;
        }

        vector[1] = vector[0];

    }
    public static void optimized2(){
        int[] vector = new int[2];
        int res = 0;
        for (int j = 500000000; j > 0; j--)
        {
            res += 2;
        }
        vector[0] = res;

        vector[1] = vector[0];

        for (int j = 0; j < 10000000; j++)
        {
            res -= 2;
        }
        vector [0]-=res;
        vector[1] = vector[0];

    }
}
