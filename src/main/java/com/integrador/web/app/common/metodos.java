package com.integrador.web.app.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class metodos<T> {

    final Class<T> typeClass;

    

    public metodos(Class<T> typeClass) {
        this.typeClass = typeClass;
    }



 


}