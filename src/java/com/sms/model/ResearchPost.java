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
public class ResearchPost {

    private String indexNo;
    private String heading;
    private String description;
    private String fileName;

    public ResearchPost() {
    }
    
    

    public ResearchPost(String heading, String description, String fileName) {
        this.heading = heading;
        this.description = description;
        this.fileName = fileName;
    }

    public ResearchPost(String indexNo, String heading, String description, String fileName) {
        this.indexNo = indexNo;
        this.heading = heading;
        this.description = description;
        this.fileName = fileName;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
