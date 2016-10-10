package com.epam.re.daol.interfaces;

import com.epam.re.dto.MasterView;
import com.epam.re.entity.UserEntity;

import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 23.12.2015
 */
public interface MasterViewDAO {

    List<MasterView> rentViewByUser(UserEntity userEntity);

    List<MasterView> rentViewAll();

}
