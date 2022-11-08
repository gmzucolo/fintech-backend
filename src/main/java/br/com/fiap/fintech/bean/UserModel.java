package br.com.fiap.fintech.bean;

public class UserModel {

    private int idUser;
    private String nameUser;
    private Long cpfUser;
    private String emailUser;
    private int phoneUser;
    private int ddiUser;
    private int dddUser;

    public UserModel() {	
    }

    public UserModel(int idUser, String nameUser, Long cpfUser, String emailUser, int phoneUser, int ddiUser, int dddUser) {
        this.setIdUser(idUser);
        this.setNameUser(nameUser);
        this.setCpfUser(cpfUser);
        this.setEmailUser(emailUser);
        this.setPhoneUser(phoneUser);
        this.setDdiUser(ddiUser);
        this.setDddUser(dddUser);
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

    public int getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(int phoneUser) {
        this.phoneUser = phoneUser;
    }

    public int getDddUser() {
        return dddUser;
    }

    public void setDddUser(int dddUser) {
        this.dddUser = dddUser;
    }

    public int getDdiUser() {
        return ddiUser;
    }

    public void setDdiUser(int ddiUser) {
        this.ddiUser = ddiUser;
    }
}
