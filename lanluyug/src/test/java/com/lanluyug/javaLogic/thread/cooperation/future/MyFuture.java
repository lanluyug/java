package com.lanluyug.javaLogic.thread.cooperation.future;


public interface MyFuture <V>{
    /**
     * 没计算完会阻塞，直至计算完
     * @return V
     * @throws Exception 异常
     */
    V get() throws Exception;
}
