package no01;

/**
 * 自定义数组类
 * @author Administrator
 *
 */
public class Array {

	/**
	 * 定义数组,类型为int
	 */
	private int[] arr;
	
	/**
	 * 定义数组的实际长度
	 */
	private int size;
	
	/**
	 * 初始化数组,传入数组长度
	 */
	public Array(int len) {
		this.arr = new int[len];
		this.size=0;
	}
	
	/**
	 * 重载构造
	 */
	public Array() {
		//默认长度为10
		this(10);
	}
	
	/**
	 *获取数组的长度 
	 */
	public int getCapacity() {
		return arr.length;
	}
	
	/**
	 * 获取数组中的元素个数
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 *判断数组是否为空 
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * 向所有元素后添加一个新元素
	 */
	public void addLast(int num) {
		add(size, num);
	}
	
	/**
	 * 向所有元素前添加一个新元素
	 */
	public void addFirst(int num) {
		add(0, num);
	}
	
	/**
	 * 在index索引的位置插入一个新元素
	 * @param index
	 * @param num
	 */
	public void add(int index,int num) {
		if(size==arr.length) {
			throw new IllegalArgumentException("数组已满");
		}
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("索引值不合法");
		}
		int len = size-1;
		for (int i = len; i >=index; i--) {
			arr[i+1]=arr[i];
		}
		arr[index]=num;
		size++;
	}
	
	/**
	 * 获取index索引位置的元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引超出或小于0");
		}
		return arr[index];
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Array:size=%d,capacity=%d\n", size,arr.length));
		buffer.append("[");
		for (int i = 0; i < size; i++) {
			buffer.append(arr[i]);
			if(i!=size-1) {
				buffer.append(", ");
			}
		}
		buffer.append("]");
		
		return buffer.toString();
	}
}
