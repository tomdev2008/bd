package com.changhong.bd.core.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.entity.SysAuthButtonEntity;
import com.changhong.bd.core.entity.SysAuthColumnEntity;
import com.changhong.bd.core.entity.SysAuthMenuEntity;
import com.changhong.bd.core.entity.SysAuthRowEntity;
import com.changhong.bd.core.entity.SysPositionEntity;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.core.utils.Encodes;

/**
 * @author 漆尧 yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description :Shiro权限系统Realm 
 */
public class BdShiroRealm extends AuthorizingRealm {

	protected SysAccountService sysAccountService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysAccountEntity user = sysAccountService.queryUserByLoginName(token.getUsername());
		if (user != null) {
			logger.info("Sign Id:"+user.getId());
			if (user.getStatus() == 0) {
				throw new DisabledAccountException();
			}
			Subject currUser = SecurityUtils.getSubject();
			SysAccountDto dto = sysAccountService.queryById(user.getId());

			if (user.getStatus() == 0) {
				throw new DisabledAccountException();
			}
			byte[] salt = Encodes.decodeHex(user.getSalt());
			currUser.getSession().setAttribute("currentUser", new ShiroUser(user.getLoginName(), dto.getName(), user.getId()));

			// TODO column auth
			// List<AuthColumn> authColumns=new ArrayList<AuthColumn>();
			// AuthColumnService authColumnService = new AuthColumnService();
			// authColumns=authColumnService.checkAllAuthColumn(user);
			// currUser.getSession().setAttribute("authColumns", authColumns);

			// TODO column row auth
			// List<AuthRow> authRows=new ArrayList<AuthRow>();
			// AuthRowService authRowService = new AuthRowService();
			// authRows=authRowService.checkAllAuthRow(user);
			// currUser.getSession().setAttribute("authRows", authRows);
			return new SimpleAuthenticationInfo(new ShiroUser(user.getLoginName(), user.getLoginName(), user.getId()), user.getPassword(),
					ByteSource.Util.bytes(salt), getName());
			// return new SimpleAuthenticationInfo(shiroUser, user.getPassword(), getName());
		} else {
			return null;
		}

	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		SysAccountEntity user = sysAccountService.queryUserByLoginName(shiroUser.loginName);
		if (user != null && user.getPositions() != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (SysPositionEntity p : user.getPositions()) {
				info.addRole(shiroUser.loginName);
				List<SysAuthButtonEntity> btns = p.getAuthButtons();
				for (SysAuthButtonEntity btn : btns) {
					info.addStringPermission(btn.getCode());
				}

				List<SysAuthColumnEntity> cols = p.getAuthColumn();
				for (SysAuthColumnEntity col : cols) {
					info.addStringPermission(col.getCode());
				}

				List<SysAuthMenuEntity> menus = p.getAuthMenus();
				for (SysAuthMenuEntity menu : menus) {
					info.addStringPermission(menu.getCode());
				}

				List<SysAuthRowEntity> rows = p.getAuthRow();
				for (SysAuthRowEntity row : rows) {
					info.addStringPermission(row.getCode());
				}
			}
			return info;
		}

		return null;
	}

	@Autowired
	public void setSysUserService(SysAccountService sysAccountService) {
		this.sysAccountService = sysAccountService;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public String loginName;
		public String name;
		public String id;

		public ShiroUser(String loginName, String name, String id) {
			this.loginName = loginName;
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ShiroUser other = (ShiroUser) obj;
			if (loginName == null) {
				if (other.loginName != null)
					return false;
			} else if (!loginName.equals(other.loginName))
				return false;
			return true;
		}
	}

	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SysAccountService.HASH_ALGORITHM);
		matcher.setHashIterations(SysAccountService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}

	public void setSysAccountService(SysAccountService sysAccountService) {
		this.sysAccountService = sysAccountService;
	}

}
