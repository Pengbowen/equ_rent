package com.bob.equrent.entity;

import lombok.Data;

@Data
public class ResponsePageData extends ResponseData {
    private int count;
    private int pageNum;
    private int pageSize;
}
