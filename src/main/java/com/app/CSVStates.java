package com.app;

public class CSVStates {
	 private String srNo;
	    private String stateName;
	    private String tin;
	    private String stateCode;

	    public CSVStates(String srNo, String stateName, String tin, String stateCode) {
	        this.srNo = srNo;
	        this.stateName = stateName;
	        this.tin = tin;
	        this.stateCode = stateCode;
	    }

	    
	    @Override
	    public String toString() {
	        return "CSVStates [SrNo=" + srNo + ", StateName=" + stateName + ", TIN=" + tin + ", StateCode=" + stateCode + "]";
	    }

  

  
}
