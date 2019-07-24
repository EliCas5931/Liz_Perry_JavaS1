package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.ProcessingFee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoJdbcTemplateImplTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Test
    public void getProcessingFeeByProductType() {

        ProcessingFee consoleProcessingFee = processingFeeDao.getProcessingFeeByProductType("console");

        assertEquals(new BigDecimal("14.99"), consoleProcessingFee.getFee());

        ProcessingFee tShirtProcessingFee = processingFeeDao.getProcessingFeeByProductType("t_shirt");

        assertEquals(new BigDecimal("1.98"), tShirtProcessingFee.getFee());

        ProcessingFee gameProcessingFee = processingFeeDao.getProcessingFeeByProductType("game");

        assertEquals(new BigDecimal("1.49"), gameProcessingFee.getFee());

    }
}
