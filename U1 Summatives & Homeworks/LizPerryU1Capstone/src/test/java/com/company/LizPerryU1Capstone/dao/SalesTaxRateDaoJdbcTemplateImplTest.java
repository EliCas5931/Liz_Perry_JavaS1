package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoJdbcTemplateImplTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Test
    public void getSalesTaxRateByState() {

        SalesTaxRate taxSC = salesTaxRateDao.getSalesTaxRateByState("SC");

        assertEquals(new BigDecimal(".06"), taxSC.getRate());

        SalesTaxRate taxNC = salesTaxRateDao.getSalesTaxRateByState("NC");

        assertEquals(new BigDecimal(".05"), taxNC.getRate());

    }
}
