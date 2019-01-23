package com.shark.imnetty.serializer;

/**
 * Created by qinghualiu on 2018/12/22.
 */
public interface SerializerAlgorithm {

    public byte JSON = 1;

    Serializer DEFAULT = new JSONSerializer();
}
