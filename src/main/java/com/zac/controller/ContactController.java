package com.zac.controller;

import com.zac.dao.ContactDAO;
import com.zac.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Contact Controller
 * Created by zac on 5/3/16.
 */
@Controller
public class ContactController {

    @Autowired
    ContactDAO contactDAO;

    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView modelAndView) {
        List<Contact> contactList = contactDAO.list();
        modelAndView.addObject("contactList", contactList);
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @RequestMapping(value = "newContact",method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView modelAndView) {
        Contact contact = new Contact();
        modelAndView.addObject("contact", contact);
        modelAndView.setViewName("contactForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute("contact") Contact contact) {
        System.out.println("save contact: " + contact.toString());
        contactDAO.saveOrUpdate(contact);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactDAO.delete(contactId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(contactId);
        ModelAndView modelAndView = new ModelAndView("contactForm");
        modelAndView.addObject("contact", contact);

        return modelAndView;
    }

}
