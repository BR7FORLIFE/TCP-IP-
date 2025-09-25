package com.archives.__basic_crud.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class CustomersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false)
    private String password;

    @CreatedDate
    private Date create_at;

    @LastModifiedDate
    private Date lastModified;
    
    @ManyToMany(mappedBy = "customers")
    List<OrdersEntity> orders = new ArrayList<>();
}
