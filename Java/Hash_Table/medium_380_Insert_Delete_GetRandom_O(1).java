/***
Tags: Array, Hash_Table, Design
Create: 2019/5/19
Update: 2019/5/19

Problem description:
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.


Example:

	// Init an empty set.
	RandomizedSet randomSet = new RandomizedSet();

	// Inserts 1 to the set. Returns true as 1 was inserted successfully.
	randomSet.insert(1);

	// Returns false as 2 does not exist in the set.
	randomSet.remove(2);

	// Inserts 2 to the set, returns true. Set now contains [1,2].
	randomSet.insert(2);

	// getRandom should return either 1 or 2 randomly.
	randomSet.getRandom();

	// Removes 1 from the set, returns true. Set now contains [2].
	randomSet.remove(1);

	// 2 was already in the set, so return false.
	randomSet.insert(2);

	// Since 2 is the only number in the set, getRandom always return 2.
	randomSet.getRandom();

***/

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


// My First Version (HashSet)
// Runtime: 101 ms (faster than 17.00%); Memory Usage: 44.8 MB (less than 90.21% )

class RandomizedSet {
    HashSet<Integer> set;
    int rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val))   return false;
        set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }
        else    return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        rand = random.nextInt(set.size());
        Iterator<Integer> it = set.iterator();
        
        for(int i = 0; i < rand; i++)    it.next();
        
        return it.next();
    }
}

// My Second Version (LinkedHashSet, idea from hgscoder)
// Runtime: 136 ms (faster than 11.52%); Memory Usage: 52 MB (less than 14.76%)

class RandomizedSet {
    LinkedHashSet<Integer> linked_set;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        linked_set = new LinkedHashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(linked_set.contains(val))    return false;
        linked_set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(linked_set.contains(val)){
            linked_set.remove(val);
            return true;
        }    
        else    return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int rand = random.nextInt(linked_set.size());
        return (int)linked_set.toArray()[rand];
    }
}