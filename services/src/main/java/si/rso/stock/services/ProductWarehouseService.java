package si.rso.stock.services;

import si.rso.stock.lib.ProductWarehouse;

import java.util.List;

public interface ProductWarehouseService {

    List<ProductWarehouse> geProductWarehouses(String productId);

    Boolean addProductWarehouseQuantity(ProductWarehouse productWarehouse);

    Boolean removeProductWarehouseQuantity(ProductWarehouse productWarehouse);

    Long getNumberOfAllProducts(String productId);
}
