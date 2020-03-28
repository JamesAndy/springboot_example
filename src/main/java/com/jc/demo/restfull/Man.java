/**
 * 檔案描述：Restfull 範例，模擬資料庫
 */
package com.jc.demo.restfull;

import lombok.Data;

@Data
public class Man {
    private Integer id;

    private String name;

    private Integer age;

    private String speakContent;

}
