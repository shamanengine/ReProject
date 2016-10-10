package com.epam.re.daol.interfaces;

import com.epam.re.entity.FiliaEntity;

import java.util.List;

/**
 * @author Raccoon
 * @version 1.0, 22.12.2015.
 */
public interface FiliaDAO {

    List<FiliaEntity> findAll();

    FiliaEntity findFiliaByName(String filiaName);

}
