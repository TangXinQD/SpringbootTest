package com.demo.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionTestService {

     void A();

     void B();

     void C();

     void D();
}
