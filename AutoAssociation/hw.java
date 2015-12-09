import java.lang.*;
import java.util.*;

public class hw{
  public static void Generate_Test_Vectors(List<List<Integer>> ret, List<Integer> cur, int n){
    if(cur.size() == n){
      ret.add(new ArrayList<Integer>(cur));
      return;
    }

    for(int i = 0; i < 2; i++) {
      cur.add(i);
      Generate_Test_Vectors(ret, cur, n);
      cur.remove(cur.size()-1);
    }
  }

  public static void main(String[] args){
    int[] s1 = {1, -1, 1, 1};
    int[] s2 = {1, 1, 1, -1};
    int len = s1.length;
    int[][] W = new int[len][len];

    for(int i = 0; i < len; i++){
      for(int j = 0; j < len; j++) {
        W[i][j] = s1[i]*s1[j];
      }
    }

    for(int i = 0; i < len; i++){
      for(int j = 0; j < len; j++) {
        W[i][j] += s2[i]*s2[j];
      }
    }

    for(int i = 0; i < len; i++){
      W[i][i] = 0;
    }

    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    Generate_Test_Vectors(ret, new ArrayList<Integer>(), len);

    int[] order = {0,3,1,2};

    System.out.println("  Original     Converged");

    for(int i = 0; i < ret.size(); i++) {
      List<Integer> x = ret.get(i);
      List<Integer> y = new ArrayList<Integer>(x);
      int step = 0;
      int succ = 0;
      while(succ < 4){
        step++;
        for(int j : order){
          int yin = y.get(j);
          for(int k = 0; k < len; k++){
            yin += y.get(k)*W[k][j];
          }
          if (yin > 0) {
            if (y.get(j) == 1) succ++;
            else succ = 0;
            y.set(j,1);
          } else if (yin < 0) {
            if(y.get(j) == 0) succ++;
            else succ = 0;
            y.set(j, 0);
          } else{
            if(y.get(j) == 0) succ++;
          }
        }
      }
      System.out.println(x+"  "+y);
    }
  }
}
