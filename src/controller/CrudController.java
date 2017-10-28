package controller;

import java.util.List;

import model.Emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.EmpDao;

@Controller
public class CrudController {

	@Autowired
	EmpDao dao;
	
//	Show Employee Registration form
	@RequestMapping("empform")
	public ModelAndView showForm(){
		return new ModelAndView("empform","command",new Emp());
	}
	
//	Save EMployee
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp");
	}
	
//	Vew All Employee
	@RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        List<Emp> list=dao.getEmployees();  
        return new ModelAndView("viewemp","list",list);  
    }
	
//	Edit an Employee
	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id){
		Emp emp = dao.getEmpById(id);
		return new ModelAndView("empeditform","command",emp);
	}
	
//	Save Edited Employee
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("emp") Emp emp){  
	        dao.update(emp);  
	        return new ModelAndView("redirect:/viewemp");  
	    }  
//	  Delete Employee
	  @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	        dao.delete(id);  
	        return new ModelAndView("redirect:/viewemp");  
	    }  
}
