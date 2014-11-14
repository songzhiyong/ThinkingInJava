package com.jerome.algos.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 如何让HashMap有序排列 --放入treemap
 * 
 * @author Administrator
 * 
 */
public class SortedMap {

	public static void main(String[] args) {
		HashMap<String, Double> map = new HashMap<String, Double>();
		ValueComparator valueComparator = new ValueComparator(map);
		TreeMap<String, Double> sortedMap = new TreeMap<String, Double>(valueComparator);
		map.put("B", 80.0);
		map.put("D", 60.0);
		map.put("A", 90.0);
		map.put("C", 70.0);
		System.out.println("unsorted map"+map);
		sortedMap.putAll(map);
		System.out.println("sorted map"+sortedMap);
	}

}

class ValueComparator implements Comparator<String> {

	Map<String, Double> base;

	public ValueComparator(Map<String, Double> base) {
		this.base = base;
	}

	public int compare(String a, String b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}
