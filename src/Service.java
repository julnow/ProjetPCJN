
public class Service {
	
	private String name;  //pas d'heritage
	private int hourPrice;
	
	public Service(String name, int hourPrice){
		this.name = name;
		this.hourPrice = hourPrice;
		
	}
	
	public int hourPrice(){
		return this.hourPrice;
	}
	
	public String name(){
		return this.name;
		
	}

}
