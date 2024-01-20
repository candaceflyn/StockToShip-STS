package com.ttida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttida.model.InboundProduct;
import com.ttida.repository.InboundProductRepository;

import java.util.List;

@Service
public class InboundProductService {
  @Autowired
  private InboundProductRepository inboundProductRepository;

  public List<InboundProduct> getAllInboundProducts() {
    return inboundProductRepository.findAll();
  }

}
