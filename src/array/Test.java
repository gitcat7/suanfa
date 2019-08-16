package array;

public class Test {

	public static void main(String[] args) throws IllegalAccessException {
		Array array = new Array(3);
//		Student stu1 = new Student(1,"zs");
//		Student stu2 = new Student(2,"ll");
//		Student stu3 = new Student(3,"ww");
//		array.addFirst(stu3);
//		array.addLast(stu2);
//		array.add(1, stu1);
//		System.out.println(array);
		
		for (int i = 0; i < 4; i++) {//当数组容器满时,自动扩容2倍
			array.addFirst(i);
		}
		System.out.println(array);
		//当容器的数据少于长度的一半时,缩小一半
		array.removeFirst();
		array.remove(1);
		System.out.println(array);
	}
}
