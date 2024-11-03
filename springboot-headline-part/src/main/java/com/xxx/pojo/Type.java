package com.xxx.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName news_type
 */

@Data
public class Type implements Serializable {

    @TableId
    private Integer tid;

    private String tname;

    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}