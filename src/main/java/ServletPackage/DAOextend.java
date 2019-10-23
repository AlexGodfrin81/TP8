/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import simplejdbc.DAO;
import simplejdbc.DAOException;


/**
 *
 * @author pedago
 */
public class DAOextend extends DAO {
    
    public DAOextend(DataSource dataSource) {
        super(dataSource);
    }
    
    public List<String> GetState() throws DAOException{
        String sql = "SELECT DISTINCT(STATE) FROM CUSTOMER";
        List<String> result = new LinkedList<>();
        try (   Connection connection = myDataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) 
                {
                    while (rs.next()) {
                        result.add(rs.getString("STATE"));
                    }
		} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return result;
    }
    
}
