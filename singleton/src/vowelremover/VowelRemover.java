package vowelremover;

import java.util.Scanner;

public class VowelRemover {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	String str=s.nextLine();
	str.chars().filter(c ->!isVowel((char)c)).forEach(c ->System.out.print((char)c));
	}
private static boolean isVowel(Character c){
	switch(c.toLowerCase(c)){
	case 'a':
	case 'e':
	case 'i':
	case 'o':
	case 'u':
	return true;
	}
	return false;
}
}
