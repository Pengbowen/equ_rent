package com.bob.equrent.entity;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class ResponsePageData extends ResponseData {
    private long count;
    private int pageNum;
    private int pageSize;
    private int totalPages;
    public ResponsePageData (Page<?> t){
        this.count = t.getTotalElements();
        this.pageSize = t.getSize();
        this.data = t.getContent();
    }
}
