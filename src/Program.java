
public class Program {
	

	public static void main(String[] args) {
		Admin admin = new Admin("admin", "admin123");
		Network network1 = admin.createNetwork();
		Member john = new ClasseNormal("john");
		Member pablo = new ClasseZero("pablo");
		Member katia = new ClasseDemie("katia");
		admin.addMember(network1, katia);
		admin.addMember(network1, pablo);
		admin.addMember(network1, john);
		
		Member nicolas = new ClasseNormal("nicolas");
		network1.addMember(nicolas, "pass123");
		
		Service netoyage = new Service("netoyage", 15);
		Service jardinage = new Service("jardinage", 10);
		Service lavage = new Service("netoyage", 10);
		Service repair = new Service("repair", 5);
		
		pablo.addCompetence(netoyage);
		pablo.addCompetence(jardinage);
		katia.addCompetence(repair);
		katia.addCompetence(jardinage);
		john.addCompetence(lavage);
		john.addCompetence(netoyage);
		
		System.out.println("John: " + john.getJetons() + "Katia: "+ katia.getJetons() +  "Pablo: " + pablo.getJetons());
		
		Task task1 = john.commandTask(jardinage, 2, 1);
		
		admin.validateTask(task1, network1);
		
		System.out.println("John: " + john.getJetons() + "Katia: "+ katia.getJetons() +  "Pablo: " + pablo.getJetons());
		
		

	}

}
