
public class Program {
	

	public static void main(String[] args) {
	
		Admin admin = new Admin("admin", "admin123");
		Member john = new ClasseNormal("john");
		Member pablo = new ClasseZero("pablo");
		Member katia = new ClasseDemie("katia");
		Network network1 = admin.createNetwork();
		
		try { //adding members to network
			admin.addMember(network1, katia);
			admin.addMember(network1, pablo);
			admin.addMember(network1, john);
		}
		catch (Exception e1) {
			System.out.println(e1);
		}
		//example of trying to add a member without the admin
		Member nicolas = new ClasseNormal("nicolas");
		try { 
			network1.addMember(nicolas, "qwerty"); //false password
		}
		catch (Exception e2) {		
			System.out.println(e2);
		}
		try { 
			admin.addMember(network1, nicolas);
		}
		catch (Exception e3) {		
			System.out.println(e3);
		}
		
		Service netoyage = new Service("netoyage", 15);
		Service jardinage = new Service("jardinage", 10);
		Service lavage = new Service("netoyage", 10);
		Service repair = new Service("repair", 5);
		
		try {
			//on va donner le meme comptences aux Pablo et Nicolas pour mieux presenter selection aleatoire de travaillers
			pablo.addCompetence(netoyage);
			pablo.addCompetence(jardinage);
			nicolas.addCompetence(netoyage);
			nicolas.addCompetence(jardinage);
			
			katia.addCompetence(repair);
			katia.addCompetence(jardinage);
			john.addCompetence(lavage);
			john.addCompetence(netoyage);
		}
		catch (Exception e4) {
			System.out.println(e4);
		}	
		
		System.out.println(network1.usersMoney());	
		try{	
			
			Task task1 = john.commandTask(jardinage, 2, 1);
			admin.validateTask(task1, network1);
			
			System.out.println(network1.usersMoney());
		}
		catch (Exception e5) {
			System.out.println(e5);
		}
		//removing member
		try{	
			admin.removeMember(network1, nicolas);
			
			System.out.println(network1.usersMoney());
		}
		catch (Exception e6) {
			System.out.println(e6);
		}
		
	}
}		

