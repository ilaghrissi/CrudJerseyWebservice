package com.tutorial.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.entity.ProductEntity;
import com.tutorial.service.ProductService;

@Path("/product")
public class ProductRessource {

	@Autowired
	private ProductService productService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addProduct(ProductEntity p) {
		productService.addProduct(p);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{id}")
	public Response updateProduct(@PathParam(value = "id") @NotNull Long id, ProductEntity p) {
		productService.updateProduct(p, id);
		return Response.status(200).build();

	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam(value = "id") Long id) {
		productService.deleteProduct(id);
		return Response.status(200).build();
	}

	@GET
	@Path("/listById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findProductById(@PathParam(value = "id") @NotNull Long id) {
		System.out.println("Lister le produit avec id " + id);
		ProductEntity p  = productService.findProductById(id);
		if(p == null) {
			return Response.status(404).build();
		}
		return Response.status(200).entity(p).build();
	}
	
	@GET
	@Path("/listAllProducts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProducts() {
		return Response.status(200).entity(productService.findAllProducts()).build();
	}
}
