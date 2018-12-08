package com.parking.lot.service;

import com.parking.lot.FeeStructure;

import java.util.List;

public interface FeeServiceInterface {
    List<FeeStructure> getFeeStructure();

    void updateFeeStructure(FeeStructure feeStructure);
}
