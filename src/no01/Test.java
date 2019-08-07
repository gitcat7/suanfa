package no01;

public class Test {

	public static void main(String[] args) {
		Array array = new Array(10);
		array.addLast(10);
		array.addFirst(1);
		array.add(1, 2);
		System.out.println(array);
	}
}
