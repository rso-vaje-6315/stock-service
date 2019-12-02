package si.rso.stock.persistence;

import javax.persistence.*;

@Entity
@Table(name = "product_warehouse")
@NamedQueries(value = {
        @NamedQuery(name = ProductWarehouseEntity.FIND_ALL_WAREHOUSES_WITH_PRODUCT, query = "SELECT w FROM WarehouseEntity w, ProductWarehouseEntity p " +
                "WHERE p.idProduct = :productId AND w.id = p.idWarehouse")
})
public class ProductWarehouseEntity extends BaseEntity{

    public static final String  FIND_ALL_WAREHOUSES_WITH_PRODUCT = " ProductWarehouseEntity.FIND_ALL_WAREHOUSES_WITH_PRODUCT";


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
