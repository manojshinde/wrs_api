
package com.codingassignment.wrs.modelresponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FeelsLike implements Serializable
{

    private Double day;
    private Double night;
    private Double eve;
    private Double morn;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8498469730378771443L;

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }

    public Double getEve() {
        return eve;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public Double getMorn() {
        return morn;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "FeelsLike [day=" + day + ", night=" + night + ", eve=" + eve + ", morn=" + morn
				+ ", additionalProperties=" + additionalProperties + "]";
	}


}
