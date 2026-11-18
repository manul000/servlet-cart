package com.study.shop;

import org.apache.catalina.startup.Tomcat;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat t = new Tomcat();
        t.setBaseDir("target/tomcat");
        t.setPort(Integer.parseInt(System.getProperty("port", "8080")));
        t.getConnector();
        var ctx = t.addWebapp("", Path.of("src/main/webapp").toAbsolutePath().toString());
        ctx.setParentClassLoader(Main.class.getClassLoader());
        t.start();
        System.out.println("http://localhost:" + t.getConnector().getLocalPort() + "/shop");
        t.getServer().await();
    }
}
