package dao;

import java.util.List;

import myPackage.Citoyen;

public interface ICitoyenDAO {
	public void add(Citoyen c);
	public List<Citoyen> getAllCitoyen();
}
