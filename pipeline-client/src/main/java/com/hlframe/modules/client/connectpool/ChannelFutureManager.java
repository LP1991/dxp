/********************** 版权声明 *************************
 * 文件名: ChannelFutureManager.java
 * 包名: com.hlframe.modules.client.connectpool
 * 版权:	杭州华量软件  dxp
 * 职责: ChannelFuture池管理
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/2/9
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.connectpool;

import io.netty.channel.ChannelFuture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelFutureManager {
//    key 为pipelineId
    private Map<String,ChannelFuture> futures = new HashMap<>();
//  单例
    public static ChannelFutureManager instance = new ChannelFutureManager();

    private ChannelFutureManager(){
//        初始化
        initChannelFutures();
    }
    /**
     * 初始化方法
     * @param
     * @return
     * @Create by lp at 2018/2/9 15:30
     * @throws
     */
    private void initChannelFutures() {

    }


    public ChannelFuture get(String pipelineId){
        ChannelFuture channel = futures.get(pipelineId);
        if (null == channel){
//            new a channel by pipeline Id
        }

        if (!channel.channel().isActive()){
//            channel inActive, create a new one instead.
        }
        return channel;
    }
}
