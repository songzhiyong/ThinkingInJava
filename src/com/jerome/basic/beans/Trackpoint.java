/**
 * Trackpoint.java
 * com.jerome.basic.beans
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2014-1-17 		Administrator
 *
 * Copyright (c) 2014, JEROME All Rights Reserved.
 */

package com.jerome.basic.beans;

import java.util.Date;

/**
 * ClassName:Trackpoint Function: TODO ADD FUNCTION
 * 
 * @author Administrator
 * @version
 * @Date 2014-1-17 下午2:47:44
 * 
 * @see
 */
public class Trackpoint {
	double lat;
	double lng;
	double ele;
	Date date;

	public Trackpoint() {
		super();
	}

	public Trackpoint(double lat, double lng, double ele, Date date) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.ele = ele;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Trackpoint [lat=" + lat + ", lng=" + lng + ", ele=" + ele
				+ ", date=" + date + "]";
	}

}
