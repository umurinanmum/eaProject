package mum.ea.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"mum.ea.controller", "mum.ea.serviceImpl", "mum.ea.service", "mum.ea.dao", "mum.ea.daoImpl", "mum.ea.dao.abstracts"})
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig(){
      //  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
  

}
