package com.shawnyang.poc.spring.integration.erp;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.shawnyang.poc.spring.integration.erp.endpoint.WebServiceEndpoint;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	/**
	 * To register a servlet for SOAP web service.<br>
	 * By naming this bean messageDispatcherServlet, it does not replace Spring
	 * Boot’s default DispatcherServlet bean.
	 * 
	 * @param applicationContext
	 * @return
	 */
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean
	public XsdSchema orderSchema() {
		return new SimpleXsdSchema(new ClassPathResource("order.xsd"));
	}

	/**
	 * To exposes a standard WSDL under: <br>
	 * http://<host>:<port>/ws/order.wsdl
	 * 
	 * @return
	 */
	@Bean
	public DefaultWsdl11Definition order(XsdSchema orderSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("OrderPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(WebServiceEndpoint.NAMESPACE_URI);
		wsdl11Definition.setSchema(orderSchema);
		return wsdl11Definition;
	}

}
