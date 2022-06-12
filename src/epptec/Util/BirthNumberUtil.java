package epptec.Util;

public class BirthNumberUtil {
	public static boolean isRightFormat(String birthNumber){
		return birthNumber.matches("[0-9]{2}[0,1,5,6][0-9][0-9]{2}/?[0-9]{4}");
	}
	public static String normalizeBirthNumber(String birthNumber){
		return birthNumber.replaceAll("/","");
	}
}
