package com.peirong.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserTableDef extends TableDef {

    public static final UserTableDef USER = new UserTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn EMAIL = new QueryColumn(this, "email");

    public final QueryColumn PHONE = new QueryColumn(this, "phone");

    public final QueryColumn AVATAR = new QueryColumn(this, "avatar");

    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    public final QueryColumn CREATED_AT = new QueryColumn(this, "created_at");

    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, EMAIL, PHONE, AVATAR, PASSWORD, USERNAME, CREATED_AT, UPDATE_TIME};

    public UserTableDef() {
        super("", "tb_user");
    }

}
