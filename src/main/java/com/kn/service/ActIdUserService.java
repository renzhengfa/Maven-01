package com.kn.service;

import com.kn.bean.Act_id_user;

/**
 * Act_id_user服务层
 */

public interface ActIdUserService {

    Act_id_user queryAct_id_userByUsernameAndPassword(String username, String password);

}
