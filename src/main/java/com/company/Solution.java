package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    
    long maxAmount = 0;
    HashMap<String, Temp> callsMap = new HashMap<>();

    public int solution(String S) {
        List<String> splitPhones = Arrays.asList(S.split("\n"));
        splitPhones.forEach(t -> {
            String[] phoneInfo = t.split(",");
            if (callsMap.containsKey(phoneInfo[1])) {
                Temp temp = callsMap.get(phoneInfo[1]);
                temp.calculateBill(phoneInfo[0]);
                callsMap.put(phoneInfo[1], temp);
            } else {
                Temp value = new Temp(t);
                value.calculateBill(phoneInfo[0]);
                callsMap.put(phoneInfo[1], value);
            }
        });

        callsMap.keySet().forEach(t -> {
            Temp temp = callsMap.get(t);
            long payingSummery = temp.getPayingSummery();
            if (payingSummery > maxAmount) {
                maxAmount = payingSummery;
            }
        });
        return Integer.parseInt(String.valueOf(maxAmount));
    }
}

class Temp {

    String phone;
    long timeInSecond;
    String phoneDetails;
    long payingSummery = 0;

    public Temp(String phoneDetails) {
        this.phoneDetails = phoneDetails;
        timeInSecond = convert(phoneDetails.split(",")[0]);
    }

    public long getPayingSummery() {
        return payingSummery;
    }

    public long convert(String phoneDuration) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = dateFormat.parse(phoneDuration);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime() / 1000L;
    }

    public void calculateBill(String seconds) {
        long convert = convert(seconds);
        if (convert < 300) {
            long l = convert * 3;
            payingSummery += l;
        } else {
            long fullMinute = convert / 60;
            long partOfMinute = convert % 60;
            if (partOfMinute > 0) {
                fullMinute += 1;
            }
            payingSummery += fullMinute * 150;
        }
    }
}