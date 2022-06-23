package uz.pdp.barcode.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.barcode.model.*;
import uz.pdp.barcode.repository.*;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CheckRepository checkRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    WeightTypeRepository weightTypeRepository;

    @Autowired
    CheckProductRepository checkProductRepository;

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    @Autowired
    BarcodeRepository barcodeRepository;

    @Value("${spring.sql.init.mode}")
    String initMode;

    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("always")) {
            Brand savedBrand1 = brandRepository.save(new Brand("COCA-COLA"));
            Brand savedBrand2 = brandRepository.save(new Brand("Colgate"));
            Brand savedBrand3 = brandRepository.save(new Brand("Pepsi"));
            Brand savedBrand4 = brandRepository.save(new Brand("Fanta"));

            WeightType weightType1 = weightTypeRepository.save(new WeightType("kg"));
            WeightType weightType4 = weightTypeRepository.save(new WeightType("gr"));
            WeightType weightType2 = weightTypeRepository.save(new WeightType("l"));
            WeightType weightType3 = weightTypeRepository.save(new WeightType("dona"));

            Category category1 = categoryRepository.save(new Category("watery"));
            Category category2 = categoryRepository.save(new Category("dried fruit"));
            Category category3 = categoryRepository.save(new Category("wet fruit"));
            Category category4 = categoryRepository.save(new Category("cleaning equipment"));
            Product product1 = productRepository.save(new Product("coca-cola",  category1, 1.5, savedBrand1, weightType2));
            Product product2 = productRepository.save(new Product("fanta",  category1, 1, savedBrand4, weightType2));
            Product product3 = productRepository.save(new Product("pepsi",  category1, 0.5, savedBrand3, weightType2));
            Product product4 = productRepository.save(new Product("colgate",  category4, 0.1, savedBrand2, weightType4));

            Barcode barcode1 = barcodeRepository.save(new Barcode("1234567", product1));
            Barcode barcode2 = barcodeRepository.save(new Barcode("1234568", product2));
            Barcode barcode3 = barcodeRepository.save(new Barcode("1234569", product3));
            Barcode barcode4 = barcodeRepository.save(new Barcode("1234578", product4));

            Stock stock1 = stockRepository.save(new Stock(product1, LocalDate.of(2021, 6, 4), LocalDate.of(2022, 6, 4), 100, 150, 10));
            Stock stock2 = stockRepository.save(new Stock(product2, LocalDate.of(2021, 6, 4), LocalDate.of(2022, 6, 5), 240, 300, 10));
            Stock stock3 = stockRepository.save(new Stock(product3, LocalDate.of(2021, 6, 4), LocalDate.of(2022, 6, 6), 350, 400, 10));
//            Stock stock4 = stockRepository.save(new Stock(product4, LocalDate.of(2021, 6, 4), LocalDate.of(2022, 6, 7), 400, 450, 10));

            PaymentType paymentType1 = paymentTypeRepository.save(new PaymentType("cash"));
            PaymentType paymentType2 = paymentTypeRepository.save(new PaymentType("click"));
            final Check check1 = checkRepository.save(new Check("no name"));
            final Check check2 = checkRepository.save(new Check("no name"));
            final Check check3 = checkRepository.save(new Check("no name"));
            final Check check4 = checkRepository.save(new Check("no name"));
            final Check check5 = checkRepository.save(new Check("no name"));
            final CheckProduct checkProduct1 = checkProductRepository.save(new CheckProduct(stock1, check1, paymentType1, "tetst", 1, 100));
            final CheckProduct checkProduct2 = checkProductRepository.save(new CheckProduct(stock2, check1, paymentType2, "tetst1", 3, 200));
            final CheckProduct checkProduct3 = checkProductRepository.save(new CheckProduct(stock3, check1, paymentType2, "tetst2", 2, 300));
//            final CheckProduct checkProduct4 = checkProductRepository.save(new CheckProduct(stock4, check1, paymentType1, "tetst3", 4, 400));
            final CheckProduct checkProduct5 = checkProductRepository.save(new CheckProduct(stock1, check1, paymentType1, "tetst4", 2, 500));

            final CheckProduct checkProduct11 = checkProductRepository.save(new CheckProduct(stock1, check2, paymentType1, "tetst", 1, 100));
            final CheckProduct checkProduct21 = checkProductRepository.save(new CheckProduct(stock2, check2, paymentType1, "tetst122", 3, 200));
            final CheckProduct checkProduct31 = checkProductRepository.save(new CheckProduct(stock2, check2, paymentType1, "tetst222", 1, 300));
//            final CheckProduct checkProduct41 = checkProductRepository.save(new CheckProduct(stock4, check2, paymentType1, "tetst322", 1, 400));
        }
    }
}
