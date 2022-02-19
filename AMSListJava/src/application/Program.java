package application;

import java.util.List;

import model.dao.AnimeDao;
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
		
		MangaDao mangaDao = new DaoFactory().createMangaDao();
		
		AnimeDao animeDao = new DaoFactory().createAnimeDao();
		
		ElementDao elementDao = new DaoFactory().createElementDao();
		
		Element anime = new Anime(null, "Mushoku", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.COMPLETED, user);	
		
		Element serie = new Serie(null, "Mushoku", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.WATCHING, user);
		
		Element manga = new Manga(null, "Mushoku Teste 2", "mushoku", "Site", "Descricao", 2.0, 3.0, Status.WATCHING, user);
		
		
		
		
		
		
				
		/*Insert		
			mangaDao.insert((Manga) manga);
			animeDao.insert((Anime) anime);
		
		*/
		
		/*Find by Id
			manga = mangaDao.findById(3);
			anime = animeDao.findById(1);
		
		System.out.println(manga);
		
		/*Update
			manga.setName("Mushoku");
			mangaDao.update(manga);
		
			anime.setName("Mushoku teste");
			animeDao.update((Anime)anime);
		*/
		
		/*Find by User
			List<Manga> mangaList = mangaDao.findByUser(user);
			for (Manga manga3 : mangaList) {
				System.out.println(manga3);
			}
			
			List<Anime> listUser = animeDao.findByUser(user);
			for (Anime anime2 : listUser) {
				System.out.println(anime2);
			}
		
		*/
		
		/*Find by id
			manga2.setId(5)
			Manga mangas = mangaDao.findById(manga2.getId());
			System.out.println(mangas);
			
			List<Anime> list = animeDao.findAll();
			for (Anime anime2 : list) {
				System.out.println(anime2);
			}
		
		*/
		
		/*Find all
			List<Manga> list = mangaDao.findAll();
			for (Manga manga3 : list) {
				System.out.println(manga3);
			}
			
			List<Anime> listAnime = animeDao.findAll();
			for(Anime anime2 : list) {
				System.out.println(anime2);
			}
		*/
		
		
	}

}
