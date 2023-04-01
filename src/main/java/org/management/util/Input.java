package org.management.util;

import java.util.Scanner;

public class Input {

    public static String inputString(String statement){

        Scanner sc = new Scanner(System.in);

        System.out.print(statement);

        return sc.nextLine();
    }

    public static short inputShort(String statement){

        Scanner sc = new Scanner(System.in);

        System.out.print(statement);

        return sc.nextShort();
    }

    public static Long inputLong(String statement){

        Scanner sc = new Scanner(System.in);

        System.out.print(statement);

        return sc.nextLong();
    }

    public static int inputInt(String statement){

        Scanner sc = new Scanner(System.in);

        System.out.print(statement);

        return sc.nextInt();
    }
}
