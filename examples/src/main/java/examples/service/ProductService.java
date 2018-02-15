package examples.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import examples.domain.Products;

@Path("products")
public class ProductService {
	@GET
	@Path("/getproductinxml")
	@Produces(MediaType.APPLICATION_XML)
public Products searchProduct1(@QueryParam("pid")Integer pid){
		System.out.println("Entered into searchProduct1 xml");
		Products p=null;
		if(pid!=null&&pid.equals(101)){
			p=new Products();
			p.setPid(pid);
			p.setpName("KeyBoard");
			p.setPrice(500.0);
		}
		return p;
	
}  
	@GET
	@Path("/getProductsInXml")
	@Produces(MediaType.APPLICATION_JSON)
	public Products seachProducts(@QueryParam("pid") Integer pid){
		System.out.println("Entered in SearchProducts2 Json");
		Products p=null;
		if(pid!=null&&pid==102){
			p=new Products();
			p.setPid(102);
			p.setpName("Mouse");
			p.setPrice(400.0);
		}
		return p;
		
	}
	public String getProductName(@QueryParam("pid") Integer pid){
		if(pid!=null&&pid==101){
			return "keyBoard";
		}
		return "Product Not Found";
	}
}
