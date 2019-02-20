package com.muti.lesson.model;

/**
 * Desc: TODO
 * <p> 影片对象
 * Author: Liu Zhongzhu
 * PackageName: com.muti.lesson.model
 * ProjectName: AndroidStudioProjects
 * Date: 2019/1/25 16:30
 */
public class VideoModel {

    // 影片类型
    private int type = -1;

    // 影片名称
    private String name = null;

    // 影片的图片下载地址
    private String imgurl = null;

    // 影片的介绍
    private String describe = null;

    // 影片的播放地址
    private String playurl = null;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    @Override
    public String toString() {
        return "VideoModel{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", describe='" + describe + '\'' +
                ", playurl='" + playurl + '\'' +
                '}';
    }
}
