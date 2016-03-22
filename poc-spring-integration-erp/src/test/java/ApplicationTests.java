
/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.shawnyang.poc.spring.integration.erp.BootApplication;
import com.shawnyang.poc.spring.integration.erp.order.Order;
import com.shawnyang.poc.spring.integration.erp.order.OrderItem;
import com.shawnyang.poc.spring.integration.erp.order.PostOrderRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
@WebIntegrationTest(randomPort = true)
public class ApplicationTests {

	private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

	@Value("${local.server.port}")
	private int port = 0;

	@Before
	public void init() throws Exception {
		marshaller.setPackagesToScan(ClassUtils.getPackageName(PostOrderRequest.class));
		marshaller.afterPropertiesSet();
	}

	@Test
	public void testSendAndReceive() {
		OrderItem item1 = new OrderItem();
		item1.setNumber(1);
		OrderItem item2 = new OrderItem();
		item2.setNumber(2);
		Order order = new Order();
		order.setNumber(UUID.randomUUID().toString());
		order.setCustomer("Shawn");
		order.setComment("Hi");
		order.getOrderItem().add(item1);
		order.getOrderItem().add(item2);
		PostOrderRequest request = new PostOrderRequest();
		request.setOrder(order);

		Object response = new WebServiceTemplate(marshaller).marshalSendAndReceive("http://localhost:" + port + "/ws",
				request);

		assertNotNull(response);
	}

}
