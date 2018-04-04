/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs.kreshna;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
@Path("/")
public class GenericResource {
    private static boolean loginCheck=false;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
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
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("mobile_Reg")
    public String mobile_Reg(final Message m){

        String res="000";
        try {          
                System.out.println("recive from mobile :  "+ m.enc_msg);    
        }catch (Exception ex) {
            System.out.println("Error found in registration");
            ex.printStackTrace();
            
        }
    
        return res;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("send_qr_detail")
    public String send_qr_detail(final Message m){

        String res="000";
        try {          
                System.out.println("QR cord :  "+ m.enc_msg);  
                loginCheck=true;
        }catch (Exception ex) {
            System.out.println("Error found in registration");
            ex.printStackTrace();
            
        }
        return res;
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("login_validate")
    public String login_validate(String m){

        String res="001";
        try {          
                System.out.println("login validate :  "+ m);  
                System.out.println("loginCheck :  "+ loginCheck);
                loginCheck=true;
                if(loginCheck){
                    System.out.println("Login success");
                    res="000";
                }else{
                    System.out.println("Login fail");
                    res="001";
                }
        }catch (Exception ex) {
            System.out.println("Error found in registration");
            ex.printStackTrace();
            
        }
        return res;
    }
}
