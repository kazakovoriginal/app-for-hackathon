package com.novoda;

/**
 * Created by andreykazakov on 26.03.16.
 */

public class CriteriaBoolean {
        private Object criteria;
        private Boolean bool;

    public CriteriaBoolean(Object criteria, Boolean bool) {
        this.criteria = criteria;
        this.bool = bool;
    }

    public Object getCriteria() {
        return criteria;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }
}
