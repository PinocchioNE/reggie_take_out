package com.Xia.reggie.dto;

import com.Xia.reggie.entity.OrderDetail;
import com.Xia.reggie.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto extends Orders {
    private List<OrderDetail> orderDetails;

}
