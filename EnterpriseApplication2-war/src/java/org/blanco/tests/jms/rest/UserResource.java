/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blanco.tests.jms.rest;

import javax.ws.rs.*;

/**
 * REST Web Service
 *
 * @author ablanco
 */
@Path("users")
public class UserResource {

    private String id;

    /**
     * Creates a new instance of UserResource
     */
    private UserResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the UserResource
     */
    public static UserResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of UserResource class.
        return new UserResource(id);
    }

    /**
     * Retrieves representation of an instance of org.blanco.tests.jms.rest.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    /**
     * DELETE method for resource UserResource
     */
    @DELETE
    public void delete() {
    }
}
