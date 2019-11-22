package com.bw.movie.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
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
import com.bw.mvp_library.util.Logger;
import com.bw.mvp_library.util.ToastUtils;

import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @describe(描述)：RegisterActivity 注册页面
 * @data（日期）: 2019/11/12
 * @time（时间）: 13:58
 * @author（作者）: Liuhe
 **/
public class RegisterActivity extends BaseActivity<UserPresenter> implements UserContract.UserView {

    public static final String TAG="RegisterActivity";

    @BindView(R.id.edit_yonghu)
    EditText editYonghu;
    @BindView(R.id.edit_youxiang)
    EditText editYouxiang;
    @BindView(R.id.edit_mima)
    EditText editMima;
    @BindView(R.id.edit_yanzhengma)
    EditText editYanzhengma;
    @BindView(R.id.btn_fasong)
    Button btnFasong;
    @BindView(R.id.btn_zhuce)
    Button btnZhuce;
    @BindView(R.id.yiyou)
    TextView yiyou;

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void UserViewLoginSuccess(LoginBean data) {

    }

    @Override
    public void UserViewLoginError(Throwable e) {

    }

    //注册
    @Override
    public void UserViewRegisterSuccess(RegisterBean data) {
        String message = data.getMessage();
        if (message.equals(data.getStatus())){
            ToastUtils.init(this);
            ToastUtils.show(data.getMessage());
            startActivity(new Intent(RegisterActivity.this,MovieActivity.class));
        }else {
            ToastUtils.init(this);
            ToastUtils.show(data.getMessage());
        }
    }

    @Override
    public void UserViewRegisterError(Throwable e) {

    }

    @Override
    public void UserViewEmailSuccess(EmailBean data) {

        Logger.e(TAG,data.getMessage());
            //Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
            ToastUtils.init(this);
            ToastUtils.show(data.getMessage());
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


    @OnClick({R.id.edit_yonghu, R.id.edit_youxiang, R.id.edit_mima, R.id.edit_yanzhengma, R.id.btn_fasong, R.id.yiyou, R.id.btn_zhuce})
    public void onViewClicked(View view) {
        String yonghu = editYonghu.getText().toString();
        String youxiang = editYouxiang.getText().toString();
        String yanzheng = editYanzhengma.getText().toString();
        String mima = editMima.getText().toString();

        String encrypt = EncryptUtil.encrypt(mima);
        switch (view.getId()) {
            case R.id.edit_yonghu:
                break;
            case R.id.edit_youxiang:
                break;
            case R.id.edit_mima:
                break;
            case R.id.edit_yanzhengma:
                break;
            case R.id.btn_fasong:
                presenter.UserPresenterEmail(youxiang);

                Log.d(TAG, "onViewClicked: "+youxiang);
                break;
            case R.id.yiyou:
                //已有账号，立即登录
                startActivity(new Intent(RegisterActivity.this,MovieActivity.class));
                break;
            case R.id.btn_zhuce:
                if (!TextUtils.isEmpty(yonghu)&&!TextUtils.isEmpty(youxiang)&&!TextUtils.isEmpty(mima)&&!TextUtils.isEmpty(yanzheng)){
                    try {
                        yonghu = URLEncoder.encode(yonghu,"utf-8");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    presenter.UserPresenterRegister(yonghu,encrypt,youxiang,yanzheng);
                }else {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
