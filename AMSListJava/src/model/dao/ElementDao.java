package model.dao;
import java.util.List;
import model.entities.Element;

public interface ElementDao {	
	
	void insert(Element element);
	void update(Element element);
	void deleteById(Integer id);
	Element findById(Integer id);
	List<Element> findAll();
}
