
package DAL;

import DOMAIN.Login;
import DOMAIN.Proposal;
import DOMAIN.Poe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProposalMapping {

    public boolean CreateNewPropasal(Proposal prop, Connection con) {
        int rowsInserted = 0;

        String SQLString1
                = "insert into PROPOSALS (prop_id, prop_title, prop_text, prop_budget, prop_status, fk_partner_id) values (SEQ_PROPOSALS.NEXTVAL, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            System.out.println("Mapping - 1");
            //== insert tuple
            statement = con.prepareStatement(SQLString1);
            
            statement.setString(1, prop.getTitle());
            statement.setString(2, prop.getText());
            statement.setInt(3, Integer.parseInt(prop.getBudget()));
            statement.setString(4, prop.getStatus());
            statement.setString(5, prop.getFk_partner_id());

            System.out.println("Mapping - 2");

            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
    

    public Proposal getPropasal(Connection con, String id) {

        Proposal returnProp = new Proposal("", "", "", "", "", "");

        String SQLString1
                = "select * from PROPOSALS where PROP_ID = ?";

        PreparedStatement statement = null;

        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, Integer.parseInt(id));

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnProp = new Proposal(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4) + "", rs.getString(5), rs.getString(6));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return returnProp;
    }

    public Collection<Proposal> getAllPropasals(Connection con) {

        Collection<Proposal> proposals = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM proposals INNER JOIN partners ON proposals.fk_partner_id=partners.partner_id ORDER BY prop_id DESC";

        PreparedStatement statement = null;

        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                proposals.add(new Proposal(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getInt(4) + "", rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return proposals;

    }
    
    public Boolean changeProposalStatus(String id, String status, Connection con) {
        int rowsInserted = 0;

        String SQLString1
                = "UPDATE Proposals SET PROP_STATUS = ? WHERE PROP_ID = ?";
        
        
        PreparedStatement statement = null;

        try {
            //== insert tuple
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, status);
            statement.setInt(2, Integer.parseInt(id));
            rowsInserted = statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    
    //login checker
    public Login checkLogin(String usern, String passw, Connection con) {

        Login login = new Login("", "", 0, 0);

        String SQLString1
                = "select * from users where user_username='" + usern + "' and user_password='" + passw + "'";

        PreparedStatement statement = null;

        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                login = new Login(usern, passw, rs.getInt("fk_status_id"), rs.getInt("fk_partner_id"));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return login;

    }
    
    
    //til partner view, viser kun de proposals som svarer til session partner_id
    public Collection<Proposal> getOnlyPartnerPropasals(String fk_pid, Connection con) {

        Collection<Proposal> proposals = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM PROPOSALS WHERE fk_partner_id = ? ORDER BY prop_id DESC";

        PreparedStatement statement = null;
        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);
            
            statement.setString(1, fk_pid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                proposals.add(new Proposal(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getInt(4) + "", rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return proposals;

    }
    
    //når dell vælger at slette en proposal, unikt id bliver sendt igennem dets servlet
    public Collection<Proposal> DeleteProposalById(String propID, Connection con) {

        Collection<Proposal> proposals = new ArrayList<>();

        String SQLString1
                = "DELETE FROM proposals WHERE prop_id = ?";

        PreparedStatement statement = null;
        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);
            
            statement.setString(1, propID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                proposals.add(new Proposal(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getInt(4) + "", rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return proposals;

    }
    
    //viser kun proposals som er accepteret og som er dermed en kampagne for PARTNER
    public Collection<Proposal> getOnlyPartnerAcceptedPropasals(String fk_pid, Connection con) {

        Collection<Proposal> proposals = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM PROPOSALS WHERE prop_status = ? AND  fk_partner_id = ? ORDER BY prop_id DESC";

        PreparedStatement statement = null;
        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);
            
            statement.setString(1, "1");
            statement.setString(2, fk_pid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                proposals.add(new Proposal(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getInt(4) + "", rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return proposals;

    }    
    
    //viser kun proposals som er accepteret og som er dermed en kampagne for Dell
    public Collection<Proposal> getOnlyAcceptedPropasals(Connection con) {

        Collection<Proposal> proposals = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM PROPOSALS WHERE prop_status = ? ORDER BY prop_id DESC";

        PreparedStatement statement = null;
        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);
            
            statement.setString(1, "1");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                proposals.add(new Proposal(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getInt(4) + "", rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return proposals;

    }
    
    public boolean UploadPoe(Poe poe, Connection con) {
        int rowsInserted = 0;

        String SQLString1
                = "insert into poe (poe_id, poe_link, poe_status, fk_prop_id) values (SEQ_POE.NEXTVAL, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            System.out.println("PoeMApping - 1");
            //== insert tuple
            statement = con.prepareStatement(SQLString1);
            
            statement.setString(1, poe.getPoe_link());
            statement.setString(2, poe.getPoe_status());
            statement.setString(3, poe.getFk_prop_id());

            System.out.println("PeoMApping - 2");

            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
    
    //get poe by proposal id
    public Collection<Poe> getProposalPOE(String fk_pid, Connection con) {

        Collection<Poe> poe = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM poe WHERE fk_prop_id = ? ORDER BY poe_id DESC";

        PreparedStatement statement = null;
        try {
            //Try to get the specified record
            statement = con.prepareStatement(SQLString1);
            
            statement.setString(1, fk_pid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                poe.add(new Poe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally 
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return poe;

    }
    
    public Poe getPoe(Connection con, String id) {

        Poe returnPoe = new Poe("", "", "", "");

        String SQLString1
                = "select * from Poe where fk_prop_id = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, Integer.parseInt(id));

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnPoe = new Poe(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally 
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in Mapping");
                System.out.println(e.getMessage());
            }
        }

        return returnPoe;
    }
    

}
