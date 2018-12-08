package com.parking.lot.service;

import com.parking.lot.FeeStructure;
import com.parking.lot.dao.FeeDao;

import java.util.List;

public class FeeService implements FeeServiceInterface {

    private FeeDao feeDao;
    FeeStructure fs = new FeeStructure();


    public FeeService(FeeDao feeDao) {

        this.feeDao = feeDao;
    }

    @Override
    public List<FeeStructure> getFeeStructure() {

        return feeDao.getFeeStructure();
    }

    @Override
    public void updateFeeStructure(FeeStructure feeStructure) {

        fs.setTime_info(feeStructure.getTime_info());
        fs.setStart(feeStructure.getStart());
        fs.setEnd(feeStructure.getEnd());
        fs.setPrice(feeStructure.getPrice());
    }


}
