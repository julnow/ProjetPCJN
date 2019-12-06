
public class Task {
	
	private Service service;
	private Member beneficient;
	private int duration;
	private int nbPerson;
	
	public Task(Service service, Member beneficient, int duration, int nbPerson){
		this.service = service;
		this.beneficient = beneficient;
		this.duration = duration;
		this.nbPerson = nbPerson;
	}
	
	public int price(){
		return this.nbPerson * this.duration * this.service.hourPrice();
	}
	
	public int payment(){
		double tmp = this.price() * this.beneficient.getclassFactor() ;
		return (int) Math.floor(tmp);
	}
	
	public int getNbPerson(){
		return nbPerson;
	}
	
	public Service getService() {
		return service;
	}
	
	public Member getBeneficient() {
		return beneficient;
	}
	
	public int salary() {
		return this.duration * this.service.hourPrice();
	}
}
