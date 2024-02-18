package com.solvd.carinaexample.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${config.api_url}/users/${username}", methodType = HttpMethodType.GET)
@RequestTemplatePath(path = "api/users/get_user_rs.json")
public class GetUserByUsername extends AbstractApiMethodV2 {

    public GetUserByUsername(String username) {
        super(null, "api/users/get_user_rs.json");

        //replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        //replaceUrlPlaceholder("username", "");
        replaceUrlPlaceholder("username", username);



        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
