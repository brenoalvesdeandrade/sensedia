package config;

public enum QueryParamFactory {

    NAME_BOARD("SENSEDIAAUTOMACAO"), UPDATE_NAME_BOARD("SENSEDIAUPDATE"),ID_BOARD_INVALID("6032ccfbe628d9244d653644"),
    NAME_CARD("SENSEDIACARD"), ID_CARD_INVALID("6032996977e86d40ecd12345"), NAME_CARD_UPDATE("SENSEDIAUPDATE");

    private String queryParam;

    QueryParamFactory(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    @Override
    public String toString() {
        return queryParam;
    }
}
