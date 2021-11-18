package com.kocfinans.oop.service.impl;

import com.kocfinans.oop.exception.OrderNotFoundException;
import com.kocfinans.oop.exception.PaymentMethodNotFoundException;
import com.kocfinans.oop.models.Order;
import com.kocfinans.oop.models.dto.OrderDTO;
import com.kocfinans.oop.models.repo.OrderRepository;
import com.kocfinans.oop.service.IMenuService;
import com.kocfinans.oop.service.IOrderService;
import com.kocfinans.oop.service.IUserClientService;
import com.kocfinans.oop.service.impl.payment.PaymentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository repository;

    private final IUserClientService userClientService;
    private final IMenuService menuService;
    private final PaymentService onlinePaymentService;
    private final PaymentService mealPaymentService;
    private final PaymentService creditCardPaymentService;

    public OrderServiceImpl(
            OrderRepository repository,
            IUserClientService userClientService,
            IMenuService menuService,
            PaymentService onlinePaymentService,
            PaymentService mealTicketPaymentService,
            PaymentService creditCardPaymentService
    ) {
        this.repository = repository;
        this.userClientService = userClientService;
        this.menuService = menuService;
        this.onlinePaymentService = onlinePaymentService;
        this.mealPaymentService = mealTicketPaymentService;
        this.creditCardPaymentService = creditCardPaymentService;
    }

    /**
     * Get an order by id
     *
     * @param id: int
     *
     * @return Menu
     *
     */
    public Order getOrderById(int id) {
        return this.repository.findOneById(
                id
        ).orElseThrow(OrderNotFoundException::new);
    }

    /**
     * Create an order
     *
     * @param menuId: int
     * @param userClientId: int
     * @param dto: OrderDTO
     *
     * @return Order
     */
    @Transactional
    public Order create(int menuId, int userClientId, OrderDTO dto) {
        Order order = new Order();
        order.setUnchangeableAttributes();
        order.setChangeableAttributes(dto);
        order.setMenu(this.menuService.getMenuById(menuId));
        order.setUserClient(this.userClientService.getUserClientById(userClientId));

        return this.save(order);
    }

    /**
     * Get payment from userClient
     *
     * @param orderId: int
     *
     * @throws PaymentMethodNotFoundException - if Payment Method not found
     * @throws OrderNotFoundException - if Order not found
     */
    public void payment(int orderId) {
        Order order = this.getOrderById(orderId);

        switch (order.getPaymentMethod().getName()) {
            case "ONLINE":
                //TODO get credit card information
                this.onlinePaymentService.payment(order.getUserClient());
                break;
            case "CREDIT_CARD":
                this.creditCardPaymentService.payment(order.getUserClient());
                break;
            case "MEAL_TICKET":
                this.mealPaymentService.payment(order.getUserClient());
                break;
            default:
                throw new PaymentMethodNotFoundException();
        }

    }

    /**
     * Save order
     *
     * @param order: Order
     *
     * @return Order
     */
    private Order save(Order order) {
        return this.repository.save(order);
    }
}
