package config;

public enum Access {
    KEY("32fc1ab1ddd6d78c2a9b510d24cb5732"),TOKEN("dd5ebda6e948ac620afdecf8936de70deeac485df7bf18aabe2894984acdeb3e"),;

    String access;
    Access(String access){
        this.access=access;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return access;
    }
}
