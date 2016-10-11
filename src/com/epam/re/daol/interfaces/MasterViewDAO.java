package com.epam.re.daol.interfaces;

import com.epam.re.dto.MasterView;
import com.epam.re.entity.UserEntity;

import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 23.12.2015
 */

/**
 * DAO interface to access master view representation
 *
 * @see com.epam.re.dto.MasterView
 */
public interface MasterViewDAO {

    /**
     * Finds list of rent view records of concrete user
     *
     * @param userEntity user, for whom to search data
     * @return {@code List} of master view records,
     * that registered in the same filia as the user
     */
    List<MasterView> rentViewByUser(UserEntity userEntity);

    /**
     * Finds list of rent view records of all users
     *
     * @return {@code List} of master view records,
     * that registered in all filias
     */
    List<MasterView> rentViewAll();

}
