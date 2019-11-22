package com.bw.movie.bean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/20.
 * function：
 */
public class ScheduleBean {

    /**
     * result : [{"director":"黄渤","imageUrl":"http://172.17.8.100/images/movie/stills/ychx/ychx1.jpg","movieId":13,"name":"一出好戏","score":9.6,"starring":"黄渤,舒淇,王宝强,张艺兴","trailerUrl":"http://172.17.8.100/video/movie/ychx/ychx1.ts"},{"director":"\r\n刘伟强","imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg","movieId":24,"name":"中国机长","score":9.4,"starring":"张涵予,欧豪,袁泉,张天爱,李沁","trailerUrl":"http://172.17.8.100/video/movie/zgjz/zgjz1.mp4"},{"director":"韩延","imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj1.jpg","movieId":10,"name":"动物世界","score":9.5,"starring":"李易峰,迈克尔·道格拉斯,周冬雨","trailerUrl":"http://172.17.8.100/video/movie/dwsj/dwsj1.ts"},{"director":"林德禄","imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","movieId":17,"name":"反贪风暴3","score":9.1,"starring":"古天乐,张智霖,郑嘉颖,邓丽欣,谢天华","trailerUrl":"http://172.17.8.100/video/movie/ftfb3/ftfb(3)1.mp4"},{"director":"是枝裕和","imageUrl":"http://172.17.8.100/images/movie/stills/xtjz/xtjz1.jpg","movieId":9,"name":"小偷家族","score":9.4,"starring":"中川雅也,安藤樱,松冈茉优,","trailerUrl":"http://172.17.8.100/video/movie/xtjz/xtjz1.ts"}]
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
         * director : 黄渤
         * imageUrl : http://172.17.8.100/images/movie/stills/ychx/ychx1.jpg
         * movieId : 13
         * name : 一出好戏
         * score : 9.6
         * starring : 黄渤,舒淇,王宝强,张艺兴
         * trailerUrl : http://172.17.8.100/video/movie/ychx/ychx1.ts
         */

        private String director;
        private String imageUrl;
        private String movieId;
        private String name;
        private String score;
        private String starring;
        private String trailerUrl;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }

        public String getTrailerUrl() {
            return trailerUrl;
        }

        public void setTrailerUrl(String trailerUrl) {
            this.trailerUrl = trailerUrl;
        }
    }
}
