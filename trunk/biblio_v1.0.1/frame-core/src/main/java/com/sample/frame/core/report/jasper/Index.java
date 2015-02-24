/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.frame.core.report.jasper;

/**
 *
 * @author ECHOUPE
 */
public class Index {

    private String nomIndex = null;
    private Integer numPageIndex = null;
    private String typeIndex = null;
	   
    public Index(String nomIndex, Integer numPageIndex, String typeIndex) {
	      this.nomIndex = nomIndex;
	      this.numPageIndex = numPageIndex;
	      this.typeIndex = typeIndex;
    }

    public String getNomIndex(){
        return this.nomIndex;
    }

    public Integer getNumPageIndex(){
	return this.numPageIndex;
    }
	   
    public String getTypeIndex() {
	return this.typeIndex;
    }	   
}