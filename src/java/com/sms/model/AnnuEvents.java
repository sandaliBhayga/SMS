/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

/**
 *
 * @author lkfaswuser2
 */
public class AnnuEvents {
     private String indexNo;
    private String name;
    private String date;
    private String venue;
    private String remark;
    private String location;
    private String type;
    private String university;

    public AnnuEvents(String name, String date, String venue, String remark, String location, String type, String university) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.remark = remark;
        this.location = location;
        this.type = type;
        this.university = university;
    }

    public AnnuEvents(String indexNo, String name, String date, String venue, String remark, String location, String type, String university) {
        this.indexNo = indexNo;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.remark = remark;
        this.location = location;
        this.type = type;
        this.university = university;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

   

    
    
    
}
