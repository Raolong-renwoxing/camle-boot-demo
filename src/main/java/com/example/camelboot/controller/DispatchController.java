package com.example.camelboot.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

/**
 * @author Rao QingLong
 * @date 2022/5/25 20:10
 */
@RestController
@RequestMapping("/openapi/blog")
public class DispatchController {

    final ProducerTemplate producerTemplate;

    public DispatchController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @GetMapping("/{id}")
    public DeferredResult<String> getOne(@PathVariable String id) {
        final DeferredResult<String> deferredResult = new DeferredResult<>();
        final CompletableFuture<Object> future = producerTemplate.asyncRequestBody("direct:aggregation", id);
        future.whenCompleteAsync((response, exception) -> {
            deferredResult.setResult((String) response);
        });
        return deferredResult;
    }

}
