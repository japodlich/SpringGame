package josh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import josh.beans.Games;
import josh.controller.BeanConfiguration;
import josh.repository.GamesRepository;

@SpringBootApplication
public class SpringGameApplication implements CommandLineRunner {
	@Autowired
	GamesRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Games g = appContext.getBean("games", Games.class);
		g.setPrice(15.99);
		repo.save(g);
		
		List<Games> allTheGames = repo.findAll();
		for (Games game: allTheGames)
		{
			System.out.println(game.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}

}
