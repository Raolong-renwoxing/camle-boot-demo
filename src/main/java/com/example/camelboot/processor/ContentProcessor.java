package com.example.camelboot.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rao QingLong
 * @date 2022/5/26 0:31
 */
@Component
public class ContentProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> input = new HashMap<>(1);
        String body = exchange.getMessage().getBody(String.class);
        Map m = mapper.readValue(body, Map.class);
        String title = (String) m.get("title");
        Integer id = (Integer) m.get("id");
        exchange.getMessage().setHeader("id", id);
        input.put("title", title);
        String str = mapper.writeValueAsString(input);
        exchange.getMessage().setBody(str);
    }
}
