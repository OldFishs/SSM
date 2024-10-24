package com.xxx.pojo;

import lombok.Data;
import org.junit.jupiter.api.Test;

@Data
public class Order {

    private Integer orderId;

    private String orderName;

    private Integer customerId;

    private Customer customer;
}
