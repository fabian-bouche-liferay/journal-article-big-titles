/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.samples.fbo.big.titles.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.samples.fbo.big.titles.model.BigTitle;
import com.liferay.samples.fbo.big.titles.service.base.BigTitleLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the big title local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.samples.fbo.big.titles.service.BigTitleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BigTitleLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.samples.fbo.big.titles.model.BigTitle",
	service = AopService.class
)
public class BigTitleLocalServiceImpl extends BigTitleLocalServiceBaseImpl {

	public BigTitle upsertBigTitle(long companyId, long articlePK, String languageId, String title) {
		
		BigTitle bigTitle = getBigTitle(articlePK, languageId); 
		
		if(bigTitle == null) {
			long bigTitleId = counterLocalService.increment();
			bigTitle = bigTitlePersistence.create(bigTitleId);
			bigTitle.setArticlePK(articlePK);
			bigTitle.setCompanyId(companyId);
			bigTitle.setLanguageId(languageId);
			bigTitle.setTitle(title);
			bigTitle.setNew(true);
			bigTitlePersistence.update(bigTitle);
		}
		
		return bigTitle;
		
	}
	
	public BigTitle getBigTitle(long articlePK, String languageId) {
		return bigTitlePersistence.fetchByB_T(articlePK, languageId);
	}
	
}