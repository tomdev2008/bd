package com.changhong.bd.file.dao.impl;

import org.springframework.stereotype.Repository;

import com.changhong.bd.core.dao.impl.abs.MainHibernateDao;
import com.changhong.bd.file.dao.api.FileDao;
import com.changhong.bd.file.entity.FileEntity;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月30日
 * @description
 *
 */
@Repository
public class FileDaoImpl extends MainHibernateDao<FileEntity, String>
	implements FileDao{

}
