package springbootmicroservices.employeeservice.Dto;

public class DepartmentDto {
	
	private long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentcode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getDepartmentcode() {
		return departmentcode;
	}
	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}
	
	public DepartmentDto() {
		super();
	}
	public DepartmentDto(long id, String departmentName, String departmentDescription, String departmentcode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentcode = departmentcode;
	}
}
