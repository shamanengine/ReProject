package com.epam.re.daol.interfaces;

import com.epam.re.entity.FiliaEntity;

import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 22.12.2015.
 */

/**
 * DAO interface to access filia entity representation
 *
 * @see com.epam.re.entity.FiliaEntity
 */
public interface FiliaDAO {

    /**
     * Finds all filias
     *
     * @return {@code List} of filias
     */
    List<FiliaEntity> findAll();

    /**
     * Finds filia entity representation by its name
     *
     * @param filiaName name of the filia
     * @return {@code FiliaEntity}, filia entity representation
     */
    FiliaEntity findFiliaByName(String filiaName);

}
