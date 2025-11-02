package com.example.util;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

public class PaginationUtil {

    private PaginationUtil() {
    }

    public static HttpHeaders generatePaginationHttpHeaders(Page<?> page, String baseUrl) {
        HttpHeaders headers = new HttpHeaders();
        int pageNumber = page.getNumber();
        int pageSize = page.getSize();
        long totalElements = page.getTotalElements();

        StringBuilder link = new StringBuilder();
        if (pageNumber + 1 < page.getTotalPages()) {
            link.append(buildLink(baseUrl, pageNumber + 1, pageSize, "next")).append(",");
        }
        if (pageNumber > 0) {
            link.append(buildLink(baseUrl, pageNumber - 1, pageSize, "prev")).append(",");
        }
        link.append(buildLink(baseUrl, 0, pageSize, "first")).append(",");
        link.append(buildLink(baseUrl, page.getTotalPages() - 1, pageSize, "last"));

        headers.add(HttpHeaders.LINK, link.toString());
        headers.add("X-Total-Count", Long.toString(totalElements));
        return headers;
    }

    private static String buildLink(String baseUrl, int page, int size, String relType) {
        String uri = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("page", page)
                .queryParam("size", size)
                .toUriString();
        return "<" + uri + ">; rel=" + relType;
    }

}
