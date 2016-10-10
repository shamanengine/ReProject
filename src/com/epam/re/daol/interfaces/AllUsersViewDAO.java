package com.epam.re.daol.interfaces;

import com.epam.re.dto.AllUsersView;

import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 23.12.2015
 */
public interface AllUsersViewDAO {

    List<AllUsersView> findAll();

}
