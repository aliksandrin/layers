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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/h2db-testcontext.xml", "classpath:spring/repository-context.xml"})
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
    public void setUp() throws Exception {
        type = new Type();
        type.setTitle("sedan");

        brand = new Brand();
        brand.setTitle("Honda");

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
        electroCar.setNoOfPassengers((byte)5);
        electroCar.setBatteryPower(10000);
        electroCar.setBrand(brand);
        electroCar.setType(type);

        fuelCar = new FuelCar();
        fuelCar.setNoOfPassengers((byte)5);
        fuelCar.setEngineVolume(1600);
        fuelCar.setBrand(brand);
        fuelCar.setType(type);
    }

    @Test
    public void daoType() {
        typeDAO.addType(type);
        Assert.assertEquals(type, typeDAO.getType(1));
        List<Type> types = typeDAO.findAll();
        Assert.assertEquals(1, types.size());
        Type t1 = typeDAO.getType(1);
        t1.setTitle("mini");
        typeDAO.updateType(t1);
        Assert.assertEquals("mini", typeDAO.getType(1).getTitle());
        typeDAO.delete(type);
        Assert.assertEquals(null, typeDAO.getType(1));
    }

    @Test
    public void daoTruck() {
        truckDAO.addVehicle(truck);
        Assert.assertEquals(truck, truckDAO.getVehicle(1));
        List<Vehicle> trucks = truckDAO.findAll();
        Assert.assertEquals(1, trucks.size());
        Truck t1 = (Truck) truckDAO.getVehicle(1);
        t1.setCargoCapacity(600);
        truckDAO.updateVehicle(t1);
        Truck t2 = (Truck) truckDAO.getVehicle(1);
        Assert.assertEquals(t1.getCargoCapacity(), t2.getCargoCapacity());
        truckDAO.deleteVehicle(truck);
        Assert.assertEquals(null, truckDAO.getVehicle(1));
    }

    @Test
    public void daoBrand() {
        brandDAO.addBrand(brand);
        Assert.assertEquals(brand, brandDAO.getBrand(1));
        List<Brand> brands = brandDAO.findAll();
        Assert.assertEquals(1, brands.size());
        Brand t1 = brandDAO.getBrand(1);
        t1.setTitle("Hyndai");
        brandDAO.updateBrand(t1);
        Assert.assertEquals("Hyndai", brandDAO.getBrand(1).getTitle());
        brandDAO.delete(brand);
        Assert.assertEquals(null, brandDAO.getBrand(1));
    }

    @Test
    public void daoCustomer() {
        customerDAO.addCustomer(customer);
        Assert.assertEquals(customer, customerDAO.getCustomer(1));
        List<Customer> customers = customerDAO.findAll();
        Assert.assertEquals(1, customers.size());
        Customer t1 = customerDAO.getCustomer(1);
        t1.setFirstName("Masha");
        customerDAO.updateCustomer(t1);
        Assert.assertEquals("Masha", customerDAO.getCustomer(1).getFirstName());
        customerDAO.delete(customer);
        Assert.assertEquals(null, customerDAO.getCustomer(1));
    }

    @Test
    public void daoOrder() {
        customerDAO.addCustomer(customer);
        orderItemDAO.addOrderItem(orderItem);
        truckDAO.addVehicle(truck);
        orderDAO.addOrder(order);
        Assert.assertEquals(order, orderDAO.getOrder(1));
        Assert.assertEquals(orderItem, orderDAO.getOrderItems(1).toArray()[0]);
        List<Order> orders = orderDAO.findAll();
        Assert.assertEquals(1, orders.size());
        Order t1 = orderDAO.getOrder(1);
        t1.setQuantity(10);
        orderDAO.updateOrder(order);
        Assert.assertEquals(Integer.valueOf(10), orderDAO.getOrder(1).getQuantity());
        orderDAO.delete(order);
        Assert.assertEquals(null, orderDAO.getOrder(1));
    }

    @Test
    public void daoOrderItem() {
        customerDAO.addCustomer(customer);
        orderItemDAO.addOrderItem(orderItem);
        truckDAO.addVehicle(truck);
        orderDAO.addOrder(order);
        Assert.assertEquals(orderItem, orderItemDAO.getOrderItem(1));
        List<OrderItem> orders = orderItemDAO.findAll();
        Assert.assertEquals(1, orders.size());
        OrderItem t1 = orderItemDAO.getOrderItem(1);
        t1.setQuantity(10);
        orderItemDAO.updateOrderItem(orderItem);
        Assert.assertEquals(Integer.valueOf(10), (Integer) orderItemDAO.getOrderItem(1).getQuantity());
        orderItemDAO.delete(orderItem);
        Assert.assertEquals(null, orderItemDAO.getOrderItem(1));
    }

    @Test
    public void daoElectroCar() {
        electroCarDAO.addVehicle(electroCar);
        Assert.assertEquals(electroCar, electroCarDAO.getVehicle(1));
        List<Vehicle> electroCars = electroCarDAO.findAll();
        Assert.assertEquals(1, electroCars.size());
        ElectroCar t1 = (ElectroCar) electroCarDAO.getVehicle(1);
        t1.setBatteryPower(600);
        electroCarDAO.updateVehicle(t1);
        ElectroCar t2 = (ElectroCar) electroCarDAO.getVehicle(1);
        Assert.assertEquals(t1.getBatteryPower(), t2.getBatteryPower());
        electroCarDAO.deleteVehicle(electroCar);
        Assert.assertEquals(null, electroCarDAO.getVehicle(1));
    }

    @Test
    public void daoFuelCar() {
        fuelCarDAO.addVehicle(fuelCar);
        Assert.assertEquals(fuelCar, fuelCarDAO.getVehicle(1));
        List<Vehicle> fuelCars = fuelCarDAO.findAll();
        Assert.assertEquals(1, fuelCars.size());
        FuelCar t1 = (FuelCar) fuelCarDAO.getVehicle(1);
        t1.setEngineVolume(1000);
        fuelCarDAO.updateVehicle(t1);
        FuelCar t2 = (FuelCar) fuelCarDAO.getVehicle(1);
        Assert.assertEquals(t1.getEngineVolume(), t2.getEngineVolume());
        fuelCarDAO.deleteVehicle(fuelCar);
        Assert.assertEquals(null, fuelCarDAO.getVehicle(1));
    }

    @Test
    public void daoMoto() {
        motoDAO.addVehicle(moto);
        Assert.assertEquals(moto, motoDAO.getVehicle(1));
        List<Vehicle> motos = motoDAO.findAll();
        Assert.assertEquals(1, motos.size());
        Moto t1 = (Moto) motoDAO.getVehicle(1);
        t1.setFrame("anotherFrame");
        motoDAO.updateVehicle(t1);
        Moto t2 = (Moto) motoDAO.getVehicle(1);
        Assert.assertEquals(t1.getFrame(), t2.getFrame());
        motoDAO.deleteVehicle(moto);
        Assert.assertEquals(null, motoDAO.getVehicle(1));
    }

    @Test
    public void daoProduct() {
        truckDAO.addVehicle(truck);
        productDAO.addProduct(product);
        Assert.assertEquals(product, productDAO.getProduct(1));
        Assert.assertEquals(truck, productDAO.getVehicle(1));
        List<Product> products = productDAO.findAll();
        Assert.assertEquals(1, products.size());
        Product t1 = productDAO.getProduct(1);
        t1.setQuantity(12);
        productDAO.updateProduct(t1);
        Assert.assertEquals(t1.getQuantity(), productDAO.getProduct(1).getQuantity());
        productDAO.delete(product);
        Assert.assertEquals(null, productDAO.getProduct(1));
    }
}
