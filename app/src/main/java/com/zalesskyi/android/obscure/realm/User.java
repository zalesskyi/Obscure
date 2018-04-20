package com.zalesskyi.android.obscure.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Алексей on 14.04.2018.
 */

public class User extends RealmObject {
    @PrimaryKey
    private long realm_id;

    public User() {

    }

    public void setId(long id) {
        realm_id = id;
    }
}
