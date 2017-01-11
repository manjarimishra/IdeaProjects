package com.company;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static javafx.scene.input.KeyCode.F;

/**
 * File Name: PowerBall.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: IntUtil.java RandomInt.java PowerBall.java
 */

class PowerBall {
  /*
   * ALL PRIVATE DATA BELOW
   * CANNOT ADD ANY MORE MEMBER
   */
  private int[] winningNumber ;
  private int[] ticketNumber ;
  private long cash ;
  static private boolean display = true ;
  static final long jackpot = 100000000;

  private void printNumbers() {
  }


  int toCash (int e,int f){

    return 100;
  }


  int [] Compare1 (int []A, int []B){
    int PballA = A[5];
    int PballB=  B[5];
    int[]AA = new int[5];
    System.arraycopy(A,0,AA,0,5);
    int[]BB = new int[5];
    System.arraycopy(B,0,BB,0,5);

    Map<Integer,Integer> FA = CreateFtable(AA);
    Map<Integer, Integer> FB = CreateFtable(BB);
    int e = Compare2(FA,FB);
    int f = 0;
    if (PballA == PballB)
    {
      f   = 1;
    }
    else
    {
      f = 0;
    }

    int[] C = new int [2];
    C [0] = e;
    C [1] = f;
    return C;
  }

  Map<Integer,Integer> CreateFtable (int [] X) {
    Map<Integer,Integer> m = new TreeMap<>();

    for (int a:X) {
      if (m.containsKey(a))
      {
        int temp = m.get(a) + 1;
        m.put(a, temp);
      }
      else
      {
        m.put(a, 1);
      }
    }
    return m;
  }

  int Compare2 (Map<Integer,Integer> X, Map <Integer,Integer> Y) {
    Iterator itX = X.entrySet().iterator();

    int Cnt = 0;

    while (itX.hasNext()) {
      Map.Entry entry = (Map.Entry) itX.next();
      int myOcc = (Integer) entry.getValue();
      int curNum = (Integer) entry.getKey();
      int winOcc = 0;
      if (Y.containsKey(curNum)) {
        winOcc = Integer.min(Y.get(curNum), myOcc);
      }

      Cnt += winOcc;
    }

    return Cnt;

  }




  public long cash() {
    return cash ;
  }
  
  public  void check(int [] A, int [] B) {
    int [] C = Compare1 (A,B);
    int D = toCash (C[0],C[1]);
    System.out.println("You won:" + D);
     //WRITE CODE HERE
     //YOU CAN WRITE AS MANY PRIVATE ROUTINES AS YOU NEED
  }
  
  PowerBall(int[] w, int [] t) {
    winningNumber = w ;
    ticketNumber = t ;
    cash = 0 ;
    check(w,t) ;
  }
  
  private static void test1() {
    //CANNOT CHANGE BELOW
    int[] w = {4,8,19,27,24,10} ;
    {
      int [] n= {4,8,19,27,24,10} ;
      PowerBall x = new PowerBall(w,n);
    }
    {
      int [] n= {24,27,19,8,4,10} ;
      PowerBall x = new PowerBall(w,n);
    }
    {
      int [] n= {24,27,19,8,4,5} ;
      PowerBall x = new PowerBall(w,n);
    }
    {
      int [] n= {124,127,119,18,14,10} ;
      PowerBall x = new PowerBall(w,n);
    }
    {
      int [] n= {124,127,119,18,14,5} ;
      PowerBall x = new PowerBall(w,n);
    }
    {
      int [] n= {124,127,119,18,14,2} ;
      PowerBall x = new PowerBall(w,n);
    }
    {
      int [] n= {124,124,19,119,18,14} ;
      PowerBall x = new PowerBall(w,n);
    }  
  }
  
  private static void testRandom() {
  //CANNOT CHANGE BELOW
    System.out.println("----------testRandom()  starts-------------") ;
    display = false ;
    int[] w = {4,8,19,27,24,10} ;
    int max = 1000000 ;
    long c = 0 ;
    System.out.println("Buying " + max + " tickets of worth " + max * 2 +"$") ;
    for (int i = 0; i < max; ++i) {    
      int [] n = RandomInt.generateRandomNumber(6,true,1,60);
      PowerBall x = new PowerBall(w,n); 
      if (x.cash() == jackpot) {
        System.out.println("Won Jacckpot") ;
      }
      c = c + x.cash();
    }
    long p = (c -(max*2)) ;
    System.out.println("Out of " + max + " times you win " + c + "$") ;
    if (p > 0) {
      System.out.println("Profit = " + p) ;
    }else {
      System.out.println("Loss = " + p) ;
    }
    System.out.println("----------testRandom()  ends-------------") ;
  }
  
  private static void testBench() {
  //CANNOT CHANGE BELOW
    test1() ;
    //testRandom() ;
  }
  
  public static void main(String[] args) {
  //CANNOT CHANGE BELOW
    System.out.println("PowerBall.java");
    testBench();
    System.out.println("Done");
  }
}