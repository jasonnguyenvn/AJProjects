/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lab9.sessions;

import java.sql.SQLException;
import javax.ejb.Remote;

/**
 *
 * @author Hau
 */
@Remote
public interface UserSessionBeanRemote  {

    boolean checkLogin(String username, String password) throws SQLException;
    
}
