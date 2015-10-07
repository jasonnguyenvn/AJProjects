/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sessions;

import java.util.List;
import javax.ejb.Local;
import sample.entity.Users;

/**
 *
 * @author Hau
 */
@Local
public interface UserSessionBeanLocal {

    boolean checkLogin(String username, String password);

    java.util.List searchLikeName(String username);

    boolean deleteUser(String pk);

    boolean updateUser(String pk, String password, boolean role);

    boolean insertUser(String pk, String username, String password, String lastname, boolean role);


    
}
