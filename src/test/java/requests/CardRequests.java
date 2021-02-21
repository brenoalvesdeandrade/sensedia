package requests;

import config.Access;
import config.QueryParamFactory;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CardRequests {


    private static String idBoard;
    private static String getListPosition0;
    private static String idCard;

    public static String createAndGetIdBoard() {

        idBoard = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .queryParam("name", QueryParamFactory.NAME_BOARD)
                    .post(Urls.URL_BOARD.toString())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().path("id");
        return idBoard;

    }

    public static String selectIdListBoard() {

        List idList;

        idList= given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .get(Urls.URL_BOARD.toString() + "/" + idBoard + Urls.LISTS)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                    .path("id");

        getListPosition0 = String.valueOf(idList.get(0));

        return getListPosition0;
    }

    public static String createCard() {

        idCard = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .queryParam("idList", getListPosition0)
                    .queryParam("name", QueryParamFactory.NAME_CARD)
                    .post(Urls.URL_CARDS.toString())
                .then().statusCode(HttpStatus.SC_OK).extract().path("id");

        return idCard;
    }

    public static ValidatableResponse selectCard() {

         return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .queryParam("idList", getListPosition0)
                    .get(Urls.URL_CARDS.toString() + "/" + idCard)
                .then();
    }

    public static ValidatableResponse selectCardNotFound() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .get(Urls.URL_CARDS.toString() + "/" + QueryParamFactory.ID_CARD_INVALID)
                .then();
    }

    public static ValidatableResponse updateCard() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .queryParam("name", "BRENO")
                    .put(Urls.URL_CARDS.toString() + "/" + idCard)
                .then();
    }

    public static ValidatableResponse deleteCard() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .delete(Urls.URL_CARDS.toString() + "/" + idCard)
                .then();
    }


    public static ValidatableResponse deleteCardWithInvalidId() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .delete(Urls.URL_CARDS.toString() + "/" + QueryParamFactory.ID_CARD_INVALID)
                .then();
    }

    public static ValidatableResponse updateCardWithInvalidId() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .queryParam("name", "BRENO")
                    .put(Urls.URL_CARDS.toString() + "/" + QueryParamFactory.ID_CARD_INVALID)
                .then();
    }

    public static ValidatableResponse createCardWithoutApiKey() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", "21212")
                    .queryParam("token", Access.TOKEN)
                    .queryParam("idList", getListPosition0)
                    .queryParam("name", QueryParamFactory.NAME_CARD)
                    .post(Urls.URL_CARDS.toString())
                .then();
    }

    public static ValidatableResponse updateCardWithoutApiKey() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("token", Access.TOKEN)
                    .put(Urls.URL_CARDS.toString() + "/" + idCard)
                .then();
    }

    public static ValidatableResponse deleteBoard() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .delete(Urls.URL_BOARD.toString() + "/" + idBoard)
                .then();
    }

}
