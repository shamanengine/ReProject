package com.epam.re.daol.interfaces;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author A.Tymchenko
 * @version 1.0, 27.12.2015
 */

/**
 * DAO interface to access Rent entity representation
 *
 * @see com.epam.re.entity.RentEntity
 */
public interface RentDAO {
    /**
     * Adds a new rent contract record
     *
     * @param userId     id of the user
     * @param onmId      id of the onm (real estate object)
     * @param contractor renting company name
     * @param square     square of rented area
     * @param rent       price per 1 sq.m. per month including VAT by the contract
     * @param startD     date the lease starts by the contract
     * @param endD       date the lease ends by the contract
     * @throws Exception
     */
    void addRent(
            Integer userId, Integer onmId, String contractor,
            BigDecimal square, BigDecimal rent, Date startD, Date endD)
            throws Exception;

}
