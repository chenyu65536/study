package com.rain.leetcode.medium;

import java.util.*;

public class Q380 {

    HashMap<Integer, Integer> values;
    List<Integer> listValues;
    Random random;

    public Q380() {
        values = new HashMap();
        listValues = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (values.containsKey(val)) {
            return false;
        }
        values.put(val, listValues.size());
        listValues.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!values.containsKey(val)) {
            return false;
        }
        int index = values.remove(val);
        int lastVal = listValues.get(listValues.size() - 1);

        if (lastVal != val) {
            listValues.set(index, lastVal);
            values.put(lastVal, index);
        }
        listValues.remove(listValues.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomNum = random.nextInt(values.size());
        return listValues.get(randomNum);

    /*    ["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
            [[],[0],[0],[0],[],[0],[0]]
        2,*/
    }

    public static void main(String[] args) {
        Q380 q380 = new Q380();
        q380.remove(0);
        q380.remove(0);
        q380.insert(0);
        q380.getRandom();
        q380.remove(0);
        q380.insert(0);
        q380.getRandom();
    }

}
