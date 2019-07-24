package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {

   ProcessingFee getProcessingFeeByProductType(String productType);

   //only one type of item per invoice
}
