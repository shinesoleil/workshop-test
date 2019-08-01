package com.thoughtworks.workshoptest.controllers;

import com.thoughtworks.workshoptest.models.Product;
import com.thoughtworks.workshoptest.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  @Test
  public void should_return_empty_list_when_getting_products() throws Exception {
    when(productService.getAll()).thenReturn(new ArrayList<>());

    mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isEmpty())
        .andExpect(jsonPath("$").isArray());

    verify(productService, times(1)).getAll();
  }

  @Test
  public void should_return_list_with_one_product_when_getting_products() throws Exception {
    Product product = new Product();
    product.setId("1");
    product.setName("ice peak");

    List<Product> productList = new ArrayList<>();
    productList.add(product);

    when(productService.getAll()).thenReturn(productList);

    mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value("1"))
        .andExpect(jsonPath("$[0].name").value("ice peak"));

    verify(productService, times(1)).getAll();
  }
}
