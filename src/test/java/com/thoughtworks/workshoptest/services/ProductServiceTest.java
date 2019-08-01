package com.thoughtworks.workshoptest.services;

import com.thoughtworks.workshoptest.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

  private ProductService productService;

  @Mock
  private ProductRepository productRepository;

  @Before
  public void setUp() throws Exception {
    productService = new ProductService(productRepository);
  }

  @Test
  public void should_return_null_when_getting_products() {
    when(productRepository.findAll()).thenReturn(null);

    assertThat(productService.getAll(), is(nullValue()));

    verify(productRepository, times(1)).findAll();
  }
}
