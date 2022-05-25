package com.example.camelboot.controller;

import com.example.camelboot.entity.BlogEntity;
import com.example.camelboot.entity.ContentEntity;
import com.example.camelboot.vo.ContentVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rao QingLong
 * @date 2022/5/25 20:01
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @PostMapping
    public ContentEntity getOne(@RequestBody ContentVO contentVO) {
        final String title = contentVO.getTitle();
        final Map<String, ContentEntity> contentMap = new HashMap<>(0);
        contentMap.put("demo1", new ContentEntity("demo1", "test demo1 content"));
        contentMap.put("demo2", new ContentEntity("demo2", "test demo2 content"));
        contentMap.put("demo3", new ContentEntity("demo3", "test demo3 content"));
        return contentMap.get(title);
    }


}
