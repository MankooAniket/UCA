import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class RandomisedSet {
  HashMap<Integer, Integer> valuesToIndex;
  ArrayList<Integer> values;
  Random rand;

  public RandomisedSet() {
    valuesToIndex = new HashMap<>();
    values = new ArrayList<>();
    rand = new Random();
  }

  public boolean insert(int val) {
    if(valuesToIndex.containsKey(val)) return false;
    valuesToIndex.put(val, values.size());
    values.add(val);
    return true;
  }

  public boolean remove(int val) {
    if(!valuesToIndex.containsKey(val)) return false;
    int idx = valuesToIndex.get(val);
    int last = values.get(values.size() - 1);
    values.set(idx, last);
    valuesToIndex.put(last, idx);
    values.remove(values.size() - 1);
    valuesToIndex.remove(val);
    return true;
  }

  public int getRandom() {
    return values.get(rand.nextInt(values.size()));  
  }

  public static void main(String[] args) {
    RandomisedSet rs = new RandomisedSet();
    System.out.println(rs.insert(1));
    System.out.println(rs.insert(2));
    System.out.println(rs.insert(3));
    System.out.println(rs.getRandom());
    System.out.println(rs.remove(2));
    System.out.println(rs.getRandom());
  }
}
