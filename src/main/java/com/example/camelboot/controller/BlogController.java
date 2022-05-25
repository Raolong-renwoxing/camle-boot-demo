package com.example.camelboot.controller;

import com.example.camelboot.entity.BlogEntity;
import com.example.camelboot.vo.BlogVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rao QingLong
 * @date 2022/5/25 19:48
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @PostMapping
    public BlogEntity getOne(@RequestBody BlogVO blogVO) {
        final Integer id = blogVO.getId();
        final Map<Integer, BlogEntity> stringBlogEntityHashMap = new HashMap<>(0);
        stringBlogEntityHashMap.put(1, new BlogEntity(1, "demo1"));
        stringBlogEntityHashMap.put(2, new BlogEntity(2, "demo2"));
        stringBlogEntityHashMap.put(3, new BlogEntity(3, "demo3"));
        return stringBlogEntityHashMap.get(id);

    }

}
