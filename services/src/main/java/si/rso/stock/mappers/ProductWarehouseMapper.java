package si.rso.stock.mappers;

import si.rso.stock.lib.ProductWarehouse;
import si.rso.stock.persistence.ProductWarehouseEntity;

public class ProductWarehouseMapper {

    public static ProductWarehouse fromEntity(ProductWarehouseEntity entity) {

        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.setId(entity.getId());
        productWarehouse.setTimestamp(entity.getTimestamp());
        productWarehouse.setIdProduct(entity.getIdProduct());
        productWarehouse.setIdWarehouse(entity.getIdWarehouse());
        productWarehouse.setQuantity(entity.getQuantity());
        return productWarehouse;
    }
}