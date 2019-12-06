import java.util.ArrayList;

public class Network {
	
	private String password;
	private ArrayList<Member> members;
	
	Network(String password){
		this.members = new ArrayList<Member>();
		this.password = password;
		
	}
	
	public void addMember(Member m, String pass) {
		if (pass == password)
			this.members.add(m);
		/// exceptions!!
	}
	
	public void removeMember(String name, String pass) {
		if (pass == password) {
			for(int i = 0; i < members.size(); ++i) {
				if (members.get(i).getName() == name) {
					members.remove(i);
					break;
				}		
			}
		}
	}
	
	public int nbMembers() {
		return this.members.size();
	}
	
	public int nbCompetence (Service s) {
		int count = 0;
		for(int i = 0; i<this.members.size(); ++i) {
			for(int j = 0; j < this.members.get(i).getCompetences().size(); ++i) {
				if(s == this.members.get(i).getCompetences().get(j))
					++count;		
			}	
		}
		return count;
		
	}
	
	public ArrayList<Member> haveCompetence (Service s){
		ArrayList<Member> can = new ArrayList<Member>();
		for(int i = 0; i<this.members.size(); ++i) {
			for(int j = 0; j < this.members.get(i).getCompetences().size(); ++i) {
				if(s == this.members.get(i).getCompetences().get(j))
					can.add(this.members.get(i));
			}
		}
		return can;
	}
}
