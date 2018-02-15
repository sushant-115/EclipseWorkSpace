package singleton;

import java.sql.DriverManager;

public class Caller {
	public static FactoryMethod getFactory(){
		FactoryMethod fm=FactoryMethod.factoryClass();
		return fm;
		
	}

}
