package apachecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorld {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new HelloWorldRoute());
		System.out.println("Hello apache");

	}

}
