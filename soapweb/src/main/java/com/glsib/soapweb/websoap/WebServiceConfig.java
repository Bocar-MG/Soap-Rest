package com.glsib.soapweb.websoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;

    @EnableWs
    @Configuration
    public class WebServiceConfig extends WsConfigurerAdapter {
    @Autowired
    private ApplicationContext applicationContext;
        @Bean
        public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
            MessageDispatcherServlet servlet = new MessageDispatcherServlet();
            servlet.setApplicationContext(applicationContext);
            servlet.setTransformWsdlLocations(true);
            return new ServletRegistrationBean(servlet, "/ws/*");
        }

        //http://localhost:8080/ws/services.wsdl --bean name is set to 'services'
        @Bean(name = "services")
        public Wsdl11Definition defaultWsdl11Definition() {
            SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
            wsdl11Definition.setWsdl(new ClassPathResource("calculator.wsdl")); //your wsdl location
            return wsdl11Definition;
        }
    }

