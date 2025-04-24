package controller;

import db.Database;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.WebServer;
import webserver.request.HttpRequest;
import webserver.response.HttpResponse;

public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(WebServer.class);
    public static void handleCreateUser(HttpRequest request, HttpResponse response){
        User user = new User(
                request.getQueryParams().get("userId"),
                request.getQueryParams().get("password"),
                request.getQueryParams().get("name"),
                request.getQueryParams().get("email")
        );
        Database.addUser(user);
        logger.info(Database.findAll().toString());
        response.sendRedirect("/index.html");
    }
}
