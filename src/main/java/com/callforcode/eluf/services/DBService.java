package com.callforcode.eluf.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.Category;
import com.callforcode.eluf.model.City;
import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Address;
import com.callforcode.eluf.model.State;
import com.callforcode.eluf.model.OrderItem;
import com.callforcode.eluf.model.Payment;
import com.callforcode.eluf.model.PaymentByBankSlip;
import com.callforcode.eluf.model.CardPayment;
import com.callforcode.eluf.model.Order;
import com.callforcode.eluf.model.Product;
import com.callforcode.eluf.model.enums.PaymentStatus;
import com.callforcode.eluf.model.enums.Profile;
import com.callforcode.eluf.model.enums.TypeClient;
import com.callforcode.eluf.repositories.CategoryRepository;
import com.callforcode.eluf.repositories.CityRepository;
import com.callforcode.eluf.repositories.ClientRepository;
import com.callforcode.eluf.repositories.AddressRepository;
import com.callforcode.eluf.repositories.StateRepository;
import com.callforcode.eluf.repositories.OrderItemRepository;
import com.callforcode.eluf.repositories.PaymentRepository;
import com.callforcode.eluf.repositories.OrderRepository;
import com.callforcode.eluf.repositories.ProductRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		
		Category cat1 = new Category(null, "Feira");
		Category cat2 = new Category(null, "Lanches");
		Category cat3 = new Category(null, "Orientais");
		Category cat4 = new Category(null, "Padaria");
		Category cat5 = new Category(null, "Confeitaria");
		Category cat6 = new Category(null, "Massas");
		
	

		Product p1 = new Product(null, "Baguncinha", 3.00);
		Product p2 = new Product(null, "X-tudo", 3.80);
		Product p3 = new Product(null, "Cachorro Quente", 1.50);
		
		Product p4 = new Product(null, "Sashimi", 8.00);
		Product p5 = new Product(null, "Yakisoba", 6.00);
		Product p6 = new Product(null, "Robata", 9.00);
		
		Product p7 = new Product(null, "Pão doce", 0.15);
		Product p8 = new Product(null, "Pão francês", 0.10);
		Product p9 = new Product(null, "Presunto", 1.25);
		Product p10 = new Product(null, "Queijo", 1.30);
		
		Product p11 = new Product(null, "Caramelo", 2.00);
		Product p49 = new Product(null, "Bolo de brigadeiro", 3.00);
		Product p50 = new Product(null, "Chocolate", 2.25);
		
		Product p51 = new Product(null, "Steakhouse Pasta", 9.00);
		Product p52 = new Product(null, "Chicken Pasta Primavera", 6.00);
		Product p53 = new Product(null, "Toowoomba Pasta", 4.50);
		
		Product p12 = new Product(null, "Uva", 0.30);
		Product p13 = new Product(null, "Manga", 0.40);
		Product p14 = new Product(null, "Alface", 0.30);
		Product p15 = new Product(null, "Jabuticaba", 0.30);
		Product p16 = new Product(null, "Goiaba", 0.20);
		Product p17 = new Product(null, "Cenora", 0.80);
		Product p18 = new Product(null, "Batata", 1.30);
		Product p19 = new Product(null, "Tomate", 0.70);
		Product p20 = new Product(null, "Melancia", 0.30);
		Product p21 = new Product(null, "Caju", 0.30);
		Product p22 = new Product(null, "Abobora", 1.90);
		Product p23 = new Product(null, "Chuchu", 0.30);
		Product p24 = new Product(null, "Ervilha", 0.60);
		Product p25 = new Product(null, "Jiló", 0.30);
		Product p26 = new Product(null, "Mandioca", 0.50);
		Product p27 = new Product(null, "Vagem", 0.80);
		Product p28 = new Product(null, "Limão", 0.65);
		Product p29 = new Product(null, "Ovos", 0.30);
		Product p30 = new Product(null, "Caqui", 0.30);
		Product p31 = new Product(null, "Pimenta", 0.45);
		Product p32 = new Product(null, "Mostarda", 0.40);
		Product p33 = new Product(null, "Quiabo", 0.30);
		Product p34 = new Product(null, "Nabo", 0.30);
		Product p35 = new Product(null, "Maracujá", 0.30);
		Product p36 = new Product(null, "Pimentão", 0.30);
		Product p37 = new Product(null, "Repolho", 0.30);
		Product p38 = new Product(null, "Rbanete", 0.75);
		Product p39 = new Product(null, "Repolho", 0.30);
		Product p40 = new Product(null, "Banana", 1.30);
		Product p41 = new Product(null, "Salsão", 0.10);
		Product p42 = new Product(null, "Ameixa", 0.30);
		Product p43 = new Product(null, "Abacaxi", 0.30);
		Product p44 = new Product(null, "Louro", 0.30);
		Product p45 = new Product(null, "Pepino", 0.30);
		Product p46 = new Product(null, "Maçã", 0.30);
		Product p47 = new Product(null, "Abacate", 0.30);
		Product p48 = new Product(null, "Milho", 0.30);
		
		
		cat1.getProducts().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
		p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
		p39, p40, p41, p42, p43, p44, p45, p46, p47, p48));
		
		p12.getCategories().add(cat1);
		p13.getCategories().add(cat1);
		p14.getCategories().add(cat1);
		p15.getCategories().add(cat1);
		p16.getCategories().add(cat1);
		p17.getCategories().add(cat1);
		p18.getCategories().add(cat1);
		p19.getCategories().add(cat1);
		p20.getCategories().add(cat1);
		p21.getCategories().add(cat1);
		p22.getCategories().add(cat1);
		p23.getCategories().add(cat1);
		p24.getCategories().add(cat1);
		p25.getCategories().add(cat1);
		p26.getCategories().add(cat1);
		p27.getCategories().add(cat1);
		p28.getCategories().add(cat1);
		p29.getCategories().add(cat1);
		p30.getCategories().add(cat1);
		p31.getCategories().add(cat1);
		p32.getCategories().add(cat1);
		p33.getCategories().add(cat1);
		p34.getCategories().add(cat1);
		p35.getCategories().add(cat1);
		p36.getCategories().add(cat1);
		p37.getCategories().add(cat1);
		p38.getCategories().add(cat1);
		p39.getCategories().add(cat1);
		p40.getCategories().add(cat1);
		p41.getCategories().add(cat1);
		p42.getCategories().add(cat1);
		p43.getCategories().add(cat1);
		p44.getCategories().add(cat1);
		p45.getCategories().add(cat1);
		p46.getCategories().add(cat1);
		p47.getCategories().add(cat1);
		p48.getCategories().add(cat1);
		
		
		cat2.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat3.getProducts().addAll(Arrays.asList(p4, p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p7, p8, p9, p10));
		cat5.getProducts().addAll(Arrays.asList(p11,p49,p50));
		cat6.getProducts().addAll(Arrays.asList(p51, p52,p53));
		

		p1.getCategories().addAll(Arrays.asList(cat2));
		p2.getCategories().addAll(Arrays.asList(cat2));
		p3.getCategories().addAll(Arrays.asList(cat2));
		
		p4.getCategories().addAll(Arrays.asList(cat3));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat4));
		p9.getCategories().addAll(Arrays.asList(cat4));
		p10.getCategories().addAll(Arrays.asList(cat4));
		p11.getCategories().addAll(Arrays.asList(cat5));
		p49.getCategories().addAll(Arrays.asList(cat5));
		p50.getCategories().addAll(Arrays.asList(cat5));
		p51.getCategories().addAll(Arrays.asList(cat6));
		p52.getCategories().addAll(Arrays.asList(cat6));
		p53.getCategories().addAll(Arrays.asList(cat6));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		productRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50, p51,p52,p53));
		
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");

		City c1 = new City(null, "UberLândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Pedro Cruz", "pedro.cruzifmt@gmail.com", "02240120287", TypeClient.NATURALPERSON, pe.encode("123"));
		cli1.getPhone().addAll(Arrays.asList("993075499", "992758346"));
		
		
		Client cli2 = new Client(null, "John Doe", "pedro.henriqueifmt@hotmail.com", "38922018038", TypeClient.NATURALPERSON, pe.encode("123"));
		cli2.getPhone().addAll(Arrays.asList("992257689", "993574868"));
		cli2.addProfile(Profile.ADMIN);
		
		Address e1 = new Address(null, "Rua Flores", "Apto 303", "1160", "Jardim", "78080030", cli1, c1);
		Address e2 = new Address(null, "Rua Manga", "Sala 404", "14", "Centro", "75090012", cli1, c2);
		Address e3 = new Address(null, "Rua Queijo", "2106", null, "Centro", "77075513", cli2, c2);

		cli1.getAddresses().addAll(Arrays.asList(e1, e2));
		cli2.getAddresses().addAll(Arrays.asList(e3));

		clientRepository.saveAll(Arrays.asList(cli1, cli2));
		addressRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Order ped1 = new Order(null, sdf.parse("18/03/2021 14:20"), cli1, e1);
		Order ped2 = new Order(null, sdf.parse("19/03/2021 15:45"), cli1, e2);

		Payment pagto1 = new CardPayment(null, PaymentStatus.SETTLED, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new PaymentByBankSlip(null, PaymentStatus.PENDING, ped2, sdf.parse("01/04/2021 00:00"),
				null);
		ped2.setPayment(pagto2);

		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));

		orderRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

		OrderItem ip1 = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
		OrderItem ip2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
		OrderItem ip3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);

		ped1.getItems().addAll(Arrays.asList(ip1, ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));

		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));

		orderItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}

