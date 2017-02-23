package controller;

import java.util.*;

import model.Material;
import model.MaterialDao;
import model.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {
	@RequestMapping("/test")
	public String hello(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }
	
	@RequestMapping("/person")
	public Person person(@RequestParam(value="name", defaultValue="World") String name) {
        Person person = new Person();
        person.setId(1);
        person.setName("Magnus");
        return person;
    }
	
	@RequestMapping("/persons")
	 public List<Person> persons(@RequestParam(value="name", defaultValue="World") String name) {
		List<Person> persons = new ArrayList<Person>();
		
		Person person = new Person();
        person.setId(2);
        person.setName("Börje");
        
        Person person2 = new Person();
        person2.setId(3);
        person2.setName("Göran");
        
        persons.add(person);
        persons.add(person2);
		
		return persons;		
	}
	
	@RequestMapping("/materials")
		public List<Material> materials(@RequestParam(value="name", defaultValue="World") String name) {
		MaterialDao dao = new MaterialDao();
		dao.init();
		return dao.getDaos();
	}
	@RequestMapping("/materialsbyname")
		public List<Material> materialsbyname(@RequestParam(value="name", defaultValue="Polk") String name) {
		MaterialDao dao = new MaterialDao();
		dao.init();
		List<Material> material = dao.getDaos();
		//otetaan listalta pois
		for (Iterator<Material> iter = material.listIterator(); iter.hasNext(); ) {
		    Material a = iter.next();
		    if (!a.getName().substring(0,name.length()).equals(name)) {
		        iter.remove();
		    }
		}
		return material;
	}

	
	/*@RequestMapping("/personbyid")
	 public Person personById(@RequestParam(value="id", defaultValue="1") int id) {
	
	}*/
}
