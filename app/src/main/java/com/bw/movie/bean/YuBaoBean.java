package com.bw.movie.bean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/19.
 * function：
 */
public class YuBaoBean {

    /**
     * result : {"commentNum":9,"duration":"155分钟","imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg","movieActor":[{"name":"葛优","photo":"http://172.17.8.100/images/movie/actor/whwdzg/geyou.jpg","role":"张北京"},{"name":"张译","photo":"http://172.17.8.100/images/movie/actor/whwdzg/zhangyi.jpg","role":"高远"},{"name":"杜江","photo":"http://172.17.8.100/images/movie/actor/whwdzg/dujiang.jpg","role":"朱涛"},{"name":"黄渤","photo":"http://172.17.8.100/images/movie/actor/whwdzg/huangbo.jpg","role":"林治远"},{"name":"刘昊然","photo":"http://172.17.8.100/images/movie/actor/whwdzg/liuhaoran.jpg","role":"沃德乐"},{"name":"吴京","photo":"http://172.17.8.100/images/movie/actor/whwdzg/wujing.jpg","role":"冬冬（成年）"}],"movieDirector":[{"name":"陈凯歌","photo":"http://172.17.8.100/images/movie/director/whwdzg/1.jpg"}],"movieId":23,"movieType":"剧情","name":"我和我的祖国","placeOrigin":"中国大陆","posterList":["http://172.17.8.100/images/movie/stills/whwdzg/whwdzg6.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg5.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg4.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg3.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg2.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg"],"releaseTime":1569772800000,"score":9.7,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg5.jpg","videoUrl":"http://172.17.8.100/video/movie/whwdzg/whwdzg1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg4.jpg","videoUrl":"http://172.17.8.100/video/movie/whwdzg/whwdzg2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg3.jpg","videoUrl":"http://172.17.8.100/video/movie/whwdzg/whwdzg3.mp4"}],"summary":"七位导演分别取材新中国成立70周年以来，祖国经历的无数个历史性经典瞬间。讲述普通人与国家之间息息相关密不可分的动人故事。聚焦大时代大事件下，小人物和国家之间，看似遥远实则密切的关联，唤醒全球华人共同回忆。\r\n演职人员全部\r\n导演\r\n\r\n陈凯歌\r\n\r\n张一白\r\n演员\r\n\r\n黄渤\r\n饰：林治远\r\n\r\n张译\r\n饰：高远\r\n\r\n韩昊霖\r\n饰：冬冬（童年）\r\n图集全部\r\n\r\n热门短评\r\n\r\nyFV984669880 购\r\n09-30 \r\n126426\r\n看到评论里，很多人说看不懂原子弹那段，我觉得我可以解释，我也是后来听我爸爸说的，我爷爷就是参加那场科研的人员之一，突然有天就失去联系了，去单位里也找不到人，一直到新闻说原子弹爆炸成功了，国家才派人到家里来送抚恤金，因为爷爷在科研过程中，被辐射了，一年前就已经死了，因为是秘密研究，所有科研人员都是临时受命，接到命令就马上离开了，甚至没来得及跟家里说一声，而且在科研过程中，也是不允许跟家里有任何联系的，所以我们是事后才知道爷爷去做了什么，他是英雄\r\n\r\n岁月如初. 购\r\n09-30 \r\n23401\r\n黄渤的演技没话说，剧情紧凑，非常完美的开篇 陈凯歌","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * commentNum : 9
         * duration : 155分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg
         * movieActor : [{"name":"葛优","photo":"http://172.17.8.100/images/movie/actor/whwdzg/geyou.jpg","role":"张北京"},{"name":"张译","photo":"http://172.17.8.100/images/movie/actor/whwdzg/zhangyi.jpg","role":"高远"},{"name":"杜江","photo":"http://172.17.8.100/images/movie/actor/whwdzg/dujiang.jpg","role":"朱涛"},{"name":"黄渤","photo":"http://172.17.8.100/images/movie/actor/whwdzg/huangbo.jpg","role":"林治远"},{"name":"刘昊然","photo":"http://172.17.8.100/images/movie/actor/whwdzg/liuhaoran.jpg","role":"沃德乐"},{"name":"吴京","photo":"http://172.17.8.100/images/movie/actor/whwdzg/wujing.jpg","role":"冬冬（成年）"}]
         * movieDirector : [{"name":"陈凯歌","photo":"http://172.17.8.100/images/movie/director/whwdzg/1.jpg"}]
         * movieId : 23
         * movieType : 剧情
         * name : 我和我的祖国
         * placeOrigin : 中国大陆
         * posterList : ["http://172.17.8.100/images/movie/stills/whwdzg/whwdzg6.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg5.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg4.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg3.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg2.jpg","http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg"]
         * releaseTime : 1569772800000
         * score : 9.7
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg5.jpg","videoUrl":"http://172.17.8.100/video/movie/whwdzg/whwdzg1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg4.jpg","videoUrl":"http://172.17.8.100/video/movie/whwdzg/whwdzg2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg3.jpg","videoUrl":"http://172.17.8.100/video/movie/whwdzg/whwdzg3.mp4"}]
         * summary : 七位导演分别取材新中国成立70周年以来，祖国经历的无数个历史性经典瞬间。讲述普通人与国家之间息息相关密不可分的动人故事。聚焦大时代大事件下，小人物和国家之间，看似遥远实则密切的关联，唤醒全球华人共同回忆。
         演职人员全部
         导演

         陈凯歌

         张一白
         演员

         黄渤
         饰：林治远

         张译
         饰：高远

         韩昊霖
         饰：冬冬（童年）
         图集全部

         热门短评

         yFV984669880 购
         09-30 
         126426
         看到评论里，很多人说看不懂原子弹那段，我觉得我可以解释，我也是后来听我爸爸说的，我爷爷就是参加那场科研的人员之一，突然有天就失去联系了，去单位里也找不到人，一直到新闻说原子弹爆炸成功了，国家才派人到家里来送抚恤金，因为爷爷在科研过程中，被辐射了，一年前就已经死了，因为是秘密研究，所有科研人员都是临时受命，接到命令就马上离开了，甚至没来得及跟家里说一声，而且在科研过程中，也是不允许跟家里有任何联系的，所以我们是事后才知道爷爷去做了什么，他是英雄

         岁月如初. 购
         09-30 
         23401
         黄渤的演技没话说，剧情紧凑，非常完美的开篇 陈凯歌
         * whetherFollow : 2
         */

        private String commentNum;
        private String duration;
        private String imageUrl;
        private String movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private String whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
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

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(String whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 葛优
             * photo : http://172.17.8.100/images/movie/actor/whwdzg/geyou.jpg
             * role : 张北京
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 陈凯歌
             * photo : http://172.17.8.100/images/movie/director/whwdzg/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/whwdzg/whwdzg5.jpg
             * videoUrl : http://172.17.8.100/video/movie/whwdzg/whwdzg1.mp4
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
