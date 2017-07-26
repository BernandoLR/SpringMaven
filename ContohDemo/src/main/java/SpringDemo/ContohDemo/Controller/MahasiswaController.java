package SpringDemo.ContohDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringDemo.ContohDemo.Dao.MahasiswaDao;
import SpringDemo.ContohDemo.Model.Mahasiswa;

@Controller
public class MahasiswaController 
{

	private MahasiswaDao mhsDao;
	
	@Autowired
	public void setMhsDao(MahasiswaDao mhsDao) {
		this.mhsDao = mhsDao;
	}

	@RequestMapping("/index")
	public String index(Model model)
	{
		model.addAttribute("HomeMahasiswa",mhsDao.listMahasiswa());
		return "HomeMahasiswa";
	}
	
	@RequestMapping(value = "/index/create", method = RequestMethod.GET)
	public String a(Model model)
	{
		model.addAttribute("HomeMahasiswa",new Mahasiswa());
		return "formMahasiswa";
	}
	
	@RequestMapping(value="/index/create", method = RequestMethod.POST)
	public String SaveDataMahasiswa(Model model,Mahasiswa mahasiswa)
	{
		model.addAttribute("HomeMahasiswa", mhsDao.saveorUpdate(mahasiswa));
		return "redirect:/index";
	}
	
}
