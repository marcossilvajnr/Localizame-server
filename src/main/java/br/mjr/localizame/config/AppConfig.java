package br.mjr.localizame.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "br.com.sertec.robotposition.*" })
@PropertySource("file:./app.properties")
public class AppConfig {

}
