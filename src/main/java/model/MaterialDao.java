package model;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/*
 * Class implements DAO (data access object) method to CRUD POJO to database
 */
public class MaterialDao {
	 private Material dao;
	 
	 public Material getDao() {
		 return dao;
	 }
	 
	 public void setDao(Material dao) {
		 this.dao = dao;
	 }
	 
	 private EntityManager entityManager;
	 
	 public void init(){
		 entityManager = Persistence.createEntityManagerFactory("spring_example").createEntityManager();
	 }
	 
	 public List<Material> getDaos(){
		 entityManager.getTransaction().begin();
		 Query query = entityManager.createNamedQuery("Material.findAll");
		 //Query query = entityManager.createQuery("from Product c", Product.class);
		 List<Material> result = query.getResultList(); 
		 entityManager.getTransaction().commit();
		 return result;
	 }
	 
	public void destroy(){
		entityManager.close();
	}
}