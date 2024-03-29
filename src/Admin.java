import java.util.ArrayList;

public class Admin extends ClasseNormal {
	
	private String password;

		public Admin(String name, String password ){
			super(name);
			this.password = password;
		}
		
		public Network createNetwork() {
			Network network = new Network(password);
			return network;
		}

		public void addMember(Network n, Member m ) {
			try {
				n.addMember(m, password);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void removeMember( Network n, Member m) {
			try {
				n.removeMember(m.getName(), password);
			}
			catch (Exception e) {
				System.out.println(e);
			}	
		}
		
		public void validateTask(Task t, Network n) {
			if( t.getBeneficient().getJetons() >= t.payment()  && (t.getNbPerson() <= n.nbCompetence(t.getService())) ){
				try{
					t.getBeneficient().pay(t.payment());
				}
				catch(Exception e) {
					System.out.println(e);
				}
				ArrayList<Member> workers = this.chooseMembers(t, n);
				for(int i = 0; i < t.getNbPerson(); ++i)
					workers.get(i).addJetons(t.salary());
					
					
			}
		}
				
					
		private ArrayList<Member> chooseMembers(Task t, Network n) {
			ArrayList<Member> tmp = new ArrayList<Member>();
			ArrayList<Member> competent = n.haveCompetence(t.getService());
			for(int i = 0; i < t.getNbPerson(); ++i){
				int randomIndex = (int) Math.floor(Math.random()*competent.size()); //aleatoire index de competent list
				Member memberTmp = competent.get(randomIndex); //choisir member avec randomIndex index
				tmp.add(memberTmp); //ajouter a list de travaillers
				competent.remove(randomIndex); // suppresion de list pour ne pas doubler les utilisateurs
				
			}
			
			return tmp;
		}
				
				
				
	}
		
		
	
			


