package model;

public final class ProviderUser {
    private String providerUid;
    private String nameProvider;

    public ProviderUser(String providerUid, String nameProvider) {
        this.providerUid = providerUid;
        this.nameProvider = nameProvider;
    }

    public String getNameProvider() {
        return nameProvider;
    }
    public String getProviderUid() {
        return providerUid;
    }
}
