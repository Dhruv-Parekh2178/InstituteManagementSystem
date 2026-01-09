package Util;

import java.util.Scanner;

public class InputUtil{
    public static final Scanner sc = new Scanner(System.in);

    public static int readInt(){
        // while(!sc.hasNextInt()){
        //     System.out.println("Invalid input.Enter Number : ");
        //     sc.next();
        // }
        return sc.nextInt();
    }
    
     public static Byte readByte(){
        while(!sc.hasNextByte()){
            System.out.println("Invalid input.(exceeded reange)Enter Number : ");
            sc.next();
        }
        return sc.nextByte();
    }
    
     public static double readDouble(){
        while(!sc.hasNextDouble()){
            System.out.println("Invalid input.Enter Number : ");
            sc.next();
        }
        return sc.nextDouble();
    }

     public static String readString(){
        sc.nextLine();
        return sc.nextLine();
    }
}
