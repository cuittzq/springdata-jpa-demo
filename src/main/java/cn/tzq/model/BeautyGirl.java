package cn.tzq.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tzq139 on 2017/3/21.
 */
@Data
@Entity
@Table(name = "BeautyGirls")
public class BeautyGirl implements Serializable {
    private static final long serialVersionUID = -8459755922288527580L;

    @Id
    @Column(name = "KeyID")
    @GeneratedValue
    Integer keyID;

    @Column(name = "ImageTheme")
    Integer imageTheme;

    @Column(name = "ImageUrl")
    Integer imageUrl;

    @Column(name = "IsDownload")
    Integer download;

    @Column(name = "IsDelete")
    Integer deleted;
}
