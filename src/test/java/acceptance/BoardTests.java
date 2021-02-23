package acceptance;

import org.apache.http.HttpStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;
import org.junit.runners.MethodSorters;

import static config.QueryParamFactory.UPDATE_NAME_BOARD;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static requests.BoardRequests.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardTests {

   private ValidatableResponse response;

   @Test
    public void validate1BoardCreatedAndReturnStatusCode200(){

        assertNotNull(createAndGetIdBoard());

    }

   @Test
   public void validate2BoardUpdatedAndReturnStatusCode200(){

        response = updateBoard();
        response.statusCode(HttpStatus.SC_OK);
        response.body(notNullValue());

    }

   @Test
    public void validate3GetBoardAndReturnStatusCode200(){

        response = selectBoard();
        response.statusCode(HttpStatus.SC_OK);
        response.body("name",is(UPDATE_NAME_BOARD.toString()));

    }

    @Test
    public void validate4BoardNotFoundAndReturnStatusCode404(){

        response = selectBoardWithIdInvalid();
        response.statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void validate5BoardWithCardsAndReturnStatusCode200(){

        response = selectBoardCards();
        response.statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void validate6UpdateBoardWithInvalidIdAndReturnStatusCode404(){

        response = updateBoardWithInvalidId();
        response.statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void validate7DeleteBoardWithInvalidIdAndReturnStatusCode404(){

        response = deleteBoardWithInvalidId();
        response.statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void validate8CreateBoardWithoutApiKeyAndReturnStatusCode401(){

        response = createBoardWithoutApiKey();
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);

    }

    @Test
    public void validate9UpdateBoardWithoutApiKeyAndReturnStatusCode401(){

        response = updateBoardWithoutApiKey();
        response.statusCode(HttpStatus.SC_UNAUTHORIZED);

    }

    @Test
    public void validateDeleteBoardAndReturnStatusCode200(){

        response = deleteBoard();
        response.statusCode(HttpStatus.SC_OK);

    }

}
