
package com.codingassignment.wrs.modelresponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Rain implements Serializable
{

    private Double _1h;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8796081804912944679L;

    public Double get1h() {
        return _1h;
    }

    public void set1h(Double _1h) {
        this._1h = _1h;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Rain [_1h=" + _1h + ", additionalProperties=" + additionalProperties + "]";
	}


}
