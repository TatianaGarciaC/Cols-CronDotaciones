package com.colsubsidio.dotaciones.scheduled.config.exceptions;

import java.util.ArrayList;
import java.util.List;

public class DotacionNotAccets  extends RuntimeException {

    private static final long serialVersionUID = -7641095497424839261L;
    @SuppressWarnings("rawtypes")
    private List list;
    private String methodName;
    @SuppressWarnings("rawtypes")
    private Class clazzError;
    @SuppressWarnings("rawtypes")
    public DotacionNotAccets() {
        super();
        list = new ArrayList();
    }

    @SuppressWarnings("rawtypes")
    public
    DotacionNotAccets(String error) {
        super(error);
        list = new ArrayList();
    }

    @SuppressWarnings("rawtypes")
    public DotacionNotAccets(Throwable error) {
        super(error);
        list = new ArrayList();
    }

    @SuppressWarnings("rawtypes")
    public <T extends Exception> DotacionNotAccets(T error) {
        super(error);
        list = new ArrayList();
    }

    @SuppressWarnings("rawtypes")
    public DotacionNotAccets(String message, Throwable cause) {
        super(message, cause);
        list = new ArrayList();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public DotacionNotAccets addELK(Object elk) {
        if(elk instanceof List) {
            ((List)elk).forEach(list::add);
        }else if(elk != null){
            list.add(elk);
        }
        return this;
    }

    public DotacionNotAccets setMethodName(String methodName){
        this.methodName = methodName;
        return this;
    }

    @SuppressWarnings("rawtypes")
    public DotacionNotAccets setClass(Class clazz) {
        this.clazzError = clazz;
        return this;
    }
}
