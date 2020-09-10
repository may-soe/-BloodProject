package Pack;

public class Checking {
	public static boolean isNull(String str) {
		if(str.trim().equals("")||str.trim().equals(null)) {
			return true;
		}else {
			return false;
		}
	}
	

}
