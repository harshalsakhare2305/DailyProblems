
//https://leetcode.com/problems/design-a-number-container-system/?envType=daily-question&envId=2025-02-08

/*1️⃣ Huge vis Array (int[(int)1e9+1])
You are allocating an array of size 10^9 (1 billion), which is too large and leads to memory exhaustion.
Instead, use a HashMap<Integer, Integer> to track indices.
2️⃣ Inefficient List<Integer> Storage
You are storing all indices in a List<Integer> and sorting them frequently.
Instead, use a TreeSet<Integer> (self-sorting, efficient insert/removal).
3️⃣ Inefficient change Method
If an index changes, you are modifying a List<Integer> using remove(index), which is O(N).
A TreeSet provides O(log N) insertions and deletions.*/


import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexMap;  // Stores (index -> number)
    private Map<Integer, TreeSet<Integer>> numberMap; // Stores (number -> sorted set of indices)

    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int prevNumber = indexMap.get(index);
            if (numberMap.containsKey(prevNumber)) {
                numberMap.get(prevNumber).remove(index);  // Remove old index
                if (numberMap.get(prevNumber).isEmpty()) {
                    numberMap.remove(prevNumber);  // Clean up empty TreeSet
                }
            }
        }

        indexMap.put(index, number);
        numberMap.putIfAbsent(number, new TreeSet<>());
        numberMap.get(number).add(index);
    }

    public int find(int number) {
        if (numberMap.containsKey(number) && !numberMap.get(number).isEmpty()) {
            return numberMap.get(number).first();  // Get smallest index
        }
        return -1;
    }
}

/**
 * Usage:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index, number);
 * int param_2 = obj.find(number);
 */
