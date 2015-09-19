package fr.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import java.lang.String;
import javax.ws.rs.core.MediaType;

/**
 * The actual service class. It doesn't need to extend anything or anything.
 * Just annotate it with a @Path somewhere, and that should do it.
 */

// There apparently HAS to be a @Path here, outside the class.
// Apparently using / inhibits it from crapping up your path
// if you want to use paths in your methods in this class

@Path("/")
public class HelloService {

    // This will get published to jersey_hello/hello. That's because
    // the war file name the first part of the URL and then any paths
    // get appended to it. This function will respond to a HTTP GET
    // and will produce HTML. It doesn't matter what the function
    // name is.

    // If you comment out this @Path, you could access your service
    // at the top level -- http://127.0.0.1:8080/jersey_hello. That
    // would actually be somewhat useful in this example, so comment
    // it out and play with it, if you want to.

    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello()
    {
	final String hello = "<h1>Hello, World!</h1>";
	return hello;
    }

}
