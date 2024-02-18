package com.solvd.carinaexample;

import com.solvd.carinaexample.api.GetUserByUsername;
import com.solvd.carinaexample.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class UserTest {
    @Test
    public void verifyUserByUserNameTest(){
        User user = new User();
        user.setUsername("lucasgragera");
        user.setFirstName("Lucas");
        user.setLastName("Gragera");
        user.setCompany("Solvd Inc.");

        GetUserByUsername getUserByUsername = new GetUserByUsername("lucasgragera");
        getUserByUsername.addProperty("user", user);

        getUserByUsername.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserByUsername.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date-> isDateValid(date) && ZonedDateTime.parse(date).isAfter(LocalDate.of(2024,1,1).atStartOfDay(ZoneId.systemDefault())));

        getUserByUsername.validateResponse(comparatorContext);

    }
    private static boolean isDateValid(String date){
        try{
            ZonedDateTime.parse(date);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }
}
