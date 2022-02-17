package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ElementDao;
import model.dao.MangaDao;
import model.entities.Anime;
import model.entities.Element;
import model.entities.Manga;
import model.entities.Serie;
import model.entities.User;
import model.enums.Status;

public class Program {
	
	static User user = new User(1,"Greg", "greg@gmail.co", "123");
	
	public static void main(String[] args) {
		
		//MangaDao mangaDao = new DaoFactory().createMangaDao();
		
		ElementDao elementDao = new DaoFactory().createElementDao();
		
		Element anime = new Anime("Mushoku", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.COMPLETED, user);	
		
		Element serie = new Serie("Mushoku", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.WATCHING, user);
		
		Element manga = new Manga("Mushoku Teste", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.WATCHING, user);
		
		
		
		/*Insert		
		mangaDao.insert(manga);
		*/
		
		elementDao.insert(manga);
		
		/*Find by Id
		 manga = mangaDao.findById(3);
		
		System.out.println(manga);
		
		/*Update
		manga.setName("Mushoku");
		System.out.println("Updated: " + manga);
		mangaDao.update(manga);*/
		
		/*Find by User
		 List<Manga> mangaList = mangaDao.findByUser(user);
		for (Manga manga3 : mangaList) {
			System.out.println(manga3);
		}*/
		
		/*Find by id
		manga2.setId(5)
		Manga mangas = mangaDao.findById(manga2.getId());
		System.out.println(mangas);
		*/
		
		/* Find all
		List<Manga> list = mangaDao.findAll();
		for (Manga manga3 : list) {
			System.out.println(manga3);
		}
		*/
	}

}
