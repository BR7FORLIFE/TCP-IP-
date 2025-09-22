package com.archives.__basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.archives.__basic_crud.models.OrdersEntity;

@Repository
public interface OrdersRepo extends JpaRepository<OrdersEntity, Integer> {}
