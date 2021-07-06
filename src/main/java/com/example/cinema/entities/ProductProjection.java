package com.example.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="P1",types=Product.class)
public interface ProductProjection {

    public double getPrice();
    public String getDesignation();
	
}
