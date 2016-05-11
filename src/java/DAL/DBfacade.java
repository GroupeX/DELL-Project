package DAL;

import DOMAIN.Login;
import DOMAIN.Proposal;
import DOMAIN.Poe;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import static javax.xml.ws.soap.AddressingFeature.ID;

public  class DBfacade
{

    private ProposalMapping mapping;
    private Connection con;
    //== Singleton start
    private static DBfacade instance;

    private DBfacade() 
    {
        mapping = new ProposalMapping();
        con = new DBconnector().getConnection();  // the connection will be released upon program 
        // termination by the garbage collector		  
    }

    public static DBfacade getInstance() 
    {
        if (instance == null) {
            instance = new DBfacade();
        }
        return instance;
    }

    public Collection<Proposal> listPropasal() {
        return mapping.getAllPropasals(con);
    }

    public Proposal findPropasal(String id) {
        return mapping.getPropasal(con, id); 
    }

    public Proposal createProposal(Proposal p) {
        mapping.CreateNewPropasal(p, con);
        return p;
    }

    public Boolean changeProposalStatus(String id, String status) {
        return mapping.changeProposalStatus(id, status, con);
    }

    public Login CheckLogin(String usern, String passw) {
        return mapping.checkLogin(usern, passw, con);
    }
    
    public Collection<Proposal> listPartnerPropasal(String s) {
        return mapping.getOnlyPartnerPropasals(s, con);
    }
    
    public Collection<Proposal> DeleteProposal(String prop_id) {
        return mapping.DeleteProposalById(prop_id, con);
    }
    
    public Collection<Proposal> listPartnerAcceptedPropasals(String s) {
        return mapping.getOnlyPartnerAcceptedPropasals(s,con);
    }
    
    public Collection<Proposal> listAcceptedPropasals() {
        return mapping.getOnlyAcceptedPropasals(con);
    }
    
    public Poe uploadPoe(Poe p) {
        mapping.UploadPoe(p, con);
        return p;
    }
    
    public Collection<Poe> listProposalPoe(String s) {
        return mapping.getProposalPOE(s, con);
    }
    
    public Poe findPoe(String id) {
        return mapping.getPoe(con, id); 
    }
    
}