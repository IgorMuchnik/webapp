package org.example.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.example.model.Advert;
import org.example.service.impl.AdvertServiceImpl;

import javax.ws.rs.core.MediaType;


@Path("/adverts")
public class AdvertController {
    private AdvertServiceImpl advertService = new AdvertServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAdvert(Advert advert) {
        try {
            advertService.createAdvert(advert);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.toString())
                    .build();
        }
        return Response.status(Response.Status.OK)
                .build();
    }

    @GET
    @Path("/{advertId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvertById(@PathParam("advertId") long advertId) {
        try {
            return Response.status(Response.Status.OK)
                    .entity(advertService.getAdvertById(advertId))
                    .build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.toString())
                    .build();
        }
    }

    @DELETE
    @Path("/{advertId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAdvert(@PathParam("advertId") long advertId) {
        try {
            return Response.status(Response.Status.OK)
                    .entity(advertService.deleteAdvert(advertId))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.toString())
                    .build();
        }
    }

    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvertsByUser(@PathParam("id") long userId) {
        try {
            return Response.status(Response.Status.OK)
                    .entity(advertService.getAdvertsByUser(userId))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.toString())
                    .build();
        }
    }


}
