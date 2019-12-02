package si.rso.stock.mappers;

import si.rso.stock.lib.Warehouse;
import si.rso.stock.persistence.WarehouseEntity;

public class WarehouseMapper {

    public static Warehouse fromEntity(WarehouseEntity entity) {

        Warehouse warehouse = new Warehouse();
        warehouse.setId(entity.getId());
        warehouse.setTimestamp(entity.getTimestamp());
        warehouse.setLocation(entity.getLocation());
        return warehouse;
    }
}
