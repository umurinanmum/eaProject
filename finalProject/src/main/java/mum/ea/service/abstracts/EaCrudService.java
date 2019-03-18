package mum.ea.service.abstracts;

import mum.ea.domain.Member;
import mum.ea.domain.abstracts.BaseDomain;

import java.util.List;

public interface EaCrudService<TDomain extends BaseDomain> {
    void save(TDomain t);

    void delete(Long id);

    void update(TDomain t);

    TDomain findById(Long id);

    List<TDomain> findAll();

	
}
