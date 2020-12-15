package tw.team4.jspproject.javabean;

import java.sql.Blob;

public class CompanyJavabean {
	
	private int companyId;
	private String companyName;
	private Blob logo;
	private String uniformNumbers;
	private String categories;
	private String account;
	private String password;
	private String email;
	private String phone;
	private Blob busRC;
	private int bankId;
	
	public CompanyJavabean() {
		
	}
	//Query
	public CompanyJavabean(int companyId, String companyName, String uniformNumbers, String categories,
			String account, String password, String email, String phone, int bankId) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		
		this.uniformNumbers = uniformNumbers;
		this.categories = categories;
		this.account = account;
		this.password = password;
		this.email = email;
		this.phone = phone;
		
		this.bankId = bankId;
	}
	
	public CompanyJavabean(String companyName) {
		super();
		
		this.companyName = companyName;
	}
	
	public CompanyJavabean(int companyId, String companyName, Blob logo, String uniformNumbers, String categories,
			String account, String password, String email, String phone, Blob busRC, int bankId) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.logo = logo;
		this.uniformNumbers = uniformNumbers;
		this.categories = categories;
		this.account = account;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.busRC = busRC;
		this.bankId = bankId;
	}

	public CompanyJavabean(String companyName, String uniformNumbers, String categories,
			String account, String password, String email, String phone, int bankId) {
		super();
		
		this.companyName = companyName;
		
		this.uniformNumbers = uniformNumbers;
		this.categories = categories;
		this.account = account;
		this.password = password;
		this.email = email;
		this.phone = phone;
		
		this.bankId = bankId;
	}
	//驗證帳密
	public CompanyJavabean(	 String password,String account) {
		super();
		this.account = account;
		this.password = password;
	}
//	public CompanyJavabean(String companyName, Blob logo, String uniformNumbers, String categories,
//			String account, String password, String email, String phone, Blob busRC, int bankId) {
//		super();
//		
//		this.companyName = companyName;
//		this.logo = logo;
//		this.uniformNumbers = uniformNumbers;
//		this.categories = categories;
//		this.account = account;
//		this.password = password;
//		this.email = email;
//		this.phone = phone;
//		this.busRC = busRC;
//		this.bankId = bankId;
//	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	public String getUniformNumbers() {
		return uniformNumbers;
	}
	public void setUniformNumbers(String uniformNumbers) {
		this.uniformNumbers = uniformNumbers;
	}
	public String getCategories () {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Blob getBusRC() {
		return busRC;
	}
	public void setBusRC(Blob busRC) {
		this.busRC = busRC;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	
}
