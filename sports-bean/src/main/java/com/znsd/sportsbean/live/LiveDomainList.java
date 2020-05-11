package com.znsd.sportsbean.live;

import java.io.Serializable;
import java.util.List;

public class LiveDomainList implements Serializable {
    private List<LiveDomain> rows;
    private Integer total;

    public LiveDomainList() {
    }

    public LiveDomainList(List<LiveDomain> rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    public List<LiveDomain> getRows() {
        return rows;
    }

    public void setRows(List<LiveDomain> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "LiveDomainList{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
