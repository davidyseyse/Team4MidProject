package tw.team4.jspproject.javabean;

public class MidProductJavaBean {
	private int Productid;
	private String ProductName;
	private int ProductStuck;
	private int ProductPrice;
	private String ProductType;
	private int StoreId;
	private int Discount;
	public MidProductJavaBean() {
		
	}
	public MidProductJavaBean(int Productid,String ProductName,int ProductStuck,int ProductPrice,String ProductType,int StoreId,int Discount) {
		this.Productid=Productid;
		this.ProductStuck=ProductStuck;
		this.ProductName=ProductName;
		this.ProductPrice=ProductPrice;
		this.ProductType=ProductType;
		this.StoreId=StoreId;
		this.Discount=Discount;
		
	}
	public MidProductJavaBean(String ProductName,int ProductStuck,int ProductPrice,String ProductType,int StoreId,int Discount) {
		this.ProductStuck=ProductStuck;
		this.ProductName=ProductName;
		this.ProductPrice=ProductPrice;
		this.ProductType=ProductType;
		this.StoreId=StoreId;
		this.Discount=Discount;
		
	}
		// TODO Auto-generated method stub
	public int getProductid() {
		return Productid;
	}
	public void setProductid(int productid) {
		Productid = productid;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductStuck() {
		return ProductStuck;
	}
	public void setProductStuck(int productStuck) {
		ProductStuck = productStuck;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

	}


