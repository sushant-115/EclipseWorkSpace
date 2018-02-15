package app;
import java.sql.*;


import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductsIdGenerator implements IdentifierGenerator {

	public Serializable generate(SharedSessionContractImplementor session,
			Object arg1) throws HibernateException {
		String prefix= "MAVEN";
		String suffix=null;
		String p_id= null;
		try{
			Connection cn =session.connection();
			String sql="select lpad(p_id_seq.nextval,6,0) from dual";
			Statement st = cn.createStatement();
			ResultSet rs =st.executeQuery(sql);
			if(rs.next())
				suffix =rs.getString(1);
			p_id=prefix.concat(String.valueOf(suffix));
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return p_id;
	}

}
