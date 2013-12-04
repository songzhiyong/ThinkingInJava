package com.jerome.basic;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		UUID string = UUID.fromString(uuidString);
		System.out.println(string.equals(uuid));
	}
}
