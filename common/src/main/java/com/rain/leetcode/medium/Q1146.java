package com.rain.leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q1146 {
    Map<Integer, Integer>[] array;
    int snapId = 0;

    public Q1146(int length) {
        array = new LinkedHashMap[length];
        for (int i = 0; i < length; i++) {
            array[i] = new LinkedHashMap<>();
        }
    }

    public void set(int index, int val) {
        array[index].put(snapId, val);
    }

    public int snap() {
        snapId++;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        if (array[index].containsKey(snap_id) || array[index].isEmpty()) {
            return array[index].getOrDefault(snap_id, 0);
        }

        Integer preSnapId = 0;
        for (Integer currentSnapId : array[index].keySet()) {
            if (currentSnapId > snap_id) {
                return array[index].getOrDefault(preSnapId, 0);
            }
            preSnapId = currentSnapId;
        }
        return array[index].get(preSnapId);
    }

    public static void main(String[] args) {
     /*   Q1146 q1146 = new Q1146(1);
        q1146.set(0, 15);
        q1146.snap();
        q1146.snap();
        q1146.snap();
        q1146.get(0, 2);
        q1146.snap();
        q1146.snap();
        q1146.get(0, 0);
*/

       /* ["SnapshotArray","snap","get","get","set","get","set","get","set"]
		[[2],            [],      [1,0],[0,0],[1,8],[1,0],[0,20],[0,0],[0,7]]*/
        Q1146 q1146 = new Q1146(2);
        q1146.snap();
        q1146.get(1, 0);
        q1146.get(0, 0);
        q1146.set(1, 8);
        q1146.get(1, 0);
        q1146.set(0, 20);
        q1146.get(0, 0);
        q1146.set(0, 7);
    }
}
