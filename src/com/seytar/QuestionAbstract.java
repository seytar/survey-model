package com.seytar;

public class QuestionAbstract implements IdentitableInterface {
    private Identity identity;

    @Override
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    @Override
    public Identity getIdentity() {
        return identity;
    }
}
