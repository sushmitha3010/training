package com.model;

public class Tracking {

	//Declaring Variable
		private Integer locationId;
		private String locationName;
		private String status;
		
		
		//Default Parameter
		public Tracking() {
			
		}


		//Parameterized Constructor
		public Tracking(Integer locationId, String locationName, String status) {
			super();
			this.locationId = locationId;
			this.locationName = locationName;
			this.status = status;
		}


		
		//Generate Getters and Setters
		public Integer getLocationId() {
			return locationId;
		}


		public void setLocationId(Integer locationId) {
			this.locationId = locationId;
		}


		public String getLocationName() {
			return locationName;
		}


		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		//To String
		@Override
		public String toString() {
			return "Tracking [locationId=" + locationId + ", locationName=" + locationName + ", status=" + status + "]";
		}
		
	}

	
	
	