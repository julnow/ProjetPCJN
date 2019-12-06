
public class Program {

	public static void main(String[] args) {
		Admin admin = new Admin("admin", "admin123");
		Network network1 = admin.createNetwork();
		Member john = new ClassNormal("john");
		Member pablo = new ClassZero("pablo");
		Member katia = new ClassDemie("katia");
		admin.addMember(network1, katia);
		admin.addMember(network1, pablo);
		admin.addMember(network1, john);
		
		Service netoyage = new Service("netoyage", 15);
		Service jardinage = new Service("jardinage", 15);
		Service netoyage = new Service("netoyage", 15);
		Service netoyage = new Service("netoyage", 15);

	}

}
