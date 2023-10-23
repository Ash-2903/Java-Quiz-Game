package com.files;

import java.util.ArrayList;
import java.util.List;

public class Questions {
	
	public List<String> getQuesAndOption( int qNum ) {
		List<String> list =  new ArrayList<String>();
		
		switch(qNum) {
			case 1: list.add("Who invented Java Programming ?");
					list.add("Guido van Rossum");
					list.add("James Gosling");
					list.add("Dennis Ritchie");
					list.add("Bjarne Stroustrup");
					break;
			case 2: list.add("Which component is used to compile, debug and execute the java programs ?");
					list.add("JRE");
					list.add("JIT");
					list.add("JVM");
					list.add("JDK");
					break;
			case 3: list.add("What is the extension of java code files ?");
					list.add(".js");
					list.add(".txt");
					list.add(".class");
					list.add(".java");
					break;
			case 4: list.add("Which environment variable is used to set the java path ?");
					list.add("MAVEN_Path");
					list.add("JavaPATH");
					list.add("JAVA");
					list.add("JAVA_HOME");
					break;
			case 5: list.add("Which of the following is not an OOPS concept in Java ?");
					list.add("Polymorphism");
					list.add("Inheritance");
					list.add("Compilation");
					list.add("Encapsulation");
					break;
			case 6: list.add("Which exception is thrown when java is out of memory ?");
					list.add("MemoryError");
					list.add("OutOfMemoryError");
					list.add("MemoryOutOfBoundsException");
					list.add("MemoryFullException");
					break;
			case 7: list.add("Which of these are selection statements in Java ?");
					list.add("break");
					list.add("continue");
					list.add("for()");
					list.add("if()");
					break;
			case 8: list.add("Which of the following is a superclass of every class in Java ?");
					list.add("ArrayList");
					list.add("Abstract class");
					list.add("Object class");
					list.add("String");
					break;
			case 9: list.add("Which of these packages contains the exception Stack Overflow in Java ?");
					list.add("java.io");
					list.add("java.system");
					list.add("java.lang");
					list.add("java.util");
					break;
			case 10: list.add("Which of these keywords are used for the block to be examined for exceptions ?");
					list.add("check");
					list.add("throw");
					list.add("catch");
					list.add("try");
					break;
				
		}
		
		return list;
	}
	
	public String getCorrectAnswer(int qNum) {

		switch(qNum) {
			case 1: return "James Gosling";
			case 2: return "JVM";
			case 3: return ".class";
			case 4: return "JAVA_HOME";
			case 5: return "Compilation";
			case 6: return "OutOfMemoryError";
			case 7: return "if()";
			case 8: return "Object class";
			case 9: return "java.lang";
			case 10: return "try";
		}
		return "error";
	}

}
