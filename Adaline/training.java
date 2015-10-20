import java.lang.*;
import java.util.*;

public class training{
  private static double updateWi(List<Double> w, int i, double gradient, double alpha, List<Integer> cur){
    return gradient * cur.get(i);
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

    List<Double> deltaW = new ArrayList<Double>();
    deltaW.add(0.0);
    deltaW.add(0.0);
    deltaW.add(0.0);
    deltaW.add(0.0);
    deltaW.add(0.0);

    int count = 0;
    double alpha = 0.2;
    double gradient = 1.0;

    double res = 0;
    boolean sig = false;
    int batch = 1;

    while(!sig || ((gradient < -0.2) || (gradient > 0.2))){
      if(((count+1) % batch == 0)){

        for(int i = 0; i < deltaW.size(); i++){
          deltaW.set(i, 0.0);
        }

        for(int i = 0; i < batch ; i++ ){
          int cur = (count + 1 + i - batch) % 4;

          gradient = calGradient(TS.get(cur), w, t.get(cur));

          deltaW.set(0, deltaW.get(0) + gradient);

          for(int j = 1; j < 5; j++){
            deltaW.set(j, deltaW.get(j) + gradient * TS.get(cur).get(j));
          }
        }

        for(int i = 0; i < deltaW.size(); i++){
          w.set(i, w.get(i) - alpha * (deltaW.get(i)/batch));
        }
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
        alpha *= 1;
      }
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
