package com.parking.lot.service;

import com.parking.lot.FeeStructure;
import com.parking.lot.dao.LotDao;

import java.util.List;

public class FeeStructureService {

    private LotDao lotDao;
    FeeStructure fs = new FeeStructure();


    public FeeStructureService(LotDao lotDao) {

        this.lotDao = lotDao;
    }

    public List<FeeStructure> getFeeStructure() {

        return lotDao.getFeeStructure();
    }

    public void updateFeeStructure(FeeStructure feeStructure) {

        fs.setTime(feeStructure.getTime());
        fs.setStart(feeStructure.getStart());
        fs.setEnd(feeStructure.getEnd());
        fs.setPrice(feeStructure.getPrice());
    }

}
