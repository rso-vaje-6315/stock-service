package si.rso.stock.api.filters;

import si.rso.stock.config.ServiceConfig;
import si.rso.rest.exceptions.RestException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@ApplicationScoped
@Provider
public class MaintenanceFilter implements ContainerRequestFilter {

    @Inject
    private ServiceConfig serviceConfig;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (serviceConfig.isMaintenance()) {
            throw new RestException("Maintenance mode!");
        }
    }
}