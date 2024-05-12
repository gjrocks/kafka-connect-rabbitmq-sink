package com.gj.rabbitmq.connectors.sink;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionUtil {
    private static final Logger log = LoggerFactory.getLogger(VersionUtil.class);
    static final String FALLBACK_VERSION = "0.0.0.0";

    public VersionUtil() {
    }

    public static String version(Class<?> cls) {
        String result;
        try {
            result = cls.getPackage().getImplementationVersion();
            if (result==null || result.isEmpty()) {
                result = "0.0.0.0";
            }
        } catch (Exception var3) {
            log.error("Exception thrown while getting error", var3);
            result = "0.0.0.0";
        }

        return result;
    }
}
