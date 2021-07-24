package com.callforcode.eluf.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Order;
import com.callforcode.eluf.model.OrderItem;
import com.callforcode.eluf.model.PaymentByBankSlip;
import com.callforcode.eluf.model.enums.PaymentStatus;
import com.callforcode.eluf.repositories.OrderItemRepository;
import com.callforcode.eluf.repositories.OrderRepository;
import com.callforcode.eluf.repositories.PaymentRepository;
import com.callforcode.eluf.services.exceptions.AuthorizationException;
import com.callforcode.eluf.services.exceptions.ObjectNotFoundException;



@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private BankSlipService bankSlipService ;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private MailService mailService;

	public Order find(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Order.class.getName()));
	}
	
	@Transactional
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setInstant(new Date());
		obj.setClient(clientService.find(obj.getClient().getId()));
		obj.getPayment().setState(PaymentStatus.PENDING);
		obj.getPayment().setPedido(obj);
		if (obj.getPayment() instanceof PaymentByBankSlip) {
			PaymentByBankSlip pagto = (PaymentByBankSlip) obj.getPayment();
			bankSlipService.fulfillBankSlipPayment(pagto, obj.getInstant());
		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		for (OrderItem ot : obj.getItems()) {
			ot.setDiscount(0.0);
			ot.setProduto(productService.find(ot.getProduct().getId()));
			ot.setPrice(ot.getProduct().getPrice());
			ot.setOrder(obj);
		}
		orderItemRepository.saveAll(obj.getItems());
		mailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
	
	public Page<Order> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Access denied");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Client client =  clientService.find(user.getId());
		return repo.findByClient(client, pageRequest);
	}

}
