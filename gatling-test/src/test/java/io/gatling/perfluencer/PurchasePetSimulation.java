package io.gatling.perfluencer;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class PurchasePetSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://jpetstore.perfluencer.pl")
    .inferHtmlResources()
    .acceptHeader("image/avif,image/webp,image/png,image/svg+xml,image/*;q=0.8,*/*;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:138.0) Gecko/20100101 Firefox/138.0");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),
    Map.entry("Priority", "u=0, i"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.of("Priority", "u=6");
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("Accept", "text/css,*/*;q=0.1"),
    Map.entry("Priority", "u=2")
  );
  
  private Map<CharSequence, String> headers_5 = Map.of("Priority", "u=5, i");
  
  private Map<CharSequence, String> headers_20 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"),
    Map.entry("Origin", "http://jpetstore.perfluencer.pl"),
    Map.entry("Priority", "u=0, i"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_21 = Map.of("Priority", "u=4, i");
   FeederBuilder.Batchable feeder = csv("users.csv").random();
  private ScenarioBuilder scn = scenario("PurchasePetSimulation")
    .exec(
      http("request_0")
        .get("/")
        .headers(headers_0)
        .check(status().is(404))
        .resources(
          http("request_1")
            .get("/favicon.ico")
            .headers(headers_1)
            .check(status().is(404))
        ),
      pause(5),
      http("request_2")
        .get("/jpetstore")
        .headers(headers_0)
        .resources(
          http("request_3")
            .get("/jpetstore/css/jpetstore.css")
            .headers(headers_3)
        ),
      pause(5),
      http("request_4")
        .get("/jpetstore")
        .headers(headers_0)
        .resources(
          http("request_5")
            .get("/jpetstore/images/logo-topbar.gif")
            .headers(headers_5),
          http("request_6")
            .get("/jpetstore/images/sm_fish.gif")
            .headers(headers_5),
          http("request_7")
            .get("/jpetstore/images/separator.gif")
            .headers(headers_5),
          http("request_8")
            .get("/jpetstore/images/cart.gif")
            .headers(headers_5),
          http("request_9")
            .get("/jpetstore/images/sm_birds.gif")
            .headers(headers_5),
          http("request_10")
            .get("/jpetstore/images/sm_cats.gif")
            .headers(headers_5),
          http("request_11")
            .get("/jpetstore/images/sm_dogs.gif")
            .headers(headers_5),
          http("request_12")
            .get("/jpetstore/images/sm_reptiles.gif")
            .headers(headers_5),
          http("request_13")
            .get("/jpetstore/images/fish_icon.gif")
            .headers(headers_5),
          http("request_14")
            .get("/jpetstore/images/dogs_icon.gif")
            .headers(headers_5),
          http("request_15")
            .get("/jpetstore/images/cats_icon.gif")
            .headers(headers_5),
          http("request_16")
            .get("/jpetstore/images/reptiles_icon.gif")
            .headers(headers_5),
          http("request_17")
            .get("/jpetstore/images/birds_icon.gif")
            .headers(headers_5),
          http("request_18")
            .get("/jpetstore/images/splash.gif")
            .headers(headers_5)
        ),
      pause(5),
      http("request_19")
        .get("/jpetstore/actions/Account.action?signonForm=")
        .headers(headers_0),
      pause(5).feed(feeder),
      http("request_20")
        .post("/jpetstore/actions/Account.action")
        .headers(headers_20)
        .formParam("username", "#{username}")
        .formParam("password", "#{password}")
        .formParam("signon", "Login")
        .formParam("_sourcePage", "-9RTYf-xrZ6fbqijObziNiHkiJuhMglZBBrmU6xCntRsP5yjdPE3_vyj5RYpdshx49e_iQu26Gel9H5m-6V9BmkqOMypmytfOAk-vvpC5A8=")
        .formParam("__fp", "LzeYxRAPJLuxkxlsr0Z3U05zja8O0ItR6LH7dsivZpErly06hcT_gZyCSlHlilBW")
        .resources(
          http("request_21")
            .get("/jpetstore/images/banner_cats.gif")
            .headers(headers_21)
        ),
      pause(5),
      http("request_22")
        .get("/jpetstore/actions/Catalog.action?viewCategory=&categoryId=DOGS")
        .headers(headers_0),
      pause(5),
      http("request_23")
        .get("/jpetstore/actions/Catalog.action?viewProduct=&productId=K9-CW-01")
        .headers(headers_0),
      pause(5),
      http("request_24")
        .get("/jpetstore/actions/Cart.action?addItemToCart=&workingItemId=EST-26")
        .headers(headers_0),
      pause(5),
      http("request_25")
        .post("/jpetstore/actions/Cart.action")
        .headers(headers_20)
        .formParam("EST-26", "56")
        .formParam("updateCartQuantities", "Update Cart")
        .formParam("_sourcePage", "gjmIZCKCcXbDeWqFfFFN6Ht2Q8jIE7V_xd9S6-47Qc6u7j7Gd236OwWW8QSTUiPe9nj1qhKr6VITCvfRaY10PDR8LLuYNSsn")
        .formParam("__fp", "BrX-zF417k8TxlOiKJY2oT-kTg1yHnA1TJl0kIkqW2akGhGzzM_4D0KeAPs4GLqB"),
      pause(5),
      http("request_26")
        .get("/jpetstore/actions/Order.action?newOrderForm=")
        .headers(headers_0),
      pause(5),
      http("request_27")
        .post("/jpetstore/actions/Order.action")
        .headers(headers_20)
        .formParam("order.cardType", "MasterCard")
        .formParam("order.creditCard", "999 9999 9999 9999")
        .formParam("order.expiryDate", "12/03")
        .formParam("order.billToFirstName", "DJ")
        .formParam("order.billToLastName", "BOBO")
        .formParam("order.billAddress1", "901 San Antonio Road")
        .formParam("order.billAddress2", "MS UCUP02-206")
        .formParam("order.billCity", "Palo Alto")
        .formParam("order.billState", "CA")
        .formParam("order.billZip", "94303")
        .formParam("order.billCountry", "USA")
        .formParam("newOrder", "Continue")
        .formParam("_sourcePage", "9Td6cbRxli-j03GQX0lI84tRpEXIVWSIhb_p25KhSdTXuqWc4b4Cc2PwLTDZyLaZ4OgY-pkDybdchIn66nrZ8b0BJRyRCNSdvUh5_UYS3Ek=")
        .formParam("__fp", "qZ7US1KOohP8kRpXrrtUIVz6FdyoB9HQD2HbyceYn3kYoqG4YZAaq7XP2t28_EHiWy2Z5Y2MWHg7RlE-sCrn--Ka4xdoNxMDHsV34GJq9GgmZYyeR424JQ=="),
      pause(5),
      http("request_28")
        .get("/jpetstore/actions/Order.action?newOrder=&confirmed=true")
        .headers(headers_0),
      pause(5),
      http("request_29")
        .get("/jpetstore/actions/Account.action?editAccountForm=")
        .headers(headers_0),
      pause(5),
      http("request_32")
        .get("/jpetstore/actions/Account.action?signoff=")
        .headers(headers_0)
    );

  {
	  setUp(scn.injectOpen( rampUsers(50).during(Duration.ofSeconds(120)), constantUsersPerSec(1).during(Duration.ofSeconds(3600))).protocols(httpProtocol));
  }
}
