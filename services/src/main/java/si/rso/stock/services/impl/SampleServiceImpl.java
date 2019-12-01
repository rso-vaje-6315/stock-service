package si.rso.stock.services.impl;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.rso.stock.persistence.SampleEntity;
import si.rso.stock.services.SampleService;
import si.rso.stock.mappers.SampleMapper;
import si.rso.stock.lib.Sample;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SampleServiceImpl implements SampleService {
    
    @PersistenceContext(unitName = "main-jpa-unit")
    private EntityManager em;
    
    @Override
    public List<Sample> getSamples(QueryParameters query) {
        return JPAUtils.queryEntities(em, SampleEntity.class, query)
            .stream()
            .map(SampleMapper::fromEntity)
            .collect(Collectors.toList());
    }
    
    @Override
    public long getSamplesCount(QueryParameters query) {
        return JPAUtils.queryEntitiesCount(em, SampleEntity.class, query);
    }
    
    @Override
    public List<Sample> findByAge(int age) {
        TypedQuery<SampleEntity> query = em.createNamedQuery(SampleEntity.FIND_BY_AGE, SampleEntity.class);
        query.setParameter("age", age);
        
        return query.getResultList()
            .stream()
            .map(SampleMapper::fromEntity)
            .collect(Collectors.toList());
    }

}