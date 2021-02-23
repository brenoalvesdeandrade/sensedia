package config;

public enum Urls {

    URL_BOARD("https://api.trello.com/1/boards"), URL_CARDS("https://api.trello.com/1/cards"),CARDS("/cards"),
    LISTS("/lists");

    private String url;

    Urls(String url) {

        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
