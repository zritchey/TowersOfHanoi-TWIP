package com.company;

import java.util.ArrayList;
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
        ArrayList a =new ArrayList<Integer>(1);
        for(int i=disks;i>=0;i--){
            a.add(new Integer(i));
        }
        ArrayList []tower={a,new ArrayList<Integer>(1),new ArrayList<Integer>(1)};
        int i= (Integer)a.get(a.size()-1);
        a.remove(a.size()-1);
        a.trimToSize();
        System.out.println(a.toString());
        solve(tower);

    }
    public static void solve(ArrayList[]a){
        solve(a,0,0);

    }
     public static void solve(ArrayList[]a, int towr, int ct){
         a[0].trimToSize();
         a[1].trimToSize();
         a[2].trimToSize();
         if(a[0].size()==1&&a[1].size()==1){
             System.out.println("The puzzle is solved");
             System.out.println(ct);
         }
         else {
             ArrayList[] b= new ArrayList[3];
             System.arraycopy(a,0,b,0,3);
             a[0]=b[towr];
             a[1]=b[((towr+1)%3)];
             a[2]=b[((towr+2)%3)];
             if ((Integer) a[0].get(a[0].size() - 1) < (Integer) a[1].get(a[(1)].size() - 1) ) {
                 a[1].add(a[0].remove(a[0].size()-1));
                 solve(a,towr,ct++);
             }
             if ( (Integer) a[0].get(a[0].size() - 1) < (Integer) a[2].get(a[2].size() - 1)) {
                 a[2].add(a[0].remove(a[0].size()-1));
                 solve(a,towr,ct++);
             }

         }
     }
}
//odd:2
//even:1

//this is wrong. the moves alternate left and right, the board can be thought of as a circle. the bottom of the stack has to
//shift in the desirable direction.