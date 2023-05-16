package com.glsib.soapweb.websoap;

import java.util.List;

public interface IService {

    // Pour Consommation Service Soap
    public int  getAddResult(int intA, int intB);
    public int getSubResult(int intA, int intB);

    public int  getMulResult(int intA, int intB);
    public int  getDivResult(int intA, int intB);

    // Pour Consommation API Rest

    List<Object> getAllUsers();

}
