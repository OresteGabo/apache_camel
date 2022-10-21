package apachecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorld {

	public static void main(String[] args) throws Exception {
		// Hello world
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new HelloWorldRoute());
		System.out.println("Hello apache");



		/**
		 * Chaque fichier dans le repertoire "source" sera recopier immediatemment dans le repertoire "destination" 
		 * Cette procédure prend place quand la boucle while est entrain de tourner avec context.start
		 */
		CamelContext context2=new DefaultCamelContext();
		context2.addRoutes(new FileCopyRoute() );
		
		while(true){
			context2.start();
		}


		/**
		 * 
		 */

	}

}
