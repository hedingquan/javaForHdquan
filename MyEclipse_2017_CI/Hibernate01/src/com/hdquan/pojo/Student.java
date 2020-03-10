package com.hdquan.pojo;

public class Student {
	private StudentId id;
		private String major;
		public StudentId getId() {
			return id;
		}
		public void setId(StudentId id) {
			this.id = id;
		}
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		public  Student(StudentId id, String major) {
			super();
			this.id = id;
			this.major = major;
		}

}
