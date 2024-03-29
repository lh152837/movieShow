package movie;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bw.movie.green.GreenBean;

import movie.GreenBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig greenBeanDaoConfig;

    private final GreenBeanDao greenBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        greenBeanDaoConfig = daoConfigMap.get(GreenBeanDao.class).clone();
        greenBeanDaoConfig.initIdentityScope(type);

        greenBeanDao = new GreenBeanDao(greenBeanDaoConfig, this);

        registerDao(GreenBean.class, greenBeanDao);
    }
    
    public void clear() {
        greenBeanDaoConfig.clearIdentityScope();
    }

    public GreenBeanDao getGreenBeanDao() {
        return greenBeanDao;
    }

}
