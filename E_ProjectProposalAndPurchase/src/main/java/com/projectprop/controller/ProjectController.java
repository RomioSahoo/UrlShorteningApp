package com.projectprop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectprop.dao.ProjectDao;
import com.projectprop.model.Project;
import com.projectprop.model.UserRegistration;

@Controller
public class ProjectController {
	@Autowired
	ProjectDao projectdao;
// will inject projectdao from XML file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/addnewproject")
	public String showform(Model m) {
		System.out.println("Inside showform method");
		m.addAttribute("command", new Project());
		return "addnewproject";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("proj") Project proj) {
		System.out.println("inside save method");
		projectdao.save(proj);
		return "redirect:/listofprojects";// will redirect to projectDetails request mapping
	}

	/* It provides list of Project in model object */

	@RequestMapping(value = "/listofprojects")
	public String edit(Model m) {
		System.out.println("Inside edit method");
		List<Project> proj = projectdao.getProject();
		m.addAttribute("proj", proj);
		return "listofprojects";
	}

	/* It provides list of Project in model object with provided skills */
	@RequestMapping(value = "/userlogged/{skills}")
	public String save(@PathVariable String skills, Model m) {
		System.out.println("Inside save method");
		System.out.println(skills);
		String[] record = skills.split(",");
		int i = 0;
		while (i < record.length) {
			List<Project> list = projectdao.getProjectAcSkill(record[i]);
			m.addAttribute("list", list);
			i++;
		}
		return "userlogged";
	}

	/*
	 * It provides list of Project in model object and will display complete list to
	 * user
	 */
	@RequestMapping(value = "/viewproject")
	public String viewproject(Model m) {
		System.out.println("Inside viewproject");
		List<Project> proj = projectdao.getProject();
		m.addAttribute("list", proj);
		return "viewproject";
	}

	/*
	 * It provides list of Project in model object and will help user to send
	 * proposal for a project
	 */
	@RequestMapping("/assigned")
	public String viewemp(Model m) {
		System.out.println("Inside viewemp");
		List<UserRegistration> list = projectdao.getUserProposal();
		System.out.println(list);
		m.addAttribute("list", list);
		return "assign";
	}

	/* It provides list of proposals in model object */
	@RequestMapping("/projectStatusAdmin")
	public String viewProjectStatus(Model m) {
		System.out.println("Inside viewProjectStatus");
		List<Project> list = projectdao.getProjectStatus();
		m.addAttribute("list", list);
		return "projectStatusAdmin";
	}

	/* It provides list of Project in model object with provided skills */
	@RequestMapping(value = "/editStatusForm/{skills}")
	public String editSaveStatus(@PathVariable String skills, Model m) {
		System.out.println("Inside editSaveStatus");
		System.out.println(skills);
		String[] record = skills.split(",");
		int i = 0;
		while (i < record.length) {
			List<Project> list = projectdao.getProjectAcSkill(record[i]);
			m.addAttribute("list", list);
			i++;
		}
		return "editStatusForm";
	}

	/* It updates model object. */
	@RequestMapping("/editStatus")
	public String editsave(Model m) {
		System.out.println("Inside editsave");
		m.addAttribute("command", new Project());
		return "editStatus";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("proj") Project proj) {
		projectdao.updateStatus(proj);
		return "updateSuccess";
	}

}
