package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.SalesTaxRate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements  SalesTaxRateDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_SALES_TAX_RATE_BY_STATE_SQL =
            "select * from sales_tax_rate where state = ?";

    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Not sure if this is correct
    @Override
    public SalesTaxRate getSalesTaxRateByState(String state) {

        try {

            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_BY_STATE_SQL, this::mapRowToAlbum, state);

        } catch (EmptyResultDataAccessException e) {
            //Input validation as well as error handling
            return null;

        }
    }

    private SalesTaxRate mapRowToAlbum(ResultSet rs, int rowNum) throws SQLException {

        SalesTaxRate salesTaxRate = new SalesTaxRate();

        // Can I take in state and output rate here?
        salesTaxRate.setRate(rs.getBigDecimal("rate"));
        salesTaxRate.setState(rs.getString("state"));

        return salesTaxRate;
    }
}
