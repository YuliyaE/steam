package com.epam.tat.steam.tests.api;

import com.epam.tat.steam.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPlayerSummariesTest {

    private static final String KEY = "02F53CA3FA7FAE4CA562207AE5274BC9";
    private static final String STEAM_ID = "76561198969659493";


    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://api.steampowered.com/";
    }

    @Test
    public void checkPlayerSummaries() {

        Response response = RestAssured.when().get("/ISteamUser/GetPlayerSummaries/v0002/?key=" + KEY + "&steamids=" + STEAM_ID).andReturn();
        //given().auth().basic("eugenetat19", "TatLab2019");
        given().auth().form("eugenetat19", "TatLab2019", new FormAuthConfig("/perform_login", "username  ", "password"));
        ResponseBody<?> responseBody = response.getBody();
        User user = responseBody.as(User.class);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

       // System.out.println(gson.toJson(user.getCommunityVisibilitystate()));

        System.out.println(gson.toJson(user));

        Assert.assertEquals(user.getCommunityVisibilitystate(), 0);

    }

    @Test
    public void GetRecentlyPlayedGames() {

       // Response response = RestAssured.when().get("/IPlayerService/GetRecentlyPlayedGames/v0001/?key=" + KEY + "&steamid=" + STEAM_ID).andReturn();

        Response response = RestAssured.when().get("/ISteamUser/GetFriendList/v0001/?key=" + KEY + "&steamid=" + STEAM_ID + "&relationship=friend").andReturn();
        ResponseBody<?> responseBody = response.getBody();
        User user = responseBody.as(User.class);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(user));

        // Assert.assertEquals(user.getCommunityVisibilitystate(), 3);
    }


}
