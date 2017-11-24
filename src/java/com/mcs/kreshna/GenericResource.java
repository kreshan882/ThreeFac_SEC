/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs.kreshna;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kreshan88
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("translate_clearPIN")
    public String translate_clearPIN(final Message m){
   
    String ePINB="ok";
 
        try {          
                System.out.println("Translated result : "+m.CL_PIN+ m.PAN);
                
                System.out.println("Translated result : "+m.CL_PIN+ m.PAN);
              
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error found in PINTranslate1");
        }
    
        return ePINB;
    }
    /**
     * Retrieves representation of an instance of com.mcs.kreshna.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
