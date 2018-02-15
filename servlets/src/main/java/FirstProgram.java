import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstservlet.restful.User;

@Path(value = "firstprogram")
public class FirstProgram {
	User user=new User();
	ObjectMapper mapper=new ObjectMapper();
	@GET
	@Path(value = "json")
	public String JavaToJson(){
		user.setMobile("999999");
		user.setName("sushant");
		String status="User not found";
		try {
			status=mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
