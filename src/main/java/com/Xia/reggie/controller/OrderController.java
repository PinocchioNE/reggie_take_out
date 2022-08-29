package com.Xia.reggie.controller;

import com.Xia.reggie.common.BaseContext;
import com.Xia.reggie.common.R;
import com.Xia.reggie.dto.OrderDto;
import com.Xia.reggie.entity.OrderDetail;
import com.Xia.reggie.entity.Orders;
import com.Xia.reggie.service.OrderDetailService;
import com.Xia.reggie.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("成功");
        orderService.submit(orders);

        return R.success("下单成功");
    }

    @GetMapping ("/userPage")
    public R<Page> page(int page, int pageSize){
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        Page<OrderDto> pageDto = new Page<>(page,pageSize);

        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Orders::getUserId, BaseContext.getCurrentId());
        queryWrapper.orderByDesc(Orders::getOrderTime);
        orderService.page(pageInfo, queryWrapper);
        LambdaQueryWrapper<OrderDetail> queryWrapper1 = new LambdaQueryWrapper<>();
        List<Orders> records = pageInfo.getRecords();
        List<OrderDto> orderDtoList = records.stream().map((item)->{

            OrderDto dto = new OrderDto();
            Long id = item.getId();
            List<OrderDetail> orderDetailList = this.getOrderDetailListByOrderId(id);
            BeanUtils.copyProperties(item,dto);

            dto.setOrderDetails(orderDetailList);
            return dto;
        }).collect(Collectors.toList());

        BeanUtils.copyProperties(pageInfo,pageDto,"recoders");
        pageDto.setRecords(orderDtoList);
        return R.success(pageDto);
    }

    public List<OrderDetail> getOrderDetailListByOrderId(Long orderId){
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId,orderId);
        List<OrderDetail> list = orderDetailService.list(queryWrapper);
        return list;

    }

}
