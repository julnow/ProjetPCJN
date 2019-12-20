
public class Program {
	

	public static void main(String[] args) {
	
		 //ajouter des  membres au reseau
		Admin admin = new Admin("admin", "admin123");
		Member john = new ClasseNormal("john");
		Member pablo = new ClasseZero("pablo");
		Member katia = new ClasseDemie("katia");
		Member julia = new ClasseNormal("julia");
		Network network1 = admin.createNetwork();
		
		try {
			admin.addMember(network1, katia);
			admin.addMember(network1, pablo);
			admin.addMember(network1, john);
			admin.addMember(network1, julia);
			
		}
		catch (Exception e1) {
			System.out.println(e1);
		}
		
		//exemple d'ajouter un membre sans administrateur - throws exception
		Member nicolas = new ClasseNormal("nicolas");
		try { 
			network1.addMember(nicolas, "qwerty"); //false password
		}
		catch (Exception e2) {		
			System.out.println(e2);
		}
		
		//on l'ajoute avec administrateur
		try { 
			admin.addMember(network1, nicolas);
		}
		catch (Exception e3) {		
			System.out.println(e3);
		}
		
		//4 exemples de service
		Service netoyage = new Service("netoyage", 15);
		Service jardinage = new Service("jardinage", 10);
		Service lavage = new Service("lavage", 10);
		Service repair = new Service("repair", 5);
		
		try {
			/*on va donner le meme comptences aux Pablo et Nicolas
			 * pour mieux presenter selection aleatoire de travaillers
			 *avec admin.validateTask()
			 */
			pablo.addCompetence(netoyage);
			pablo.addCompetence(jardinage);
			nicolas.addCompetence(netoyage);
			nicolas.addCompetence(jardinage);	
			katia.addCompetence(repair);
			katia.addCompetence(jardinage);
			john.addCompetence(lavage);
			john.addCompetence(netoyage);
			julia.addCompetence(repair);
			julia.addCompetence(netoyage);
			julia.addCompetence(lavage);
		}
		catch (Exception e4) {
			System.out.println(e4);
		}	
		
		//on affiche les utilisateurs et leur argent avant realisation de service
		System.out.println(network1.usersMoney());	
		try{	
			
			Task task1 = john.commandTask(jardinage, 2, 2); 
			/*
			 * jardinage peut etre realise par Pablo, Nicolas et Katia, 
			 * mais seulement 2 etre eux vont le faire
			 * selectiones aleatoirement dans validateTask()
			 */
			admin.validateTask(task1, network1);
			
			//on affiche les utilisateurs et leur argent apres realisation de service

			System.out.println(network1.usersMoney());
		}
		catch (Exception e5) {
			System.out.println(e5);
		}
		
		//suppresion d'utilisateur
		try{	
			admin.removeMember(network1, nicolas);

			//on affiche les utilisateurs et leur argent apres suppresion de Nicolas
			System.out.println(network1.usersMoney());
		}
		catch (Exception e6) {
			System.out.println(e6);
		}
		
	}
}		

