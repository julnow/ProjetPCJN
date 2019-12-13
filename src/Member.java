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
	
	public void pay(int sum) throws Exception{
		if(this.jetons > sum)
			this.jetons -= sum;
		else
			throw new Exception ("Not enough jetons");
	}
	
	public void addCompetence(Service s) throws Exception{
		if(s != null)
			competences.add(s);
		else
			throw new Exception ("No such service created");
	}
	
	public ArrayList<Service> getCompetences(){
		return this.competences;
	}
	public Task commandTask(Service s, int duration, int nbPerson) throws Exception{
		if (s == null)
			throw new Exception ("No such service created");
		if (duration <= 0)
			throw new Exception ("Time invalid");
		if (nbPerson <= 0)
			throw new Exception ("Number of person invalid");
		else
			return new Task(s, this, duration, nbPerson );
		
	}
}
