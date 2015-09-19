This is a trivial little hello world project to verify that my jersey/tomcat/etc
installations all see eye-to-eye. This implements a hello world service
using jersey.

Building:

gradle clean war

Deployment:

Log into tomcat manager at http://127.0.0.1:8080/manager (Assuming you
installed tomcat that way.)

Under WAR file to deploy, choose build/libs/jersey_hello.war

Navigate your browser to http://127.0.0.1:8080/jersey_hello/hello

Note that I'm just using jersey annotations here to set up my paths -- no
xml editing required.

Using Jersey annotations seems to be extremely finicky. For example,
In your service class, there has to be a @Path annotation outside
the class. If it's not there, any annotations inside the class won't
be found.

It's easy to get sucked into dependency hell while troubleshooting
this. You don't need servlet-container or jersey-server-core or any
of that, at least if you're deploying to a recent Tomcat. The two main
problems that I encountered were figuring out the correct URL to access
my service at and incorrect annotations. This setup works for me,
given the default ubuntu install of tomcat7 and gradle. If it's not
for you, check your tomcat logs for exceptions.

Oh, one other thing; you need to be sure you're compiling with the same
version of java as your tomcat was; If your tomcat was compiled with java 1.7
and you're using java 1.8, you're gonna have a bad time. You SHOULD get
a "Incorret major/minor version" type exception in your tomcat logs,
if this is your problem.
