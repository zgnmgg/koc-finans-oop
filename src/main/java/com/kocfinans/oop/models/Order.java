package com.kocfinans.oop.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kocfinans.oop.helper.Utils;
import com.kocfinans.oop.models.dto.OrderDTO;
import com.kocfinans.oop.models.enumerator.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "client_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_client_id", nullable = false)
    private UserClient userClient;
    @Column(name = "created_at", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Istanbul")
    private Timestamp createdAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private Payment paymentMethod;

    public void setUnchangeableAttributes() {
        this.setCreatedAt(Utils.getCurrentTimestamp());
    }

    public void setChangeableAttributes(OrderDTO dto) {
        this.setPaymentMethod(Payment.valueOf(dto.getPaymentMethod()));
    }
}
