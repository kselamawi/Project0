package com.revature.Javalin;
import io.javalin.Javalin;
public class JavalinDemo {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);
        app.get("/", ctx -> ctx.result("Hello World"));
    }
}
