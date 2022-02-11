package application;

import model.dao.DaoFactory;
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
		
		MangaDao mangaDao = new DaoFactory().createMangaDao();
		
		Element anime = new Anime("Mushoku", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.COMPLETED, user);	
		
		Element serie = new Serie("Mushoku", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.WATCHING, user);
		
		Manga manga = new Manga("Mushoku", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.WATCHING, user);
		
		Manga manga2 = new Manga("Mushoku 2", "mushoku2", "Site", "Descricao", 2.0, 3.0, Status.WATCHING, user);
		
		/*System.out.println(anime);
		
		System.out.println("============================================");
		
		System.out.println(serie);

		System.out.println("============================================");
		
		System.out.println(manga);

		System.out.println("============================================");*/
		
		//mangaDao.insert(manga);
		
		manga = mangaDao.findById(3);
		
		System.out.println(manga);
		
		manga.setName("Mushoku");
		System.out.println("Updated: " + manga);
		mangaDao.update(manga);
		
	}

}