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

	/**
	 * dès que le message à envoyer atteigne le endpoint "direct:start", il sera directement envoyé à "seda:end"
	 */
	static void producerConsumer(String message) throws Exception{
		

		CamelContext context3=new DefaultCamelContext();
		context3.addRoutes(new ProducerConsumerRoute());
		context3.start();

		//Source du message
		ProducerTemplate producerTemplate= context3.createProducerTemplate();
		producerTemplate.sendBody("direct:start", message);


		//Destination du message
		ConsumerTemplate consumerTemplate=context3.createConsumerTemplate();
		String messageRecu=consumerTemplate.receiveBody("seda:end",String.class);
		

		System.out.println(String.format("Le message envoyé est %s",messageRecu));
	}
	

}
