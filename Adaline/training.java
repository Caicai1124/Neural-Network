import java.lang.*;
import java.util.*;

public class training{
  private static void updateW0(List<Double> w, double gradient, double alpha){
    double b_new = w.get(0) - 2 * alpha * gradient;
    w.set(0, b_new);
    return;
  }

  private static void updateWi(List<Double> w, int i, double gradient, double alpha, List<Integer> cur){
    double w_new = (double)(w.get(i) - 2 * alpha * gradient * cur.get(i));
    w.set(i, w_new);
    return;
  }
  private static double calGradient(List<Integer> cur, List<Double> w, int t){
    double gradient = 0;
    for(int i = 0; i<cur.size(); i++){
      gradient += (double)cur.get(i)*w.get(i);
    }
    gradient -= t;
    return gradient;
  }

  private static List<Integer> createArray(int i0, int i1, int i2, int i3, int i4 ){
    List<Integer> ret = new ArrayList<Integer>();

    ret.add(i0);
    ret.add(i1);
    ret.add(i2);
    ret.add(i3);
    ret.add(i4);

    return ret;
  }

  public static void main(String[] args){

    List<List<Integer>> TS = new ArrayList<List<Integer>>();

    TS.add(createArray(1,1,1,1,1));    
    TS.add(createArray(1,-1,1,-1,-1));
    TS.add(createArray(1,1,1,1,-1));
    TS.add(createArray(1,1,-1,-1,1));

    List<Integer> t = new ArrayList<Integer>();

    t.add(1);
    t.add(1);
    t.add(-1);
    t.add(-1);

    List<Double> w = new ArrayList<Double>();
    w.add(0.0);
    w.add(0.0);
    w.add(0.0);
    w.add(0.0);
    w.add(0.0);

    int count = 0;
    double alpha = 0.1;
    double gradient = 1.0;

    double res = 0;
    boolean sig = false;
    while(!sig || ((gradient < -0.2) || (gradient > 0.2))){
      gradient = calGradient(TS.get(count%4), w, t.get(count%4));
      updateW0(w, gradient, alpha);
      for(int i = 1; i < 5; i++){
        updateWi(w, i, gradient, alpha, TS.get(count%4));
      }
      count++;
      sig = true;
      for(int i = 0; i < 4; i++){
        res = 0;
        for(int j = 1; j < 5; j++){
          res += TS.get(i).get(j) * w.get(j);
        }
        if(res * t.get(i) < 0){
          sig = false;
        }
      }
      if((count+1) % 4 == 0){
        alpha *= 0.5;
      }
      System.out.println("gradient: "+ gradient);
    }

    System.out.println(w);

    System.out.println(count);
    for(int i = 0; i < 4; i++){
      res = 0;
      for(int j = 1; j < 5; j++){
        res += TS.get(i).get(j) * w.get(j);
      }
      System.out.println(res);
    }
    return; 

  }
}
