/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Hau
 */
public class Product {
    private String _code;
    private String _name;
    private String _description;
    private float _price;
    private String _category;
    
    public Product() { }

    public Product(String _code, String _name, String _description, float _price, String _category) {
        this._code = _code;
        this._name = _name;
        this._description = _description;
        this._price = _price;
        this._category = _category;
    }

    public String getCode() {
        return _code;
    }

    public void setCode(String _code) {
        this._code = _code;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public float getPrice() {
        return _price;
    }

    public void setPrice(float _price) {
        this._price = _price;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String _category) {
        this._category = _category;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this._code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this._code, other._code);
    }
    
    public boolean isStored(Connection conn) throws SQLException {
        String sql = "SELECT Code FROM Product WHERE Code=?";
        PreparedStatement stm = conn.prepareCall(sql);
        stm.setString(1, _code);
        
        ResultSet resultSET = stm.executeQuery();
        
        if(resultSET==null)
            return false;
        
        return resultSET.next();
    }
    
    protected boolean insertNew(Connection conn) throws SQLException {
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO Product VALUES (?, ?, ?, ?, ?)";
            stm = conn.prepareCall(sql);
            stm.setString(1, _code);
            stm.setString(2, _name);
            if(_description.equals("")||_description==null)
                stm.setNull(3,java.sql.Types.CHAR);
            else
                stm.setString(3, _description);
            stm.setString(4, ""+_price);
            if(_category.equals("")||_category==null)
                stm.setNull(5,java.sql.Types.CHAR);
            else
                stm.setString(5, _category);

            int result = stm.executeUpdate();
            if(result>0)
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(stm!=null)
                stm.close();
        }
        
        return false;
    }
    
    protected boolean update(Connection conn) throws SQLException  {
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE Product SET Name=?, Description=?, Price=?"
                        + ", Category=? WHERE Code=?";
            stm = conn.prepareCall(sql);
            stm.setString(1, _name);
            if(_description.equals("")||_description==null)
                stm.setNull(2,java.sql.Types.CHAR);
            else
                stm.setString(2, _description);
            stm.setString(3, ""+_price);
            if(_category.equals("")||_category==null)
                stm.setNull(4,java.sql.Types.CHAR);
            else
                stm.setString(4, _category);
            stm.setString(5, _code);

            int result = stm.executeUpdate();

            return result>0;
        } catch(SQLException ex) {
           ex.printStackTrace();
        } finally {
            if(stm!=null)
                stm.close();
        }
        
        return false;
        
    }
    
    public boolean save(Connection conn) throws SQLException {
        boolean isThisProudctStored = this.isStored(conn);
        if(isThisProudctStored==true)
            return false;
        // Delete this statement below because 
        // it did not follow the requirement.
        /*if(isThisProudctStored==true)
            return this.update(conn);*/
        
        return this.insertNew(conn);
    }
    
    public static Product[] loadAll(Connection conn)  throws SQLException {
        PreparedStatement stm = null;
        ResultSet resultSET = null;
        try {
            String sql = "SELECT * FROM Product ";
            stm = conn.prepareCall(sql);

            resultSET = stm.executeQuery();
            List<Product> proList = new ArrayList<>();

            while(resultSET.next()) {
                String code = resultSET.getString("Code").trim();
                String name = resultSET.getString("Name").trim();
                String preDes = resultSET.getString("Description");
                String description = "";
                if(preDes!=null)
                    description = preDes.trim();
                
                float price = resultSET.getFloat("Price");
                
                String preCat = resultSET.getString("Category");
                String category = "";
                if(preCat!=null)
                    category = preCat.trim();
                Product pro = new Product(code, name, description, price, category);

                proList.add(pro);
            }
            Product[] returnArr = new Product[proList.size()];
            returnArr = proList.toArray(returnArr);

            return returnArr;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(resultSET!=null)
                resultSET.close();
            if(stm!=null)
                stm.close();
        }
        
        return null;
    }
    
}
