package org.zhangzhuo.token;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenCache {
    private Map<String,Object> tokens;

    public TokenCache() {
        this.tokens = new HashMap<>();
    }

    public Map<String, Object> getTokens() {
        return tokens;
    }

    public void setTokens(Map<String, Object> tokens) {
        this.tokens = tokens;
    }
}
