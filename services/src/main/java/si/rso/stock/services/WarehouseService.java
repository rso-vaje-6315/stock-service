package si.rso.stock.services;

import java.util.List;
import si.rso.stock.lib.Warehouse;


public interface WarehouseService {

    List<Warehouse> getWarehouses();

    Warehouse getWarehouse(String warehouseId);

}

