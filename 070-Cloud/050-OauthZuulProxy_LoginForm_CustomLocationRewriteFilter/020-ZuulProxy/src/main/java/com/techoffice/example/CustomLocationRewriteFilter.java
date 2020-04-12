package com.techoffice.example;

import com.netflix.util.Pair;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;

import java.net.URI;
import java.util.Iterator;

@Slf4j
public class CustomLocationRewriteFilter extends LocationRewriteFilter {
    private final UrlPathHelper urlPathHelper = new UrlPathHelper();

    public boolean shouldFilter() {
        boolean result = super.shouldFilter();
        RequestContext ctx = RequestContext.getCurrentContext();
        Pair<String, String> lh = this.locationHeader(ctx);
        if (lh != null) {
            String location = (String)lh.second();
            UriComponentsBuilder redirectedUriBuilder = UriComponentsBuilder.fromUriString(location);
            UriComponents redirectedUriComps = redirectedUriBuilder.build();
            String path = redirectedUriComps.getPath();
            if (path.startsWith("/login")){
                return false;
            }
        }
        return result;
    }

    private Pair<String, String> locationHeader(RequestContext ctx) {
        if (ctx.getZuulResponseHeaders() != null) {
            Iterator var2 = ctx.getZuulResponseHeaders().iterator();

            while(var2.hasNext()) {
                Pair<String, String> pair = (Pair)var2.next();
                if (((String)pair.first()).equals("Location")) {
                    return pair;
                }
            }
        }

        return null;
    }
}
