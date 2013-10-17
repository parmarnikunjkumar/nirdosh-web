package nirdosh.web.util;


public class CustomerUtil {

	
	public static String parseName(String str){
		String name = str.substring(0,str.indexOf("+"));
		return name;
	}
	
	public static Integer parseAge(String str){
		String age = str.substring(str.indexOf("+")+1);
		return Integer.parseInt(age);	
	}
}
