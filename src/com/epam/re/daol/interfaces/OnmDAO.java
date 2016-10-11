package com.epam.re.daol.interfaces;

import com.epam.re.entity.OnmEntity;

import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 27.12.2015
 */

/**
 * DAO interface to access Onm (real estate object) entity representation
 *
 * @see com.epam.re.entity.OnmEntity
 */
public interface OnmDAO {
    /**
     * Searches for Onm (real estate object) entity by its address
     *
     * @param address address y which to search
     * @return {@code OnmEntity}, real estate object entity representation with such address
     */
    OnmEntity findOnmByAddress(String address);

    /**
     * Searches for list of Onm (real estate object) entities
     * by id of the filia in which they are registered
     *
     * @param filiaId id of the filia (region) to search onm in
     * @return List of eal estate object entity representation registered in this filia
     */
    List<OnmEntity> findOnmByFiliaId(Integer filiaId);
}
