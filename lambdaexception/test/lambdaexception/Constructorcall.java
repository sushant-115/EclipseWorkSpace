package lambdaexception;
class Abcd{
	public Abcd(){
		this("a","b","c");
		}
	public Abcd(String...str){
		for(String s:str){
			System.out.println(s);
		}
	}
}

public class Constructorcall {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("lambdaexception.Abcd").newInstance();
	}

}
