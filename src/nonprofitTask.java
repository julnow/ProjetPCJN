
public class nonprofitTask extends Task {
	
	public nonprofitTask(Service service, Member beneficient, int duration, int nbPerson){
		super(service, beneficient, duration, nbPerson);
	}
	
	public int price(){
		return 0;
	}

}
