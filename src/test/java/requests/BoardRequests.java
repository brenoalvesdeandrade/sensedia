package requests;

import config.Access;
import config.QueryParamFactory;
import config.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class BoardRequests {

    private static String idBoard;

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

    public static ValidatableResponse updateBoard() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .queryParam("name", QueryParamFactory.UPDATE_NAME_BOARD)
                    .put(Urls.URL_BOARD.toString() + "/" + idBoard)
                .then();
    }

    public static ValidatableResponse selectBoard() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .when()
                .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .get(Urls.URL_BOARD.toString() + "/" + idBoard)
                .then();
    }

    public static ValidatableResponse selectBoardWithIdInvalid() {
        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .get(Urls.URL_BOARD.toString() + "/" + QueryParamFactory.ID_BOARD_INVALID)
                .then();
    }

    public static ValidatableResponse selectBoardCards() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .get(Urls.URL_BOARD.toString() + "/" + idBoard + Urls.CARDS)
                .then();
    }

    public static ValidatableResponse deleteBoardWithInvalidId() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .delete(Urls.URL_BOARD.toString() + "/" + QueryParamFactory.ID_BOARD_INVALID)
                .then();
    }

    public static ValidatableResponse updateBoardWithInvalidId() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("key", Access.KEY)
                    .queryParam("token", Access.TOKEN)
                    .queryParam("name", QueryParamFactory.UPDATE_NAME_BOARD)
                    .put(Urls.URL_BOARD.toString() + "/" + QueryParamFactory.ID_BOARD_INVALID)
                .then();
    }

    public static ValidatableResponse createBoardWithoutApiKey() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("token", Access.TOKEN)
                    .queryParam("name", QueryParamFactory.NAME_BOARD)
                    .post(Urls.URL_BOARD.toString())
                .then();
    }

    public static ValidatableResponse updateBoardWithoutApiKey() {

        return given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .request()
                    .queryParam("token", Access.TOKEN)
                    .queryParam("name", QueryParamFactory.UPDATE_NAME_BOARD)
                    .put(Urls.URL_BOARD.toString() + "/" + idBoard)
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
