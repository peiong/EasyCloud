package com.peirong.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class FileTableDef extends TableDef {

    public static final FileTableDef FILE = new FileTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn FILENAME = new QueryColumn(this, "filename");

    public final QueryColumn FILEPATH = new QueryColumn(this, "filepath");

    public final QueryColumn FILESIZE = new QueryColumn(this, "filesize");

    public final QueryColumn UPLOAD_TIME = new QueryColumn(this, "upload_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, FILENAME, FILEPATH, FILESIZE, UPLOAD_TIME};

    public FileTableDef() {
        super("", "db_file");
    }

}
