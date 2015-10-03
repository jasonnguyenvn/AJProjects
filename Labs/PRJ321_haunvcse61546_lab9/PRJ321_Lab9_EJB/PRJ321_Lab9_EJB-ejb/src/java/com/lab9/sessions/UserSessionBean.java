/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lab9.sessions;

import com.lab9.account.AccountDAO;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Hau
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal, UserSessionBeanRemote {
    @Resource(name = "dataSource", mappedName = "java:AcountTbJNDI")
    private DataSource dataSource;
    

    @Override
    public boolean checkLogin(String username, String password)
        throws SQLException { 
        AccountDAO dao = new AccountDAO();
        
        return dao.checkLogin(username, password, dataSource);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
