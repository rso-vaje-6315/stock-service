package si.rso.stock.api.endpoints;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import si.rso.stock.lib.NumberOfProducts;
import si.rso.stock.lib.ProductWarehouse;
import si.rso.stock.lib.Warehouse;
import si.rso.stock.services.ProductWarehouseService;
import si.rso.stock.services.WarehouseService;

@Path("/warehouses")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WarehouseEndpoint {

    @Inject
    private WarehouseService warehouseService;

    @Inject
    private ProductWarehouseService productWarehouseService;

    @Context
    protected UriInfo uriInfo;


    @GET
    @Path("/")
    @Timeout
    @Retry
    public Response getWarehouses() {
        List<Warehouse> warehouses = warehouseService.getWarehouses();
        return Response.ok(warehouses).build();
    }

    @GET
    @Path("/{id}")
    @Timeout
    @Retry
    public Response getWarehouse(@PathParam("id") String warehouseId) {
        Warehouse warehouse = warehouseService.getWarehouse(warehouseId);
        return Response.ok(warehouse).build();
    }

    @GET
    @Path("/stock/{productId}")
    @Timeout
    @Retry
    public Response getWarehousesWithProduct(@PathParam("productId") String productId) {
        List<ProductWarehouse> warehouses = productWarehouseService.geProductWarehouses(productId);
        return Response.ok(warehouses).build();
    }

    @GET
    @Path("/allstock/{productId}")
    @Timeout
    @Retry
    public Response getNumberOfAllProducts(@PathParam("productId") String productId) {
        NumberOfProducts product = productWarehouseService.getNumberOfAllProducts(productId);
        return Response.ok(product).build();
    }

    @POST
    @Path("/stock")
    @Timeout
    @Retry
    public Response addProductWarehouseQuantity(ProductWarehouse productWarehouse) {
        try {
            Boolean successfullyAdded = productWarehouseService.addProductWarehouseQuantity(productWarehouse);
            return successfullyAdded ? Response.ok().build() : Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @DELETE
    @Path("/stock")
    @Timeout
    @Retry
    public Response removeProductWarehouseQuantity(ProductWarehouse productWarehouse) {
        try {
            Boolean successfullyRemoved = productWarehouseService.removeProductWarehouseQuantity(productWarehouse);
            return successfullyRemoved ? Response.ok().build() : Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

}
