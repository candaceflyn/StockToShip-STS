package com.ttida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttida.model.InboundProduct;

public interface InboundProductRepository extends JpaRepository<InboundProduct, Long> {
  // Add custom queries if needed
}
