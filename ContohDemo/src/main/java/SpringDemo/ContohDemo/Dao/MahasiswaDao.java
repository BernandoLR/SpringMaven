package SpringDemo.ContohDemo.Dao;

import java.util.List;

import SpringDemo.ContohDemo.Model.Mahasiswa;

public interface MahasiswaDao 
{
	List<Mahasiswa> listMahasiswa();
	Mahasiswa saveorUpdate(Mahasiswa mahasiswa);
}
