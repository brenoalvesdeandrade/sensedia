package acceptance;


import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static requests.CardRequests.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardTests {

    private ValidatableResponse response;

    @Test
    public void createdBordAndReturnListWithNameAfazer(){
        createAndGetIdBoard();
        selectIdListBoard();

    }

    @Test
    public void validate1CardCreatedAndReturnStatusCode200() {
        assertNotNull(createCard());
    }

    @Test
    public void validate2GetCardAndReturnStatusCode200() {
        response = selectCard();
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }

    @Test
    public void validate3BoardNotFoundAndReturnStatusCode404(){
        response = selectCardNotFound();
        response.statusCode(HttpStatus.SC_NOT_FOUND);
    }
    @Test
    public void validate4CardUpdatedAndReturnStatusCode200() {
        response = updateCard();
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }
    @Test
    public void validate5DeleteCardAndReturnStatusCode200(){
        response = deleteCard();
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());
    }
    @Test
    public void validate6DeleteCardWithInvalidIdAndReturnStatusCode404() {
        response = deleteCardWithInvalidId();
        response.statusCode(HttpStatus.SC_NOT_FOUND);

    }
    @Test
    public void validate7UpdateCardWithInvalidIdAndReturnStatusCode404() {
        response = updateCardWithInvalidId();
        response.statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void validate8CreateCardWithoutApiKeyAndReturnStatusCode401() {
        response = createCardWithoutApiKey();
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validate9UpdateCardWithoutApiKeyAndReturnStatusCode401() {
        response = updateCardWithoutApiKey();
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void validateDeleteBoardAndReturnStatusCode200(){
        deleteBoard();
    }
}
