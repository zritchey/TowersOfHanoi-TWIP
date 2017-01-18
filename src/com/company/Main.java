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

        solve(disks,1,2,3);
        System.out.println("The game is solved");

    }
     public static void solve(int d, int from, int b, int to){

             if(d != 0){
                 solve(d - 1, from, to, b,);
                 System.out.println("Disk " + d + " from " + from + " to " + to);

                 solve(d - 1, b, from, to);


         }

     }
}


// the moves alternate left and right, the board can be thought of as a circle. the bottom of the stack has to
//shift in the desirable direction.