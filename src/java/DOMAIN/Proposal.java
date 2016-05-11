package DOMAIN;

public class Proposal {
    private String title;
    private String id;
    private String budget;
    private String text;
    private String status;
    private String fk_partner_id;

    public Proposal(String id, String title, String text, String budget, String status, String fk_partner_id) {
        this.title = title;
        this.id = id;
        this.budget = budget;
        this.text = text;
        this.status = status;
        this.fk_partner_id = fk_partner_id;
    }

    public String getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setText(String text) {
        this.text = text;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getFk_partner_id() {
        return fk_partner_id;
    }
    
    

   


  

   
}
