package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.UserDao;
import org.example.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/users")
public class UserController {

    UserDao userDao = new UserDao();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);
        return String.valueOf(userDao.createUser(user));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        List<User> users = userDao.getAll();
        StringBuilder builder = new StringBuilder();
        users.forEach(user -> builder.append(user.toString()));
        return builder.toString();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById(@PathParam("id") long id) {
        //exception handling, response code
        return userDao.getById(id).toString();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@PathParam("id") long id) {
        //exception handling, response code
        return userDao.deleteUser(id).toString();
    }

}
