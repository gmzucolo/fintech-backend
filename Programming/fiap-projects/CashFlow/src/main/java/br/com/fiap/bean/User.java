package br.com.fiap.bean;

public class User {

    private int idUser;
    private String nameUser;
    private Long cpfUser;
    private String emailUser;

    public User() {	
    	super();
    }

    public User(int idUser, String nameUser, Long cpfUser, String emailUser) {
    	super();
        this.setIdUser(idUser);
        this.setNameUser(nameUser);
        this.setCpfUser(cpfUser);
        this.setEmailUser(emailUser);
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Long getCpfUser() {
        return cpfUser;
    }

    public void setCpfUser(Long cpfUser) {
        this.cpfUser = cpfUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

}
