package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.ChaXunZuoWeiBean;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.FuJinBean;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.JieShaoBean;
import com.bw.movie.bean.JuZhaoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MingXiBean;
import com.bw.movie.bean.PaiQiLieBiaoBean;
import com.bw.movie.bean.QuYuBean;
import com.bw.movie.bean.ReMenBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.bean.TuiJianBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YuBaoBean;
import com.bw.movie.contract.UserContract;
import com.bw.movie.presenter.UserPresenter;
import com.bw.movie.utils.EncryptUtil;
import com.bw.mvp_library.base.BaseActivity;
import com.bw.mvp_library.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @describe(描述)：MovieActivity 登录页面
 * @data（日期）: 2019/11/12
 * @time（时间）: 13:58
 * @author（作者）: Liuhe
 **/
public class MovieActivity extends BaseActivity<UserPresenter> implements UserContract.UserView {


    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.text_reg)
    TextView textReg;
    @BindView(R.id.but_log)
    Button butLog;
    @BindView(R.id.but_wz)
    Button butWz;

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_movie;

    }


    @OnClick({R.id.edit_email, R.id.edit_pwd, R.id.text_reg, R.id.but_log, R.id.but_wz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_email:
                break;
            case R.id.edit_pwd:
                break;
            case R.id.text_reg:
                //点击跳转到注册页面
                startActivity(new Intent(MovieActivity.this, RegisterActivity.class));
                break;
            case R.id.but_log:
                //获取账号密码
                String email = "2467337415@qq.com";
                String pwd = "123";
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pwd)) {
                    String encrypt = EncryptUtil.encrypt(pwd);
                    presenter.UserPresenterLogin(email, encrypt);

                    SharedPreferences aa = getSharedPreferences("aa", MODE_PRIVATE);
                    SharedPreferences.Editor edit = aa.edit();
                    edit.putString("a", email);
                    edit.putString("b", pwd);
                    edit.commit();
                } else {

                    Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.but_wz:
                break;
        }
    }

    //登录
    @Override
    public void UserViewLoginSuccess(LoginBean data) {
        String status = data.getStatus();
        if (status.equals("0000")) {
            Intent intent = new Intent(MovieActivity.this, ShowActivity.class);
            intent.putExtra("a", data.getResult().getUserId());
            intent.putExtra("b", data.getResult().getSessionId());
            startActivity(intent);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void UserViewLoginError(Throwable e) {

    }

    @Override
    public void UserViewRegisterSuccess(RegisterBean data) {

    }

    @Override
    public void UserViewRegisterError(Throwable e) {

    }

    @Override
    public void UserViewEmailSuccess(EmailBean data) {

    }

    @Override
    public void UserViewEmailError(Throwable e) {

    }

    @Override
    public void UserViewBannerSuccess(BannerBean data) {

    }

    @Override
    public void UserViewBannerError(Throwable e) {

    }

    @Override
    public void UserViewReYingSuccess(ReYingBean reYingBean) {

    }

    @Override
    public void UserViewReYingError(Throwable e) {

    }

    @Override
    public void UserViewJiJiangSuccess(JiJiangBean jiJiangBean) {

    }

    @Override
    public void UserViewJiJiangError(Throwable e) {

    }

    @Override
    public void UserViewReMenSuccess(ReMenBean reMenBean) {

    }

    @Override
    public void UserViewReMenError(Throwable e) {

    }

    @Override
    public void UserViewTuiJianSuccess(TuiJianBean tuiJianBean) {

    }

    @Override
    public void UserViewTuiJianError(Throwable e) {

    }

    @Override
    public void UserViewFuJinSuccess(FuJinBean fuJinBean) {

    }

    @Override
    public void UserViewFuJinError(Throwable e) {

    }

    @Override
    public void UserViewXiangQingSuccess(XiangQingBean xiangQingBean) {

    }

    @Override
    public void UserViewXiangQingError(String e) {

    }

    @Override
    public void UserViewJieShaoSuccess(JieShaoBean jieShaoBean) {

    }

    @Override
    public void UserViewJieShaoError(String e) {

    }

    @Override
    public void UserViewJuZhaoSuccess(JuZhaoBean juZhaoBean) {

    }

    @Override
    public void UserViewJuZhaoError(String e) {

    }

    @Override
    public void UserViewYuBaoSuccess(YuBaoBean yuBaoBean) {

    }

    @Override
    public void UserViewYuBaoError(String e) {

    }

    @Override
    public void UserViewYingPingSuccess(YingPingBean yingPingBean) {

    }

    @Override
    public void UserViewYingPingError(String e) {

    }

    @Override
    public void UserViewPaiQiSuccess(ScheduleBean scheduleBean) {

    }

    @Override
    public void UserViewPaiQiError(String e) {

    }

    @Override
    public void UserViewTimeSuccess(TimeBean timeBean) {

    }

    @Override
    public void UserViewTimeError(String e) {

    }

    @Override
    public void UserViewMingXiSuccess(MingXiBean mingXiBean) {

    }

    @Override
    public void UserViewMingXiErroe(String e) {

    }

    @Override
    public void UserViewQuYuSuccess(QuYuBean quYuBean) {

    }

    @Override
    public void UserViewQuYuError(String e) {

    }

    @Override
    public void UserViewPaiQiLieBiaoSuccess(PaiQiLieBiaoBean paiQiLieBiaoBean) {

    }

    @Override
    public void UserViewPaiQiLieBiaoError(String e) {

    }

    @Override
    public void UserViewChaXunZuoWeiSuccess(ChaXunZuoWeiBean chaXunZuoWeiBean) {

    }

    @Override
    public void UserViewChaXunZuoWeiError(String e) {

    }




}
