package com.example.camelboot.routes;


import com.example.camelboot.processor.BlogProcessor;
import com.example.camelboot.processor.ContentProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;


/**
 * @author Rao QingLong
 * @date 2022/5/25 20:15
 */
@Component
public class AggregationRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);


        from("direct:aggregation")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .process(new BlogProcessor())
                .toD("http://127.0.0.1:8080/blog")
                .to("jslt:demo.jslt")
                .process(new ContentProcessor())
                .toD("http://127.0.0.1:8080/content")
                .to("jslt:demo1.jslt")
                .end();

    }

}
