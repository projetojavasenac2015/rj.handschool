package rj.handschool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public String firstPage(Model model) {
		return "login";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String secondPage(Model model) {
		model.addAttribute("secondPageMessage", "This is the second page");
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {	
		session.invalidate();
		return "login";
	}

}
