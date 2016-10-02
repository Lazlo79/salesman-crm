package br.com.kproj.salesman.infrastructure.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SerializerImpl implements Serializer {

    private Gson gson;

    @Autowired
    public SerializerImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T deserialize(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    @Override
    public String serialize(Object object) {
        return gson.toJson(object);
    }

}
