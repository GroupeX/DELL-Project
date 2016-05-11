
package DOMAIN;

import DAL.DBfacade;
import java.util.Collection;
import DOMAIN.Proposal;
import DOMAIN.Poe;

public class Controller 
{
    private DBfacade dbf;

    public Controller()
    {
        dbf = DBfacade.getInstance();
      
    }
   
    public Collection<Proposal> listPropasal() {
        return dbf.listPropasal();
    }
    
    public Proposal findPropasal(String id) {
        return dbf.findPropasal(id);
    }

    public Proposal createProposal(Proposal p) {
        return dbf.createProposal(p);
    }

    public Boolean changeProposalStatus(String id, String status) {
        return dbf.changeProposalStatus(id, status);
    }
    
    public Login CheckLogin(String usern, String passw) {
        return dbf.CheckLogin(usern, passw);
    }
    
    public Collection<Proposal> listPartnerPropasal(String s) {
        return dbf.listPartnerPropasal(s);
    }
    
    public Collection<Proposal> DeleteProposal(String prop_id) {
        return dbf.DeleteProposal(prop_id);
    }
    
    public Collection<Proposal> listPartnerAcceptedPropasals(String s) {
        return dbf.listPartnerAcceptedPropasals(s);
    }
    
    public Collection<Proposal> listAcceptedPropasals() {
        return dbf.listAcceptedPropasals();
    }
    
    public Poe uploadPoe(Poe p) {
        return dbf.uploadPoe(p);
    }

    public Collection<Poe> listProposalPoe(String s) {
        return dbf.listProposalPoe(s);
    }
    
    public Poe findPoe(String id) {
        return dbf.findPoe(id);
    }
    
      
}