package singleton;
public class FactoryMethod implements Interface {
	private FactoryMethod(){
		
	}
static int count=0;



	public static FactoryMethod factoryClass() {
		count++;
		if(count>1){
			return null;
		}
		else{

		return new FactoryMethod();
	}}
}