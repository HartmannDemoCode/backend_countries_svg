package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.RenameMe;
import utils.EMF_Creator;
import facades.Facade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("country")
public class CountryRessource {

 Facade f = Facade.getFacadeExample(null);

    @Path("code/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount(@PathParam("id") String id) {
        return f.getCountryData(id);
    }

    
}
