package com.jerome.basic;

import java.util.ArrayList;
import java.util.Arrays;

import com.jerome.basic.beans.Person;
import com.jerome.basic.beans.Student;
import com.jerome.basic.beans.Worker;

public class EqualsTest {

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<>();
		Person person1 = new Student("Liming", 25, "123456",
				"Tstinghua University");
		Person person2 = new Worker("Liming", 25, "123456", "XX Factory");
		Person person3 = new Worker("Chifan", 25, "456789", "XX Factory");
		System.out.println(person1.equals(person2));
		persons.add(person1);
		persons.add(person2);

		System.out.println(Arrays.toString(persons.toArray()));

		person1.setName("Wudi");
		System.out.println(Arrays.toString(persons.toArray()));
		persons.set(1, person3);
		System.out.println(Arrays.toString(persons.toArray()));

		// String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
	}
}
