package si.rso.stock.persistence;

import javax.persistence.*;

@Entity
@Table(name = "warehouses")
@NamedQueries(value = {
        @NamedQuery(name = WarehouseEntity.FIND_ALL, query = "SELECT w FROM WarehouseEntity w")
})
public class WarehouseEntity extends BaseEntity{

    public static final String FIND_ALL = "WarehouseEntity.findAll";

    @Column(name = "location")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
