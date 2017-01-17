package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int disks=0;
        while(disks==0) {
            try {
                System.out.print("How Many disks should be solved for?  ");
                disks = scn.nextInt();
                if (disks < 0) {
                    disks = Math.abs(disks);
                }
            } catch (InputMismatchException i) {
                System.out.println("That wasn't a number. Try again.");
            }
        }
        int [][]tower=new int[3][disks];

    }
}
//odd:2
//even:1