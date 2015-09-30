import java.lang.*;

public class HebbTest{
  public static int[] Cal_Weight(int[] s1, int t1,  int[] s2, int t2){
    int[] w = new int[s1.length];

    for(int i = 0; i <s1.length; i++){
      w[i] = s1[i]*t1 + s2[i]*t2;
    }

    return w;
  }

  public static boolean Check(int[] w, int b, int[] s, int t, int threshold){
    int yin = 0;
    for(int i = 0; i < w.length; i++){
      yin += w[i]*s[i];
    }

    System.out.println("yin is: "+yin);
    int y = 0;
    if(yin >= threshold)
      y = 1;
    else
      y = -1;

    System.out.println("y is: "+y);

    return y == t? true: false;
  }

  public static void main(String[] args){
    int[] s1 = {-1,  1,  1, 
                 1, -1, -1, 
                 1, -1, -1, 
                 1, -1, -1, 
                -1,  1,  1};

    int t1 = 1;

    int[] s2 = { 1,  1, -1, 
                 1, -1,  1, 
                 1, -1,  1, 
                 1, -1,  1, 
                 1,  1, -1};

    int t2 = -1;

    int[] w = Cal_Weight(s1, t1, s2, t2);
    int b = t1+t2;

    System.out.println("Weights and bias updated by Hebb's learning rule: ");
    System.out.print("w = [ ");
    for(int i: w){
      System.out.print(i+" ");
    }
    System.out.print("]");
    System.out.println();
    System.out.println("b = " + b);
    System.out.println();

    int[] s3 = {0,  1,  1,
                0, -1, -1,
                0, -1, -1,
                0, -1, -1,
                0,  1,  1};

    int t3 = 1;
    //boolean ret3 = Check(w, b, s3, t3, 0);
    //System.out.println("Result for trainsing set s3 is "+ ret3);

    int[] s4 = {-1,  0,  1,
                 1,  0, -1,
                 1,  0, -1,
                 1,  0, -1,
                -1,  0,  1};
    int t4 = 1;
    //boolean ret4 = Check(w, b, s4, t4, 0);
    //System.out.println("Result for trainsing set s4 is "+ ret4);

    int[] s5 = {-1,  1,  0,
                 1, -1,  0,
                 1, -1,  0,
                 1, -1,  0,
                -1,  1,  0};
    int t5 = 1;
    //boolean ret5 = Check(w, b, s5, t5, 0);
    //System.out.println("Result for trainsing set s5 is "+ ret5);
    //System.out.println();

    //boolean ret2 = Check(w, b, s2, t2, 0);
    //System.out.println("Result for trainsing set s2 is "+ ret2);


    int[] s6 = { 0,  1, -1,
                 0, -1,  1,
                 0, -1,  1,
                 0, -1,  1,
                 0,  1, -1};

    int t6 = -1;
    //boolean ret6 = Check(w, b, s6, t6, 0);
    //System.out.println("Result for trainsing set s6 is "+ ret6);

    int[] s7 = { 1,  0, -1,
                 1,  0,  1,
                 1,  0,  1,
                 1,  0,  1,
                 1,  0, -1};

    int t7 = -1;
    //boolean ret7 = Check(w, b, s7, t7, 0);
    //System.out.println("Result for trainsing set s7 is "+ ret7);

    int[] s8 = { 1,  1,  0,
                 1, -1,  0,
                 1, -1,  0,
                 1, -1,  0,
                 1,  1,  0};

    int t8 = -1;
    //boolean ret8 = Check(w, b, s8, t8, 0);
    //System.out.println("Result for trainsing set s8 is "+ ret8);
    
    int[] s9 = {0,  0,  1,
                0,  0, -1,
                0,  0, -1,
                0, -1, -1,
                0,  1,  1};

    int t9 = 1;
    //boolean ret9 = Check(w, b, s9, t9, 0);
    //System.out.println("Result for trainsing set s9 is "+ ret9);

    int[] s10 = {-1, 1,  0,
                 1, -1,  0,
                 1,  0,  0,
                 1,  0,  0,
                -1,  0,  0};
    int t10 = 1;
    //boolean ret10 = Check(w, b, s10, t10, 0);
    //System.out.println("Result for trainsing set s10 is "+ ret10);
    int[] s11 = {0,  0, -1,
                 0,  0,  1,
                 0,  0,  1,
                 0, -1,  1,
                 0,  1, -1};

    int t11 = -1;
    //boolean ret11 = Check(w, b, s11, t11, 0);
    //System.out.println("Result for trainsing set s11 is "+ ret11);

    int[] s12 = {1,  1,  0,
                 1, -1,  0,
                 1,  0,  0,
                 1,  0,  0,
                 1,  0,  0};

    int t12 = -1;
    //boolean ret12 = Check(w, b, s12, t12, 0);
    //System.out.println("Result for trainsing set s12 is "+ ret12);

    int[] s13 = {1, -1,  1,
                 1, -1,  1,
                -1,  1, -1,
                 1, -1,  1,
                 1, -1,  1};
    int t13 = -1;
    System.out.println("Input training set: ");
    System.out.print("w = [ ");
    for(int i: s13){
      System.out.print(i+" ");
    }
    System.out.print("]");
    System.out.println();
    boolean ret13 = Check(w, b, s13, t13, 0);
    System.out.println("Result for trainsing set s13 is "+ ret13);
  }
} 
