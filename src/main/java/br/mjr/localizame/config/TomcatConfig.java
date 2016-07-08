package br.mjr.localizame.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = { "br.com.sertec.robotposition.*" })
@PropertySource("file:./app.properties")
public class TomcatConfig implements EmbeddedServletContainerCustomizer {

    @Value("${robo.servidor.porta}")
    private int servidorPorta;

    @Value("${robo.servidor.timeout}")
    private int servidorTimeout;

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        if(container instanceof TomcatEmbeddedServletContainerFactory){
            TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory)container;
            factory.setPort(servidorPorta);
            factory.setSessionTimeout(servidorTimeout, TimeUnit.MINUTES);
            factory.addConnectorCustomizers(costumizer());
        }
    }

    private TomcatConnectorCustomizer costumizer(){
        return new TomcatConnectorCustomizer(){
            @Override
            public void customize(Connector connector) {
                AbstractHttp11Protocol httpProtocol = (AbstractHttp11Protocol) connector.getProtocolHandler();
                httpProtocol.setCompression("on");
                httpProtocol.setCompressionMinSize(32);
                String mimeTypes = httpProtocol.getCompressableMimeTypes();
                String mimeTypesWithJson = mimeTypes + "," + MediaType.APPLICATION_JSON_VALUE;
                httpProtocol.setCompressableMimeTypes(mimeTypesWithJson);
            }
        };
    }
}
