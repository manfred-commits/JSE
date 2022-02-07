
public class MyEnumeration {

	public static void main(String[] args) {
		for(MyOS myOS:MyOS.values()) {
			System.out.println(myOS+": "+myOS.getMyOS());
		}
	}

}
/*Definizione costanti che non cambiano più*/
enum MyCardinalPoints{
	/*Identificatori costanti (Di default costanti)*/
	NORTH,
	EAST,
	SOUTH,
	WEST
}

enum MyOS{
	LINUX("Ubuntu","20"),
	MAC("Monterey","12"),
	WINDOWS("10","20H2"),
	ANDROID("Lollipop","13");

	private final String myOSName;
	private final String myOSVersion;
	
	private MyOS(String myOsName, String myOSVersion) {
		this.myOSName=myOsName;
		this.myOSVersion=myOSVersion;
	}
	
	/*Geter*/
	public String getMyOS() {
		return myOSName+" "+myOSVersion;
	}
	public String getMyOSName() {
		return myOSName;
	}
	public String getMyOSVersion() {
		return myOSVersion;
	}
	
}