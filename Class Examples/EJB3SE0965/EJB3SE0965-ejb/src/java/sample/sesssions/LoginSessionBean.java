/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sesssions;

import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import sample.user.UserDAO;

/**
 *
 * @author Hau
 */
@Stateless
public class LoginSessionBean implements LoginSessionBeanLocal, LoginSessionBeanRemote {
    @Resource(name = "dataSource", mappedName = "java:UserTbJNDI")
    private DataSource dataSource;
    
    
    
    @Override
    public boolean checkLogin(String username, String password)
            throws SQLException{
        UserDAO dao = new UserDAO();
        
        return dao.checkLogin(username, password, dataSource);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public java.util.List<sample.user.UserDTO> searchByLastName(String lastname) 
            throws SQLException {
        UserDAO dao = new UserDAO();
        
        dao.search(lastname, dataSource);
         
        return dao.getUserList();
    }
    
    
}
