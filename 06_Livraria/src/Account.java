public class Account {
    private String emailAddress;
    private long id;
    private String password;
    private long idTemp;
    private String passwordTemp;

    public boolean verifyPassword()
    {
        return password.equals(passwordTemp);
    }

    public boolean validateLogin(long ID, String password)
    {
        idTemp = ID;
        passwordTemp = password;
        return (validateLogin() && verifyPassword());
    }

    public boolean validateLogin()
    {
        return (id==idTemp);
    }

    /**
     * @return String return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
