/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka.v1_0.kyc.information.exchange.exceptions;

/**
 *
 * @author ceowit
 */
public class KycInformationApiException extends Exception{
    
    private final String message;

    public KycInformationApiException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
