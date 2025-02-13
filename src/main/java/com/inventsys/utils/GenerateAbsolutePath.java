package com.inventsys.utils;

import java.io.File;

public class GenerateAbsolutePath {
    public String generateAbsolutePath(String relativePath){
        File file = new File(relativePath);
        if (!file.exists()) {
            throw new RuntimeException("Arquivo não encontrado: " + relativePath);
        }
        String absolutePath = file.getAbsolutePath();

        return absolutePath;
    }
}
