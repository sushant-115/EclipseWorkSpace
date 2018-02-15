package app1;

import java.io.Serializable;
import java.sql.*;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator {
	private String prefix="BANK5071";
	private String suffix=null;
	private String c_id=null;

	public Serializable generate(SharedSessionContractImplementor session,
			Object obj) throws HibernateException {
		try{
			Connection cn=session.connection();
		Statement st =cn.createStatement();
		ResultSet rs=st.executeQuery("select lpad(c_id_seq.nextval,7,0)from dual");
		if(rs.next())
			suffix=rs.getString(1);
		c_id=(prefix+"-"+suffix);
		} 
		catch(Exception e){
		e.printStackTrace();
		}
		return c_id;
	}


}
