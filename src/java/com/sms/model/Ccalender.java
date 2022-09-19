/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.io.Serializable;

/**
 *
 * @author lkfaswuser2
 */
public class Ccalender implements Serializable {

      private String indexNo;
    private String title;
    private String start;
    private String end;

    public Ccalender(String title, String start, String end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }
    
      public Ccalender(String indexNo,String title, String start, String end) {
        this.indexNo = indexNo;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }
      
      

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
      return title+","+start+","+end;
    }
    
    

}
