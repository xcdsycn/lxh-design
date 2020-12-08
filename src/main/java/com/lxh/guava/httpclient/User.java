package com.lxh.guava.httpclient;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import lombok.Data;

@Data
public class User extends GenericJson {
    @Key
    private String login;

    @Key
    private long id;

    @Key("email")
    private String email;
}
