package si.rso.stock.api.endpoints;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

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
    public Response getWarehouses() {
        List<Warehouse> warehouses = warehouseService.getWarehouses();
        return Response.ok(warehouses).build();
    }

    @GET
    @Path("/{id}")
    public Response getWarehouse(@PathParam("id") String warehouseId) {
        Warehouse warehouse = warehouseService.getWarehouse(warehouseId);
        return Response.ok(warehouse).build();
    }

    @GET
    @Path("/stock/{productId}")
    public Response getWarehousesWithProduct(@PathParam("productId") String productId) {
        List<Warehouse> warehouses = productWarehouseService.geProductWarehouses(productId);
        return Response.ok(warehouses).build();
    }

}
