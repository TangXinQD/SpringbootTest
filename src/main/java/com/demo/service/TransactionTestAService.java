package com.demo.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionTestAService {

     void A();

     void B();

     void C();

     void D();
}
