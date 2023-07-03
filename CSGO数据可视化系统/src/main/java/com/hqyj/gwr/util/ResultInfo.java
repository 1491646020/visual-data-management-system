package com.hqyj.gwr.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    private Integer code;
    private String msg;
    private Object data;
}
