package tw.team4.jspproject.javabean;

public class ReportJavaBean {

	private int Reportid;
	private String Companyid;
	private int Storeid;
	private String Storearea;
	private String Storename;
	private String Productclass;
	private String Productname;
	private String Salesdate;
	private int Salesamount;
	private int Productprice;
	private String Payment;
	private String Activeitem;

	public ReportJavaBean(int Reportid) {
		this.Reportid = Reportid;
	}

	public ReportJavaBean(String Productclass, String Productname, int Salesamount, int Productprice) {

		this.Productclass = Productclass;
		this.Productname = Productname;
		this.Salesamount = Salesamount;
		this.Productprice = Productprice;
	}

	public ReportJavaBean(String Companyid, int Storeid, String Storearea, String Storename, String Productclass,
			String Productname, String Salesdate, int Salesamount, int Productprice, String Payment,
			String Activeitem) {

		this.Companyid = Companyid;
		this.Storeid = Storeid;
		this.Storearea = Storearea;
		this.Storename = Storename;
		this.Productclass = Productclass;
		this.Productname = Productname;
		this.Salesdate = Salesdate;
		this.Salesamount = Salesamount;
		this.Productprice = Productprice;
		this.Payment = Payment;
		this.Activeitem = Activeitem;
	}

	public ReportJavaBean(int Reportid, String Companyid, int Storeid, String Storearea, String Storename,
			String Productclass, String Productname, String Salesdate, int Salesamount, int Productprice,
			String Payment, String Activeitem) {
		this.Reportid = Reportid;
		this.Companyid = Companyid;
		this.Storeid = Storeid;
		this.Storearea = Storearea;
		this.Storename = Storename;
		this.Productclass = Productclass;
		this.Productname = Productname;
		this.Salesdate = Salesdate;
		this.Salesamount = Salesamount;
		this.Productprice = Productprice;
		this.Payment = Payment;
		this.Activeitem = Activeitem;
	}

	public int getReportid() {
		return Reportid;
	}

	public void setReportid(int reportid) {
		Reportid = reportid;
	}

	public String getCompanyid() {
		return Companyid;
	}

	public void setCompanyid(String companyid) {
		Companyid = companyid;
	}

	public int getStoreid() {
		return Storeid;
	}

	public void setStoreid(int storeid) {
		Storeid = storeid;
	}

	public String getStorearea() {
		return Storearea;
	}

	public void setStorearea(String storearea) {
		Storearea = storearea;
	}

	public String getStorename() {
		return Storename;
	}

	public void setStorename(String storename) {
		Storename = storename;
	}

	public String getProductclass() {
		return Productclass;
	}

	public void setProductclass(String productclass) {
		Productclass = productclass;
	}

	public String getProductname() {
		return Productname;
	}

	public void setProductname(String productname) {
		Productname = productname;
	}

	public String getSalesdate() {
		return Salesdate;
	}

	public void setSalesdate(String salesdate) {
		Salesdate = salesdate;
	}

	public int getSalesamount() {
		return Salesamount;
	}

	public void setSalesamount(int salesamount) {
		Salesamount = salesamount;
	}

	public int getProductprice() {
		return Productprice;
	}

	public void setProductprice(int productprice) {
		Productprice = productprice;
	}

	public String getPayment() {
		return Payment;
	}

	public void setPayment(String payment) {
		Payment = payment;
	}

	public String getActiveitem() {
		return Activeitem;
	}

	public void setActiveitem(String activeitem) {
		Activeitem = activeitem;
	}

}
