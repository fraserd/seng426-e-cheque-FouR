/*
 * EChequeRegisteration.java
 *
 * Created on May 19, 2007, 7:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Saad
 */
package eCheque;

import java.io.Serializable;

public class EChequeRegistration implements Serializable {
    
    private String bankName;
    private String bankAddress;
    private String accountNumber;
    private String clientName;
    private String eWalletLocation;
    private int userNameHash;
    private int passwordHash;
    
    /** Creates a new instance of EChequeRegisteration */
    public EChequeRegistration() {
    }
    
    public void setBankName(String bName){
        bankName = bName;
    }

       
    public void setBankAddress(String URL){
         bankAddress = URL;
    }
    
    public void setAccountNumber(String account){
        accountNumber = account;
    }
    
    public void setClientName(String cName){
        clientName = cName;
    }
    
    public void setEWalletLocation(String path){
        eWalletLocation = path;
    }
    
    public void setUsername(int hashValue){
        userNameHash = hashValue;
    }
    
    public void setPassword(int hashValue){
        passwordHash = hashValue;
    }
    
    public String getBankName(){
        return bankName;
    }

    public String getBankAddress(){
         return bankAddress;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public String getClientName(){
        return clientName;
    }
    
    public String getEWalletLocation(){
        return eWalletLocation;
    }
    
    public int getUsername(){
        return userNameHash;
    }
    
    public int getPassword(){
        return passwordHash;
    }
    
}