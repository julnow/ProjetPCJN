import java.util.ArrayList;

public abstract class Member {
	
	protected double classFactor;
	static final int jetonsAtStart = 100; // a priori
	private String name;
	private int jetons;
	private ArrayList<Service> competences;
	
	public Member(String name) {
		this.name = name;
		this.jetons = Member.jetonsAtStart;
		this.competences = new ArrayList<Service>();
		
	}
	
	abstract double getclassFactor();

	public String getName() {
		return name;
	}

	public int getJetons() {
		return jetons;
	}
	
	public void addJetons(int sum){
		this.jetons += sum;
	}
	
	public void pay(int sum){
		this.jetons -= sum;
	}
	
	public void addCompetence(Service s){
		competences.add(s);
	}
	
	public ArrayList<Service> getCompetences(){
		return this.competences;
	}
}
