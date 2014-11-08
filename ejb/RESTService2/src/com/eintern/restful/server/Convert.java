package com.eintern.restful.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ConvertService")
public class Convert {
	
	@GET
	@Path("/YardsToMeters/{i}")
	@Produces(MediaType.TEXT_XML)
	public String convertYardsToMeters(@PathParam("i") int i){
		double meters = 0;
		meters = (double)i *.9144;
		
		String str = "\n<YardsToMetersService>\n" + "	<Yards>\n	" + i + "\n	</Yards>\n" + "	<Meters>\n	" + meters + "\n	</Meters>\n" +"</YardsToMetersService>"; 
		return str;
		
	}

}
