package apachecamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Chaque fichier dans le repertoire "source" sera recopier immediatemment dans le repertoire "destination" 
 * Cette procédure prend place quand la boucle while est entrain de tourner avec context.start
 */
public class FileCopyRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:source?noop=true").to("file:destination");		
    }
}
