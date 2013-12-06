package com.jerome.algos.beans;

public final class SortInt implements Comparable<SortInt> {
	public SortInt() {
		this(0);
	}

	public SortInt(int x) {
		value = x;
	}

	public int intValue() {
		return value;
	}

	public String toString() {
		return Integer.toString(value);
	}

	public boolean equals(Object rhs) {
		return rhs != null && value == ((SortInt) rhs).value;
	}

	public int hash(int tableSize) {
		if (value < 0)
			return -value % tableSize;
		else
			return value % tableSize;
	}

	private int value;

	@Override
	public int compareTo(SortInt o) {
		return value < ((SortInt) o).value ? -1
				: value == ((SortInt) o).value ? 0 : 1;

	}
}