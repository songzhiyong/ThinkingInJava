package com.jerome.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.jerome.basic.beans.Person;
/**
 * 反射获取构造函数，创建实例
 * @author Administrator
 *
 */
public class ReflectTest {
	public static void main(String[] args) {
		try {
			Class<?> cl = Class.forName("java.lang.String");
			Constructor<?> con = cl.getConstructor(StringBuffer.class);
			String str = (String) con.newInstance(new StringBuffer("123"));
			System.out.println(str);

			Class<?> personClz = Class.forName("com.jerome.basic.beans.Person");
			Constructor<?> personCon = personClz.getConstructor(String.class,
					int.class);
			Person person = (Person) personCon.newInstance("Jerome", 24);
			System.out.println(person.toString());
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
