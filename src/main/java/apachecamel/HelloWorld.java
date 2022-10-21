package apachecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorld {

	public static void main(String[] args) throws Exception {
		

	}

	static void helloWorld()throws Exception{
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new HelloWorldRoute());
		System.out.println("Hello apache");

	}

	/**
	 * Chaque fichier dans le repertoire "source" sera recopier immediatemment dans le repertoire "destination" 
	 * Cette procédure prend place quand la boucle while est entrain de tourner avec context.start
	 */
	static void copierFichier()throws Exception{
		
		CamelContext context2=new DefaultCamelContext();
		context2.addRoutes(new FileCopyRoute() );
		while(true){
			context2.start();
		}
	}

	

}
