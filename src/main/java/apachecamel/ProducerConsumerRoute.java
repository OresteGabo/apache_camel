package apachecamel;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;

public class ProducerConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start").to("seda:end");
    }
}
