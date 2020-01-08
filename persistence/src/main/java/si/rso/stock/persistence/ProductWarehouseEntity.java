package si.rso.stock.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "product_warehouse")
@NamedQueries(value = {
        @NamedQuery(name = ProductWarehouseEntity.FIND_ALL_WAREHOUSES_WITH_PRODUCT, query = "SELECT p FROM WarehouseEntity w, ProductWarehouseEntity p " +
                "WHERE p.idProduct = :productId AND w.id = p.idWarehouse"),
        @NamedQuery(name = ProductWarehouseEntity.FIND_PRODUCT_WAREHOUSE, query = "SELECT p FROM ProductWarehouseEntity p " +
                "WHERE p.idProduct = :productId AND p.idWarehouse = :warehouseId"),
})
public class ProductWarehouseEntity extends BaseEntity{

    public static final String  FIND_ALL_WAREHOUSES_WITH_PRODUCT = " ProductWarehouseEntity.FIND_ALL_WAREHOUSES_WITH_PRODUCT";
    public static final String  FIND_PRODUCT_WAREHOUSE = " ProductWarehouseEntity.FIND_PRODUCT_WAREHOUSE";


    @Column(name = "id_warehouse")
    private String idWarehouse;

    @Column(name = "id_product")
    private String idProduct;

    @Column(name = "quantity")
    private int quantity;

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
