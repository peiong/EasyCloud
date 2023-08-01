package com.peirong.entity;



import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("db_file")
public class File {

    @Id
    private Long id;
    private String filename;
    private String filepath;
    private String filesize;
    private String uploadTime;
}
