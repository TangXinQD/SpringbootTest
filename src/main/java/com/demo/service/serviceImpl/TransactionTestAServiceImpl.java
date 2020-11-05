package com.demo.service.serviceImpl;

import com.demo.domain.DemoBDO;
import com.demo.domain.DemoDO;
import com.demo.mapper.DemoBMapper;
import com.demo.mapper.DemoMapper;
import com.demo.service.TransactionTestAService;
import com.demo.service.TransactionTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

@Service
public class TransactionTestAServiceImpl implements TransactionTestAService {

    @Resource
    private DemoBMapper demoBMapper;

    @Resource
    private DemoMapper demoMapper;

    @Resource
    private TransactionTestAService transactionTestAService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void A() {
        System.out.println("method a run");
        DemoDO demoDO = new DemoDO();
        demoDO.setContent("test new A");
        demoMapper.insert(demoDO);
        for (int i = 0 ; i < 2 ; i++){
            try {
                transactionTestAService.B();
            }catch (Exception e){
                System.out.println("method b exception");
            }
        }
//        throw new RuntimeException("test");
        System.out.println("method a final");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW ,rollbackFor = Exception.class)
    @Override
    public void B() {
        /*try {*/
            System.out.println("method b run");
            DemoBDO demoDO = new DemoBDO();
            demoDO.setContent("test new B new");
            demoBMapper.insert(demoDO);
            int a = 1/0;
        /*}catch (RuntimeException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }*/
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void C() {
        System.out.println("method a run");
        DemoDO demoDO = new DemoDO();
        demoDO.setContent("test nestED A");
        demoMapper.insert(demoDO);
        for (int i = 0 ; i < 2 ; i++){
            try {
                transactionTestAService.D();
            }catch (Exception e){
                System.out.println("method b exception");
            }
        }
//        throw new RuntimeException("test");
        System.out.println("method a final");
    }

    @Transactional(propagation = Propagation.NESTED ,rollbackFor = Exception.class)
    @Override
    public void D() {
        /*try {*/
        System.out.println("method b run");
        DemoBDO demoDO = new DemoBDO();
        demoDO.setContent("test nestED B new");
        demoBMapper.insert(demoDO);
        int a = 1/0;
        /*}catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }*/
    }
}
