package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.ProcessingFee;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL =
            "select * from processing_fee where product_type = ?";

    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }


    @Override
    public ProcessingFee getProcessingFeeByProductType(String productType) {
        try {

            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL, this::mapRowToAlbum, productType);

        } catch (EmptyResultDataAccessException e) {
            // Fingers crossed!
            return null;
        }
    }

    private ProcessingFee mapRowToAlbum(ResultSet rs, int rowNum) throws SQLException {

        ProcessingFee processingFee = new ProcessingFee();

        // can I just take in product type and output fee?
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
