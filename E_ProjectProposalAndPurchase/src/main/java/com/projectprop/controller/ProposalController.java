package com.projectprop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectprop.dao.ProposalDao;
import com.projectprop.model.PaymentDetails;
import com.projectprop.model.Project;
import com.projectprop.model.Proposal;

@Controller
public class ProposalController {
	@Autowired
	ProposalDao proposaldao;
	// will inject proposaldao from XML file

	/* It provides list of proposals in model object */
	@RequestMapping("/proposalStatus")
	public String viewProposal(Model m) {
		List<Proposal> p_list = proposaldao.getProposal();
		m.addAttribute("p_list", p_list);
		return "proposalStatus";
	}

	/* It updates model object. */
	@RequestMapping(value = "/approveProposal/{email}")
	public String editsave(@PathVariable String email) {
		proposaldao.acceptUser(email);
		return "proposalApproved";
	}

	/*
	 * It deletes record for the given id in URL and redirects to /proposalRejected
	 */
	@RequestMapping(value = "/rejectProposal/{email}")
	public String delete(@PathVariable String email) {
		proposaldao.rejectUser(email);
		return "proposalRejected";
	}

	/*
	 * It provides the list of tall the project which are completed
	 */
	@RequestMapping(value = "/viewCompleteProject")
	public String completeProject(Model m) {
		System.out.println("Inside completeProject");
		List<Project> proj = proposaldao.getCompletedProject();
		m.addAttribute("proj", proj);
		return "viewCompletedProject";
	}

	@RequestMapping(value = "/purchase/{amt}")
	public String payment(@PathVariable String amt, Model m) {
		m.addAttribute("amt", amt);
		return "payment";
	}

	@RequestMapping(value = "/paymentdone", method = RequestMethod.POST)
	public ModelAndView paymentdone(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("cardno") String cardNumber) {

		ModelAndView mv = new ModelAndView();
		// ModelAndView object is created
		PaymentDetails pay = new PaymentDetails();
		// logger.info("AdminRegistration object is created");
		pay.setName(name);
		pay.setEmail(email);
		pay.setCardNumber(cardNumber);
		int counter = proposaldao.paymentDetails(pay);
		if (counter > 0) {
			mv.addObject("msg", "Transaction successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("paymentDone");

		return mv;

	}

	/*
	 * It displays the list of vendors who purchased projects
	 */
	@RequestMapping(value = "/viewVendorPay")
	public String vendorPayment(Model m) {
		System.out.println("Vendor payment");
		List<PaymentDetails> pay = proposaldao.getVendorPayment();
		m.addAttribute("pay", pay);
		return "vendorPayment";
	}
}
