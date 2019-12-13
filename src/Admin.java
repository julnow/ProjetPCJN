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
			if( t.getBeneficient().getJetons() >= t.payment()  && (t.getNbPerson() >= n.nbCompetence(t.getService())) ){
				t.getBeneficient().pay(t.payment());
				for(int i = 0; i < t.getNbPerson()-1; ++i)
					this.chooseMembers(t, n).get(i).addJetons(t.salary());
			}
		}
				
					
		public ArrayList<Member> chooseMembers(Task t, Network n) {
			ArrayList<Member> tmp = new ArrayList<Member>();
			ArrayList<Member> competent = n.haveCompetence(t.getService());
			for(int i = 0; i < t.getNbPerson()-1; ++i){
				int randomIndex = (int) Math.floor(Math.random()*competent.size()); //losuje index z competent
				Member memberTmp = competent.get(randomIndex); //wybiera wylosowanego
				tmp.add(memberTmp); //dodaje do pracujacych
				competent.remove(randomIndex); // usuwa z listy losowania
				
			}
			
			return tmp;
		}
				
				
				
	}
		
		
	
			


