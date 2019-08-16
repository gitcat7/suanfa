package array;

/**
 * 自定义数组类,添加泛型,适用于任何类型
 * @author Administrator
 *
 */
public class Array<E> {

	/**
	 * 定义数组,类型为int
	 */
	private E[] arr;
	
	/**
	 * 定义数组的实际长度
	 */
	private int size;
	
	/**
	 * 初始化数组,传入数组长度
	 */
	@SuppressWarnings("unchecked")
	public Array(int len) {
		this.arr = (E[])new Object[len];
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
	public void addLast(E e) {
		add(size, e);
	}
	
	/**
	 * 向所有元素前添加一个新元素
	 */
	public void addFirst(E e) {
		add(0, e);
	}
	
	/**
	 * 在index索引的位置插入一个新元素
	 * @param index
	 * @param num
	 */
	public void add(int index,E e) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("索引值不合法");
		}
		if(size==arr.length) {//当数组满时,自动扩容2倍
			resize(2*arr.length);
		}
		int len = size-1;
		for (int i = len; i >=index; i--) {
			arr[i+1]=arr[i];
		}
		arr[index]=e;
		size++;
	}
	
	/**
	 * 获取index索引位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("索引超出或小于0");
		}
		return arr[index];
	}
	
	/**
	 * 修改index索引位置的元素为e
	 * @throws IllegalAccessException 
	 */
	public void set(int index, E e) throws IllegalAccessException{
		if(isEmpty()) {
			System.out.println("数组为空");
			return;
		}
		if(index<0||index>=size) {
			throw new IllegalAccessException("索引不存在");
		}
		arr[index]=e;
	}
	
	/**
	 * 查找数组中是否有元素num
	 */
	public boolean contains(E e){
		if(isEmpty()) {
			System.out.println("数组为空");
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==e) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
	 * @throws IllegalAccessException 
	 */
	public int find(E e) throws IllegalAccessException{
		if(isEmpty()) {
			System.out.println("数组为空");
			return -1;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==e) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 从数组中删除index位置的元素, 返回删除的元素
	 * @param index
	 * @return
	 * @throws IllegalAccessException 
	 */
	public E remove(int index) throws IllegalAccessException{
		if(index<0||index>=size) {
			throw new IllegalAccessException("索引不存在");
		}
		E e = arr[index];
		//防止超出索引
		for (int i = index+1; i < size; i++) {
			arr[i-1]=arr[i];
		}
		arr[size-1]=null;
		size--;
		//当实际数据个数少于总长度的一半时,数组缩小一半
		if(size<=arr.length/2) {
			resize(arr.length/2);
		}
		return e;
	}
	
	/**
	 * 从数组中删除第一个元素, 返回删除的元素
	 * @return
	 * @throws IllegalAccessException 
	 */
	public E removeFirst() throws IllegalAccessException{
		return remove(0);
	}
	
	/**
	 * 动态扩容数组的长度(2倍)
	 * @param newCapacity
	 */
	private void resize(int newCapacity) {
		@SuppressWarnings("unchecked")
		E[] newArr = (E[]) new Object[newCapacity];
		//将原始数组中的数据copy到新数组中
		for(int i = 0;i<size;i++) {
			newArr[i]=arr[i];
		}
		arr = newArr;
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
