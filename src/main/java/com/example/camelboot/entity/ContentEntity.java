package com.example.camelboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rao QingLong
 * @date 2022/5/25 20:03
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContentEntity {
    private String title;
    private String content;
}
