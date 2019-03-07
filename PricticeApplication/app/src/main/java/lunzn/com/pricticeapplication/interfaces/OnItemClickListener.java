package lunzn.com.pricticeapplication.interfaces;

import com.platfrom.sdk.bean.Video;

import java.util.List;

/**
 * Desc: item点击事件接口
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.interfaces
 * ProjectName: PricticeApplication
 * Date: 2019/1/31 16:24
 */
public interface OnItemClickListener {

    void onItemClick(List<Video> videoList, int position);

}
