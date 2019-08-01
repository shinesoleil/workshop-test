package com.thoughtworks.workshoptest.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

  private ProductService productService;

  @Before
  public void setUp() throws Exception {
    productService = new ProductService();
  }

  @Test
  public void should_return_null_when_getting_products() {
    assertThat(productService.getAll(), is(nullValue()));
  }
}
