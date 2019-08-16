package array;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7262331501856492001L;

	private Integer stuid;
	private String stuname;
	
	public Student(Integer stuid, String stuname) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
	}
	public Student() {
		super();
	}
	public Integer getStuid() {
		return stuid;
	}
	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + "]";
	}
	
}
