package si.rso.stock.services;

import si.rso.stock.lib.Warehouse;

import java.util.List;

public interface ProductWarehouseService {

    List<Warehouse> geProductWarehouses(String productId);
}
