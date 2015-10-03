/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sesssions;

import java.sql.SQLException;
import javax.ejb.Local;

/**
 *
 * @author Hau
 */
@Local
public interface LoginSessionBeanLocal {

    boolean checkLogin(String username, String password) throws SQLException;

    java.util.List<sample.user.UserDTO> searchByLastName(String lastname) throws SQLException ;
    
}
