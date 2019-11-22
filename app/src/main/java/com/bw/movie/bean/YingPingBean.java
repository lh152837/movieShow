package com.bw.movie.bean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/20.
 * function：
 */
public class YingPingBean {

    /**
     * result : [{"commentContent":"这接口是不是有问题啊！！！","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":125,"commentTime":1574211703000,"commentUserId":13821,"commentUserName":"老丁万岁","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"真好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":123,"commentTime":1574162477000,"commentUserId":13766,"commentUserName":"nideyifa","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-27/20190827104532.png","commentId":106,"commentTime":1574135540000,"commentUserId":13541,"commentUserName":"大仙","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":" 好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-15/20190815170633.png","commentId":103,"commentTime":1574135338000,"commentUserId":13485,"commentUserName":"秋冬","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-24/20191024160418.unknown","commentId":102,"commentTime":1574135145000,"commentUserId":13542,"commentUserName":"杨海鹏","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : 这接口是不是有问题啊！！！
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 125
         * commentTime : 1574211703000
         * commentUserId : 13821
         * commentUserName : 老丁万岁
         * greatHeadPic : []
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private String commentId;
        private long commentTime;
        private String commentUserId;
        private String commentUserName;
        private String greatNum;
        private String hotComment;
        private String isGreat;
        private List<?> greatHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public String getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(String commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public String getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(String greatNum) {
            this.greatNum = greatNum;
        }

        public String getHotComment() {
            return hotComment;
        }

        public void setHotComment(String hotComment) {
            this.hotComment = hotComment;
        }

        public String getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(String isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
