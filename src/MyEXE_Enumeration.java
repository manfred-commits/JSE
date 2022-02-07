
public class MyEXE_Enumeration {
	
	public static String MY_SEPARATOR="______________________";
	public static void main(String[] args) {
		MyDays singleDay=MyDays.FRIDAY;
		System.out.println(singleDay);
		
		System.out.println(MY_SEPARATOR);
		for(MyDays day:MyDays.values()) {
			System.out.println(day);
		}
		System.out.println(MY_SEPARATOR);
		for(MyHolydays holyday:MyHolydays.values()) {
			System.out.println(holyday+" day:"+holyday.getMyDay()+" month: "+holyday.getMonth());
		}
	}

}
enum MyDays {
	MONDAY,
	TUESDAY,
	WENSDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY
}
enum MyHolydays{
	CHRISTMAS(25, "December"),
	NEWYEAR(1, "January"),
	EPIPHANY(6, "February");

	private final int myDay;
	private final String myMonth;
	
	private MyHolydays(int myDay, String myMonth) {
		this.myDay=myDay;
		this.myMonth=myMonth;
	}
	/*Getter*/
	public int getMyDay() {
		return myDay;
	}
	public String getMonth() {
		return myMonth;
	}
	
}