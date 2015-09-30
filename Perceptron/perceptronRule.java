import java.lang.*;
import java.util.*;

public class perceptronRule{
  public static void main(String[] args){
    List<List<Integer>> trset = new ArrayList<List<Integer>>();

    List<Integer> s1 = new ArrayList<Integer>();
    s1.add(1);
    s1.add(1);
    s1.add(1);
    trset.add(s1);

    List<Integer> s2 = new ArrayList<Integer>();
    s2.add(1);
    s2.add(1);
    s2.add(-1);
    trset.add(s2);

    List<Integer> s3 = new ArrayList<Integer>();
    s3.add(1);
    s3.add(-1);
    s3.add(1);
    trset.add(s3);

    List<Integer> s4 = new ArrayList<Integer>();
    s4.add(-1);
    s4.add(1);
    s4.add(1);
    trset.add(s4);

    int[] tq = new int[4];
    tq[0] = 1;
    tq[1] = -1;
    tq[2] = -1;
    tq[3] = -1;

    int conti = 0;
    int loop = 0;
    int[] w = new int[3];
    int b = 0;
    int y = 0;

    while(conti < 4){
      int yin = GetYin(w, trset.get(loop%4), b);
      if (yin == 0)
        y = 0;
      else if(yin > 0)
        y = 1;
      else
        y = -1;

      int[] delta_w = new int[3];
      int delta_b = 0;
      if(y == tq[loop%4])
        conti ++;
      else{
        delta_w = CalDelta(trset.get(loop%4), tq[loop%4]);
        w = updateWeight(w, delta_w);
        delta_b = tq[loop%4];
        b = updateBias(b, delta_b);
        conti = 0;
      }
      myPrint(loop+1, trset.get(loop%4), yin, y, tq[loop%4], delta_w, delta_b, w, b);
      loop++;
    }
  }

  public static int GetYin(int[] w, List<Integer> s, int b){
    for(int i = 0; i < w.length; i++){
      b += w[i]*s.get(i);
    }
    return b;
  }

  public static int[] CalDelta(List<Integer> s, int t){
    int[] delta = new int[s.size()];
    for(int i = 0; i < s.size(); i++){
      delta[i] = s.get(i)*t;
    }
    return delta;
  }

  public static int[] updateWeight(int[] w, int[] delta_w){
    for(int i = 0; i < w.length; i++){
      w[i] = w[i] + delta_w[i];
    }
    return w;
  }

  public static int updateBias(int b, int t){
    return b+t;
  }

  public static void myPrint(int loop, List<Integer> s, int yin, int y, int t, int[] delta_w, int delta_b, int[] w, int b){
    System.out.format("%-5d     %-1s %-1d %-1d %-1d %-5s      %-10d  %-10d %-10d   %-1s %-1d %-1d %-1d %-5s    %-10d   %-1s %-1d %-1d %d %-5s   %-10d", loop, "[", s.get(0), s.get(1), s.get(2) ,"]",  yin, y, t,    "[", delta_w[0], delta_w[1], delta_w[2],"]",        delta_b,         "[", w[0], w[1], w[2], "]",         b);
    System.out.println();
  }
}
