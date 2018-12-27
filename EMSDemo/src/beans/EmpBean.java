package beans;

public class EmpBean {

	  @Override
	public String toString() {
		return "EmpBean [eid=" + eid + ", ename=" + ename + ", address=" + address + ", salary=" + salary + "]";
	}
	int eid;
	  String ename,address;
	  double salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	  
	  
	  
	
}
