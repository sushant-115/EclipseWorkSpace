package vowelremover;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class Functional {
	static boolean m1(){
		return true;
	}
	public static boolean inta(Character inta){
		if(inta.equals('c'))
			return false;
		return true;
	}
public static void main(String[] args) {
	String str="abcdefcdrcgr";
	IntPredicate inp=inta->m1();
	
	str.chars().filter(b->inta((char)b)).forEachOrdered(inta->System.out.print((char)inta));
}
}
