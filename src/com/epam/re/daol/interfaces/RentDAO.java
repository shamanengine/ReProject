package com.epam.re.daol.interfaces;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author A.Tymchenko
 * @version 1.0, 27.12.2015
 */
public interface RentDAO {

    void addRent(
            Integer userId, Integer onmId, String contractor,
            BigDecimal square, BigDecimal rent, Date startD, Date endD)
            throws Exception;

}
