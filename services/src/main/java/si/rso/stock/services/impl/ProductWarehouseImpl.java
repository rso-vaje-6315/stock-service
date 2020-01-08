package si.rso.stock.services.impl;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import si.rso.stock.lib.NumberOfProducts;
import si.rso.stock.lib.ProductWarehouse;
import si.rso.stock.mappers.ProductWarehouseMapper;
import si.rso.stock.persistence.ProductWarehouseEntity;
import si.rso.stock.services.ProductWarehouseService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductWarehouseImpl implements ProductWarehouseService {
    @PersistenceContext(unitName = "main-jpa-unit")
    private EntityManager em;

    @CircuitBreaker
    @Timeout
    @Retry
    @Override
    public List<ProductWarehouse> geProductWarehouses(String productId){

        TypedQuery<ProductWarehouseEntity> query = em.createNamedQuery(ProductWarehouseEntity.FIND_ALL_WAREHOUSES_WITH_PRODUCT, ProductWarehouseEntity.class)
                .setParameter("productId", productId);

        if (query.getResultList().size() == 0) return null;
        return query.getResultStream()
                .map(ProductWarehouseMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @CircuitBreaker
    @Timeout
    @Retry
    @Override
    @Transactional
    public Boolean addProductWarehouseQuantity(ProductWarehouse productWarehouse) {
        TypedQuery<ProductWarehouseEntity> query = em.createNamedQuery(ProductWarehouseEntity.FIND_PRODUCT_WAREHOUSE, ProductWarehouseEntity.class)
                .setParameter("productId", productWarehouse.getIdProduct())
                .setParameter("warehouseId", productWarehouse.getIdWarehouse());

        if (query.getResultList().size() == 0) return false;

        ProductWarehouseEntity productWarehouseEntity = query.getSingleResult();
        int newQuantity = productWarehouseEntity.getQuantity() + productWarehouse.getQuantity();
        productWarehouseEntity.setQuantity(newQuantity);
        return true;
    }

    @CircuitBreaker
    @Timeout
    @Retry
    @Override
    @Transactional
    public Boolean removeProductWarehouseQuantity(ProductWarehouse productWarehouse) {
        TypedQuery<ProductWarehouseEntity> query = em.createNamedQuery(ProductWarehouseEntity.FIND_PRODUCT_WAREHOUSE, ProductWarehouseEntity.class)
                .setParameter("productId", productWarehouse.getIdProduct())
                .setParameter("warehouseId", productWarehouse.getIdWarehouse());

        if (query.getResultList().size() == 0) return false;

        ProductWarehouseEntity productWarehouseEntity = query.getSingleResult();
        int newQuantity = productWarehouseEntity.getQuantity() - productWarehouse.getQuantity();
        if (newQuantity >= 0) {
            productWarehouseEntity.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    @CircuitBreaker
    @Timeout
    @Retry
    @Override
    public NumberOfProducts getNumberOfAllProducts(String productId) {
        TypedQuery<Long> query = em.createQuery("SELECT SUM(p.quantity) FROM ProductWarehouseEntity p WHERE p.idProduct = :productId", Long.class)
                .setParameter("productId", productId);
        if (query.getResultList().size() == 0) return null;
        NumberOfProducts numberOfProducts = new NumberOfProducts();
        numberOfProducts.setProductId(productId);
        numberOfProducts.setQuantity(query.getSingleResult());
        return numberOfProducts;
    }
}
