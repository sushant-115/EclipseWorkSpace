package app2;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.*;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator
{
String prefix="ORACLE";
String suffix=null;
String emp_id=null;
	public Serializable generate(SharedSessionContractImplementor session,
			Object obj) throws HibernateException {
	try {	
		Connection cn=session.connection();
	
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("select lpad(emp_id_seq.nextval,6,0) from dual");
		if(rs.next())
			suffix=rs.getString(1);
		emp_id=prefix+"- "+suffix;
	} catch(Exception e){
		e.printStackTrace();
	}
			return emp_id;
	}

}
