package mum.ea.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.ea.domain.Test;
import mum.ea.dao.TestDao;
import mum.ea.service.TestService;

import java.util.ArrayList;
import java.util.List;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    public void save(Test t) {
        testDao.save(t);
    }

    public void delete(Long id) {
        testDao.delete(id);
    }

    public void update(Test t) {
        testDao.update(t);
    }

    public Test findById(Long id) {
       return testDao.findById(id);
    }

    public List<Test> findAll() {
        Iterable<Test> data = testDao.findAll();
        List<Test> result = new ArrayList<Test>();
        for (Test t : data) {
            result.add(t);
        }
        return result;
    }

}
