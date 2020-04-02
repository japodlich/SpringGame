package josh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import josh.beans.Games;
import josh.repository.GamesRepository;

@Controller
public class WebController 
{
	@Autowired
	GamesRepository repo;
	
	
	@GetMapping({ "/", "/viewAll"})
	public String viewAllGames(Model model) 
	{
		if(repo.findAll().isEmpty()) 
		{
			return addNewContact(model);
		}
		model.addAttribute("games", repo.findAll());
		return "results";
	}
	
	
	@GetMapping("/inputGame")
	public String addNewContact(Model model) 
	{
		Games c = new Games();
		model.addAttribute("newGame", c);
		return "input";
	}
	
	
	@PostMapping("/inputGame")
	public String addNewGame (@ModelAttribute Games c, Model model) 
	{
		repo.save(c);
		return viewAllGames(model);
	}
	
	
	@GetMapping("/edit/{id}")
	public String showUpdateGame(@PathVariable("id") long id, 
	Model model) 
	{
		Games c = repo.findById(id).orElse(null);
		model.addAttribute("newGame", c);
		return "input";
	}
	
	
	@PostMapping("/update/{id}")
	public
	String reviseGame(Games c, Model model) 
	{
		repo.save(c);
		return viewAllGames(model);
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) 
	{
		Games c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllGames(model);
	}
	
}
