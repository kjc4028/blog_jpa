package com.dev.jpa.common;

import javax.servlet.http.HttpServletRequest;

import com.dev.jpa.usr.entity.UsrEntity;

public class CommonUtil {

	/**
	 * 세션으로 부터 로그인한 사용자의 아이디를 추출하여 엔티티에 저장
	 * @param request
	 * @return
	 */
	public static UsrEntity getUserIdFromSession(HttpServletRequest request) {
			UsrEntity usrEntity = new UsrEntity();
			usrEntity.setUsrId(request.getRemoteUser());
			return usrEntity;
	}
}
