package com.epam.re.daol.interfaces;

import com.epam.re.entity.OnmEntity;

import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 27.12.2015
 */
public interface OnmDAO {

    OnmEntity findOnmByAddress(String address);

    List<OnmEntity> findOnmByFiliaId(Integer filiaId);

}
