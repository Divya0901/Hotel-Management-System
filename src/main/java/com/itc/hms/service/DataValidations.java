package com.itc.hms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DataValidations {

    private static Logger logger = LoggerFactory.getLogger(DataValidations.class);

    public boolean validateMobileNumber(Long mobileNumber){
//        Pattern pattern = compile("^[6789]\\d{9}$");
//        Matcher matcher = pattern.matcher(mobileNumber.toString());

        String checkMobileNumber = mobileNumber.toString();
        if(checkMobileNumber.length() == 10 && checkMobileNumber.startsWith("6") || checkMobileNumber.startsWith("7")
                || checkMobileNumber.startsWith("8") || checkMobileNumber.startsWith("9"))
            return true;

        return false;

    }

    public boolean validateEmailId(String emailId){
        String part2 = "gmail.com";
        if(!emailId.contains("@"))
            return false;
        String[] fi = emailId.split("@", 2);
        String firstPart = fi[0];
        String secondPart = fi[1];
        StringBuffer aplha = new StringBuffer(), num = new StringBuffer();

                     if(secondPart.equals(part2) && (!firstPart.endsWith("."))) {
            for(int i = 0; i < firstPart.length(); i++){

                if(Character.isAlphabetic(firstPart.charAt(i)))
                    aplha.append(i);
                else if(Character.isDigit(firstPart.charAt(i)))
                    num.append(i);
            }
        }
        if(!aplha.isEmpty() && !num.isEmpty())
            return true;
        return false;
    }

}
