import java.util.ArrayList;

public class Network {
	
	private String password;
	private ArrayList<Member> members;
	
	public Network(String password){
		this.members = new ArrayList<Member>();
		this.password = password;
		
	}
	


	public void addMember (Member m, String pass)throws Exception {
		if (pass != password)
			throw new Exception("incorrect password");
		else
			this.members.add(m);
	}
	

	public void removeMember(String name, String pass) throws Exception {
		if (pass != password) 
			throw new Exception("incorrect password");
		else{
			boolean found = false;
			while(!found) {
				for(int i = 0; i < members.size()-1; ++i) {
					if (members.get(i).getName() == name) {
						members.remove(i);
						found = true;	
					}
				}

			}
		}
	}
	
	public int nbMembers() {
		return this.members.size();
	}
	
	public int nbCompetence (Service s) { // NIE DZIAŁA zwraca 0 zawsze chyba
		int count = 0;
		for(int i = 0; i<this.members.size() -1; ++i) {
			for(int j = 0; j < this.members.get(i).getCompetences().size()-1; ++j) {
				if(s == this.members.get(i).getCompetences().get(j))
					++count;		
			}	
		}
		return count;
		
	}
	
	public ArrayList<Member> haveCompetence (Service s){
		ArrayList<Member> can = new ArrayList<Member>();
		for(int i = 0; i<this.members.size()-1; ++i) {
			for(int j = 0; j < this.members.get(i).getCompetences().size()-1; ++i) {
				if(s == this.members.get(i).getCompetences().get(j))
					can.add(this.members.get(i));
			}
		}
		return can;
	}
}
