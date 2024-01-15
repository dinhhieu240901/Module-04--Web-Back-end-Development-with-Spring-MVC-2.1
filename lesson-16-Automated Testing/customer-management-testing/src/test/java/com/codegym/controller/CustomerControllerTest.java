package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.impl.CustomerServiceImplWithSpringData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@SpringJUnitJupiterConfig(CustomerControllerTestConfig.class)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    private final CustomerService customerService = Mockito.mock(CustomerServiceImplWithSpringData.class);

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    void customersListPageIsExits() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(view().name("/customers/list"));
    }

    @Test
    void showInformationSuccessControlling() throws Exception {
        Customer customer = new Customer(1L, "CodeGym", "codegym@codegym.vn", "Hn");
        given(customerService.findOne(1L)).willReturn(Optional.of(customer));
        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("/customers/info"));
    }

    @Test
    void customerUpdateSuccessControlling() throws Exception {
        Customer customer = new Customer(1L, "CodeGym", "codegym@codegym.vn", "Hn");
        when(customerService.save(isA(Customer.class))).thenReturn(customer);
        mockMvc.perform(post("/customers")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("id", customer.getId().toString())
        .param("name", customer.getName())
                .param("email", customer.getEmail())
                .param("address", customer.getAddress()))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/customers"));
    }
}
