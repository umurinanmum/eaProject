package mum.ea.service;
 
import mum.ea.domain.Material;

public interface MaterialService 
{ 
	public void save(Material material);
	public void update(Material material); 
	public void delete(Long materialID);
	public Material get(Long materialID);
}
