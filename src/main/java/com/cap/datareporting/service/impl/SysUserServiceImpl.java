package com.cap.datareporting.service.impl;

import com.cap.datareporting.dao.SysUserMapper;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.SysUserExample;
import com.cap.datareporting.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mz
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

//    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 登陆使用
     *
     * @param username
     * @return
     */
    @Override
    public SysUser findByUsername(String username) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> userList = sysUserMapper.selectByExample(example);
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(SysUser user) {
        return sysUserMapper.insert(user);
    }

}
