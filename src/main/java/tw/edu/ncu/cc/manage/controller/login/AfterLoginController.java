package tw.edu.ncu.cc.manage.controller.login;

import java.util.Date;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.login.IPersonService;
import tw.edu.ncu.cc.manage.util.PersonInfo;
import tw.edu.ncu.cc.manage.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@RequestMapping("/logined")
public class AfterLoginController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private IPersonService<Person> service;

	public String logined(@RequestParam(value = "tmpId") String tmpId, HttpSession session, HttpServletRequest request) {
		Person person = updatePersonInfo(tmpId, request.getRemoteAddr());
		session.setAttribute(PersonInfo.PERSON_INFO, person);
		return "logined";
	}


	private Person updatePersonInfo(String personId, String ip) {
		Optional<Person> person = this.service.findPersonByAccount(personId);
		
		if (person.isPresent()) {
			this.service.refreshActivateInfo(person.get(), ip);
		} else {
			this.service.createUserOnRemoteServer(personId);
			person = this.service.getNewLoginPerson(request, personId);
			this.service.create(person);
		}
		return person;
	}

	private void refreshActivateInfo(Person person) {
		person.setDateLastActived(new Date());
		person.setIpLastActived(request.getRemoteAddr());
	}
}