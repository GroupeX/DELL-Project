
package DOMAIN;

public class Poe {
    private String poe_id;
    private String fk_prop_id;
    private String poe_link;
    private String poe_status;

    public Poe( String poe_id, String poe_link, String poe_status, String fk_prop_id) {
        this.fk_prop_id = fk_prop_id;
        this.poe_link = poe_link;
        this.poe_status = poe_status;
        this.poe_id = poe_id;
    }

    public String getPoe_id() {
        return poe_id;
    }

    public void setPoe_id(String poe_id) {
        this.poe_id = poe_id;
    }

    public String getFk_prop_id() {
        return fk_prop_id;
    }

    public void setFk_prop_id(String fk_prop_id) {
        this.fk_prop_id = fk_prop_id;
    }

    public String getPoe_link() {
        return poe_link;
    }

    public void setPoe_link(String poe_link) {
        this.poe_link = poe_link;
    }
    
    public String getPoe_status() {
        return poe_status;
    }

    public void setPoe_status(String poe_status) {
        this.poe_status = poe_status;
    }

    
    
}
