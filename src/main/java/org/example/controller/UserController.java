package org.example.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;

@Path("/users")
public class UserController {

  private UserService userService = new UserServiceImpl();

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(User user) {
    try {
      userService.createUser(user);
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR)
                     .entity(e.toString())
                     .build();
    }
    return Response.status(Status.OK)
                   .build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    try {
      return Response.status(Status.OK)
                     .entity(userService.getAll())
                     .build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR)
                     .entity(e.toString())
                     .build();
    }
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserById(@PathParam("id") long userId) {
    try {
      return Response.status(Status.OK)
                     .entity(userService.getById(userId))
                     .build();
    } catch(Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR)
                     .entity(e.toString())
                     .build();
    }
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteUser(@PathParam("id") long userId) {
    try {
      return Response.status(Status.OK)
                     .entity(userService.deleteUser(userId))
                     .build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR)
                     .entity(e.toString())
                     .build();
    }
  }

  @GET
  @Path("/{id}/adverts")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAdvertsByUser(@PathParam("id") long userId) {
    try {
      return Response.status(Status.OK)
                     .entity(userService.getAdvertsByUser(userId))
                     .build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR)
                     .entity(e.toString())
                     .build();
    }
  }

}
