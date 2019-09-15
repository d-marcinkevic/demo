package com.example.demo.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerRestControllerIntegrationTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenCustomers_whenGetCustomers_thenReturnCustomers() {
        //given
        Customer c1 = new Customer();
        c1.setName("TestName1");
        c1.setSurname("TestSurname1");
        c1.setBirthDate(LocalDate.of(1990, 05, 25));
        c1.setTelephoneNumber("123456789");
        c1.setEmail("qqq@email.com");

        Customer c2 = new Customer();
        c2.setName("TestName2");
        c2.setSurname("TestSurname2");
        c2.setBirthDate(LocalDate.of(1991, 06, 26));
        c2.setTelephoneNumber("987654321");
        c2.setEmail("www@email.com");

        Customer c3 = new Customer();
        c3.setName("TestName3");
        c3.setSurname("TestSurname3");
        c3.setBirthDate(LocalDate.of(1992, 07, 27));
        c3.setTelephoneNumber("213546798");
        c3.setEmail("eee@email.com");

        List<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        given(customerService.getCustomers()).willReturn(customers);

        //when
        ResponseEntity<Customer[]> customersGetResponse = restTemplate.getForEntity("/api/v1/customers", Customer[].class);

        //then
        assertThat(customersGetResponse.getBody().length).isEqualTo(3);
    }

    @Test
    public void canCreateAndRetrieveANewContact() throws IOException {
        //given
        Customer customer = new Customer();
        customer.setName("TestName3");
        customer.setSurname("TestSurname3");
        customer.setBirthDate(LocalDate.of(1990, 05, 25));
        customer.setTelephoneNumber("555555555");
        customer.setEmail("rrr@email.com");

        ResponseEntity<Customer> customerPostResponse = restTemplate.postForEntity("/api/v1/customers", customer, Customer.class);

        given(customerService.getCustomerByName("TestName3")).willReturn(customer);

        //when
        ResponseEntity<Customer> contactGetResponse = restTemplate.getForEntity("/api/v1/contacts/TestName3", Customer.class);

        //then
        assertThat(contactGetResponse.getBody().equals(customer));
        System.out.println("qq: " + contactGetResponse.getBody());
    }
}
