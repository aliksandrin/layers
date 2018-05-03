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
import com.javaextreme.carstore.domain.vehicles.Vehicle;
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/h2db-testcontext.xml", "classpath:META-INF/spring/repository-context.xml"})
public class ITCarStore {
    private Brand brand;
    private ElectroCar electroCar;
    private FuelCar fuelCar;
    private Moto moto;
    private Product product;
    private Truck truck;
    private Type type;
    private Customer customer;
    private Order order;
    private OrderItem orderItem;

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
    public void setUp() throws Exception {
        type = new Type();
        type.setTitle("sedan");

        brand = new Brand();
        brand.setTitle("Honda");
        brand.setTypes(new ArrayList<>(Collections.singletonList(type)));

        truck = new Truck();
        truck.setBrand(brand);
        truck.setType(type);
        truck.setCargoCapacity(1000);

        customer = new Customer();
        customer.setFirstName("Alice");
        customer.setLastName("Klo");
        customer.setEmail("foxa.design@gmail.com");
        customer.setPhone("0633761629");

        product = new Product();
        product.setVehicle(truck);
        product.setPrice(800);
        product.setQuantity(3);

        orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setPrice(product.getPrice());
        orderItem.setQuantity(1);

        order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(new HashSet<>(Collections.singletonList(orderItem)));
        order.setQuantity(1);
        order.setTotal(orderItem.getPrice());

        moto = new Moto();
        moto.setFrame("oDontKnowWhatFramesExist;)");
        moto.setBrand(brand);
        moto.setType(type);

        electroCar = new ElectroCar();
        electroCar.setNoOfPassengers((byte) 5);
        electroCar.setBatteryPower(10000);
        electroCar.setBrand(brand);
        electroCar.setType(type);

        fuelCar = new FuelCar();
        fuelCar.setNoOfPassengers((byte) 5);
        fuelCar.setEngineVolume(1600);
        fuelCar.setBrand(brand);
        fuelCar.setType(type);

        typeDAO.create(type);
        brandDAO.create(brand);
        truckDAO.create(truck);
        customerDAO.create(customer);
        orderDAO.create(order);
        orderItemDAO.create(orderItem);
        electroCarDAO.create(electroCar);
        motoDAO.create(moto);
        productDAO.create(product);
    }

    @Test
    public void daoType() {

        Assert.assertEquals(type, typeDAO.read(3));
        List<Type> types = typeDAO.findAll();
        Assert.assertEquals(3, types.size());
        Type t1 = typeDAO.read(3);
        t1.setTitle("mini");
        typeDAO.update(t1);
        Assert.assertEquals("mini", typeDAO.read(3).getTitle());
    }

    @Test
    public void daoBrand() {

        Assert.assertEquals(brand, brandDAO.read(1));
        List<Brand> brands = brandDAO.findAll();
        Assert.assertEquals(1, brands.size());
        Brand t1 = brandDAO.read(1);
        t1.setTitle("Hyndai");
        brandDAO.update(t1);
        Assert.assertEquals("Hyndai", brandDAO.read(1).getTitle());
    }

    @Test
    public void daoTruck() {

        Assert.assertEquals(truck, truckDAO.read(2));
        List<Vehicle> trucks = truckDAO.findAll();
        Assert.assertEquals(2, trucks.size());
        Truck t1 = (Truck) truckDAO.read(2);
        t1.setCargoCapacity(600);
        truckDAO.update(t1);
        Truck t2 = (Truck) truckDAO.read(2);
        Assert.assertEquals(t1.getCargoCapacity(), t2.getCargoCapacity());
    }


    @Test
    public void daoCustomer() {

        Assert.assertEquals(customer, customerDAO.read(1));
        List<Customer> customers = customerDAO.findAll();
        Assert.assertEquals(1, customers.size());
        Customer t1 = customerDAO.read(1);
        t1.setFirstName("Masha");
        customerDAO.update(t1);
        Assert.assertEquals("Masha", customerDAO.read(1).getFirstName());
    }

    @Test
    public void daoOrder() {

        Assert.assertEquals(order, orderDAO.read(1));
        Assert.assertEquals(orderItem, orderDAO.getOrderItems(1).toArray()[0]);
        List<Order> orders = orderDAO.findAll();
        Assert.assertEquals(1, orders.size());
        Order t1 = orderDAO.read(1);
        t1.setQuantity(10);
        orderDAO.update(order);
        Assert.assertEquals(Integer.valueOf(10), orderDAO.read(1).getQuantity());
    }

    @Test
    public void daoOrderItem() {

        Assert.assertEquals(orderItem, orderItemDAO.read(1));
        List<OrderItem> orders = orderItemDAO.findAll();
        Assert.assertEquals(1, orders.size());
        OrderItem t1 = orderItemDAO.read(1);
        t1.setQuantity(10);
        orderItemDAO.update(orderItem);
        Assert.assertEquals(Integer.valueOf(10), (Integer) orderItemDAO.read(1).getQuantity());
    }

    @Test
    public void daoElectroCar() {

        Assert.assertEquals(electroCar, electroCarDAO.read(1));
        List<Vehicle> electroCars = electroCarDAO.findAll();
        Assert.assertEquals(1, electroCars.size());
        ElectroCar t1 = (ElectroCar) electroCarDAO.read(1);
        t1.setBatteryPower(600);
        electroCarDAO.update(t1);
        ElectroCar t2 = (ElectroCar) electroCarDAO.read(1);
        Assert.assertEquals(t1.getBatteryPower(), t2.getBatteryPower());
    }

    @Test
    public void daoFuelCar() {
        fuelCarDAO.create(fuelCar);
        Assert.assertEquals(fuelCar, fuelCarDAO.read(7));
        List<Vehicle> fuelCars = fuelCarDAO.findAll();
        Assert.assertEquals(4, fuelCars.size());
        FuelCar t1 = (FuelCar) fuelCarDAO.read(7);
        t1.setEngineVolume(1000);
        fuelCarDAO.update(t1);
        FuelCar t2 = (FuelCar) fuelCarDAO.read(7);
        Assert.assertEquals(t1.getEngineVolume(), t2.getEngineVolume());
    }

    @Test
    public void daoMoto() {

        Assert.assertEquals(moto, motoDAO.read(1));
        List<Vehicle> motos = motoDAO.findAll();
        Assert.assertEquals(1, motos.size());
        Moto t1 = (Moto) motoDAO.read(1);
        t1.setFrame("anotherFrame");
        motoDAO.update(t1);
        Moto t2 = (Moto) motoDAO.read(1);
        Assert.assertEquals(t1.getFrame(), t2.getFrame());
    }

    @Test
    public void daoProduct() {
        Assert.assertEquals(product, productDAO.read(9));
        Assert.assertEquals(truck, productDAO.getVehicle(9));
        List<Product> products = productDAO.findAll();
        Assert.assertEquals(9, products.size());
        Product t1 = productDAO.read(9);
        t1.setQuantity(12);
        productDAO.update(t1);
        Assert.assertEquals(t1.getQuantity(), productDAO.read(9).getQuantity());
    }
}
