package com.bw.movie.bean;

/**
 * author: [Liu He]
 * data: 2019/11/11.
 * function：
 */
public class EmailBean {

    /**
     * message : 发送成功
     * status : 0000
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
