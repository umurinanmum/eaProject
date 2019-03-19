package mum.ea.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import mum.ea.dao.MaterialDao; 
import mum.ea.domain.Material;
import mum.ea.service.MaterialService;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

	@Autowired 
	MaterialDao materialDao;
	
	@Override
	public void save(Material t) {
		// TODO Auto-generated method stub
		materialDao.save(t);
	}

	@Override
	public void update(Material t) {
		// TODO Auto-generated method stub
		materialDao.update(t);
	}

	@Override
	public void delete(Long t) {
		// TODO Auto-generated method stub
		materialDao.delete(t);
	}

	@Override
	public Material get(Long t) {
		// TODO Auto-generated method stub
		return 	materialDao.findOne(t);
	}
 

}
