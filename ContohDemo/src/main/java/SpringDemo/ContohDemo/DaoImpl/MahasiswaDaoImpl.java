package SpringDemo.ContohDemo.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringDemo.ContohDemo.Dao.MahasiswaDao;
import SpringDemo.ContohDemo.Model.Mahasiswa;

@Service
public class MahasiswaDaoImpl implements MahasiswaDao
{

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Mahasiswa> listMahasiswa() 
	{
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();
	}



	@Override
	public Mahasiswa saveorUpdate(Mahasiswa mahasiswa) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Mahasiswa saved = em.merge(mahasiswa);
		em.getTransaction().commit();
		return saved;
	}
}
