package fr.hello;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * For the annotation thing to work, you need a class to configure the
 * servlet container. Since I'm using org.glassfish here, I can derive
 * from ResourceConfig and just use the packages call in my constructor
 * to do the job. If you were using some other implementation, you'd
 * want to derive from Application and override getClasses to return
 * a set of the classes that you want the servlet container to use.
 */

// It looks like the scanner looks for an ApplicationPath annotation
// to find the config class. If you actually give it a name, like "earl",
// the ApplicationPath will be part of your path (eg: jersey_hello/earl/hello
// or wahtever. Using / will inhibit that, so you can just use 
// jersey_hello/hello
@ApplicationPath("/")

public class HelloConfig extends ResourceConfig {

    // Just scan all the classes in the fr.hello package for
    // annotations

    public HelloConfig() { packages("fr.hello"); }

}
