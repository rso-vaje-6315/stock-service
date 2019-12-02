package si.rso.stock.services.impl;

import si.rso.stock.lib.Warehouse;
import si.rso.stock.mappers.WarehouseMapper;
import si.rso.stock.persistence.WarehouseEntity;
import si.rso.stock.services.WarehouseService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class WarehouseServiceImpl implements WarehouseService {

    @PersistenceContext(unitName = "main-jpa-unit")
    private EntityManager em;

    @Override
    public List<Warehouse> getWarehouses() {

        TypedQuery<WarehouseEntity> query = em.createNamedQuery(WarehouseEntity.FIND_ALL, WarehouseEntity.class);

        return query.getResultStream()
                .map(WarehouseMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Warehouse getWarehouse(String warehouseId) {
        WarehouseEntity warehouseEntity = em.find(WarehouseEntity.class, warehouseId);
        return WarehouseMapper.fromEntity(warehouseEntity);
    }
}
