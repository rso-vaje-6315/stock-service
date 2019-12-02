package si.rso.stock.services.impl;

import si.rso.stock.lib.Warehouse;
import si.rso.stock.mappers.WarehouseMapper;
import si.rso.stock.persistence.ProductWarehouseEntity;
import si.rso.stock.persistence.WarehouseEntity;
import si.rso.stock.services.ProductWarehouseService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductWarehouseImpl implements ProductWarehouseService {
    @PersistenceContext(unitName = "main-jpa-unit")
    private EntityManager em;

    @Override
    public List<Warehouse> geProductWarehouses(String productId){

        TypedQuery<WarehouseEntity> query = em.createNamedQuery(ProductWarehouseEntity.FIND_ALL_WAREHOUSES_WITH_PRODUCT, WarehouseEntity.class)
                .setParameter("productId", productId);

        return query.getResultStream()
                .map(WarehouseMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
