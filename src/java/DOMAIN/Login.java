
package DOMAIN;

public class Login {
    
    String username;
    String password;
    int statusId;
    int partnerId;

    public Login(String username, String password, int statusId, int partnerId) {
        this.username = username;
        this.password = password;
        this.statusId = statusId;
        this.partnerId = partnerId;
    }

    public Login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }
    
    
}
