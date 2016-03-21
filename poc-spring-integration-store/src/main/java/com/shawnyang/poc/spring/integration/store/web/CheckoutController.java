package com.shawnyang.poc.spring.integration.store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shawnyang.poc.spring.integration.store.i.Order;
import com.shawnyang.poc.spring.integration.store.i.OrderForm;
import com.shawnyang.poc.spring.integration.store.usecase.Checkout;

@Controller
@RequestMapping(path = "/checkout")
public class CheckoutController {

	@Autowired
	private Checkout checkout;

	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		model.addAttribute("orderForm", new OrderForm());
		return "checkout/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute OrderForm orderForm, Model model) {
		Order order = checkout.checkout(orderForm);
		model.addAttribute("order", order);
		return "checkout/result";
	}

}
