package com.javaextreme.carstore;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;
import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.ElectroCar;
import com.javaextreme.carstore.domain.vehicles.FuelCar;
import com.javaextreme.carstore.domain.vehicles.Moto;
import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.domain.vehicles.Truck;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.repository.BrandDAO;
import com.javaextreme.carstore.repository.CustomerDAO;
import com.javaextreme.carstore.repository.ElectroCarDAO;
import com.javaextreme.carstore.repository.FuelCarDAO;
import com.javaextreme.carstore.repository.MotoDAO;
import com.javaextreme.carstore.repository.OrderDAO;
import com.javaextreme.carstore.repository.OrderItemDAO;
import com.javaextreme.carstore.repository.ProductDAO;
import com.javaextreme.carstore.repository.TruckDAO;
import com.javaextreme.carstore.repository.TypeDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/hibernate-context.xml", "classpath:spring/repository-context.xml"})
public class Real {
    private Brand brand;
    private ElectroCar electroCar;
    private FuelCar fuelCar;
    @Autowired
    private Moto moto;
    private Product product;
    private Truck truck;
    private Type type;
    private Customer customer;
    private Order order;
    private OrderItem orderItem;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BrandDAO brandDAO;

    @Autowired
    private TruckDAO truckDAO;

    @Autowired
    private TypeDAO typeDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderItemDAO orderItemDAO;

    @Autowired
    private FuelCarDAO fuelCarDAO;

    @Autowired
    private ElectroCarDAO electroCarDAO;

    @Autowired
    private MotoDAO motoDAO;

    @Autowired
    private ProductDAO productDAO;
    @Before
    public void setUp() {
        product = new Product();

    }

    @Test
    public void daoBrand() {
        brand = brandDAO.read(1);
        type = typeDAO.read(2);
        moto.setBrand(brand);
        moto.setType(type);
        moto.setFrame("ht1");
        motoDAO.create(moto);
    }
}
