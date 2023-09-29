package com.nt.test;

import java.lang.reflect.Constructor;//good

public class DynaObjectTest2{

	public static void main(String[] args) {
		try{  
			//load java class
			Class c=Class.forName(args[0]);
			//get constructors of class
			Constructor cons[]=c.getDeclaredConstructors();
			//object creation using 0-param constructor
			Object obj1=cons[0].newInstance();
			System.out.println("data of obj1:"+obj1);
			System.out.println("----------");
			//object creation using 2-param constructor
			Object obj2=cons[1].newInstance(38,39);
			System.out.println("data of obj1:"+obj2);
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
