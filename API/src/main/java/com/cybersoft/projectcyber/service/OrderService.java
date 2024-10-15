package com.cybersoft.projectcyber.service;

import com.cybersoft.projectcyber.entity.*;
import com.cybersoft.projectcyber.entity.Key.OrderDetailsId;
import com.cybersoft.projectcyber.payload.request.OrderRequest;
import com.cybersoft.projectcyber.repository.OrderDetailsRepository;
import com.cybersoft.projectcyber.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Transactional
    public boolean order(OrderRequest orderRequest) {
        try {
            Order order = new Order();

            Users user = new Users();
            user.setUserId(orderRequest.getUserrId());

            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId(orderRequest.getRestaurantId());

            order.setUser(user);
            order.setRestaurant(restaurant);
            orderRepository.save(order);

            List<OrderDetails> orderDetails = new ArrayList<>();
            for (int foodId : orderRequest.getFoodId()) {
                OrderDetails orderDetail = new OrderDetails();
                Food food = new Food();
                food.setFoodId(foodId);

                OrderDetailsId orderDetailsId = new OrderDetailsId(order.getOrderId(), foodId);
                orderDetail.setId(orderDetailsId);

                orderDetails.add(orderDetail);
            }
            orderDetailsRepository.saveAll(orderDetails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
