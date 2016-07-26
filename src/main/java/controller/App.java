package controller;

import freemarker.cache.ClassTemplateLoader;// spark core
import freemarker.template.Configuration;// spark template
import spark.template.freemarker.FreeMarkerEngine; // org.freemarker

import spark.ModelAndView;

import static spark.Spark.*;

public class App {

    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 9999;

    public static void main(String args[]) {
        ipAddress(IP_ADDRESS);
        port(PORT);

        final FreeMarkerEngine freemarkerEngine = new FreeMarkerEngine();
        final Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(App.class, "/"));


        get("/", (request, response) -> {
        return new ModelAndView(null, "home.ftl");
        }, freemarkerEngine);

    }
}