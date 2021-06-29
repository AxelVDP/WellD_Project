package it.progetto;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ProjectController {	
	@Path("/space")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Plane postPlane() {
		return Space.getInstance();
	}
	
	@Path("/space")
	@DELETE
	public void deletePlane() {
		Space.getInstance().deleteAll();
	}
	
	@Path("/lines/{c}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Plane> getLineSegments(@PathParam("c") int c) {
		//potrei voler inserire controlli sul parametro "c"
		return Space.getInstance().segmentsOfLine(c);
	}
	
	@Path("/point")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertPoint(Point p) {
		//potrei voler inserire controlli sugli input
		Space.getInstance().addPoint(p);
	}
}
