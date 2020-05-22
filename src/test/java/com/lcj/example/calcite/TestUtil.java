package com.lcj.example.calcite;

import org.apache.calcite.util.Sources;

public class TestUtil {

    public static String resourcePath(String path) {
        return Sources.of(TestUtil.class.getResource("/" + path)).file().getAbsolutePath();
    }

}
