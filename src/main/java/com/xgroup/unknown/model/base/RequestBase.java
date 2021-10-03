package com.xgroup.unknown.model.base;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class RequestBase<S extends RequestBase, U> {
    public U convertToEntity(S source, U destination) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
             destination =(U) objectMapper.convertValue(source, destination.getClass());
        }catch (Exception e){
        }
        return destination;
    }
    public S converToRequest(U source, S destination) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            destination =(S) objectMapper.convertValue(source, destination.getClass());
        }catch (Exception e){
        }
        return destination;
    }
    public S copyProperties(S source){
        ObjectMapper objectMapper = new ObjectMapper();
        S destination = null;
        try {
           destination =(S) objectMapper.convertValue(source, source.getClass());
        }catch (Exception e){
        }
        return destination;
    }

}
