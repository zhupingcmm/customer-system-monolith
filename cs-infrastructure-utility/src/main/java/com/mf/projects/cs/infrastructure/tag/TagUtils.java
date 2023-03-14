package com.mf.projects.cs.infrastructure.tag;

import org.springframework.cloud.client.ServiceInstance;

public class TagUtils {

    private static final String TAG_NAME = "tag";

    public static String getTag(ServiceInstance instance) {
        return instance.getMetadata().get(TAG_NAME);
    }



}
