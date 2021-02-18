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

package com.liferay.samples.fbo.big.titles.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BigTitle}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BigTitle
 * @generated
 */
public class BigTitleWrapper
	extends BaseModelWrapper<BigTitle>
	implements BigTitle, ModelWrapper<BigTitle> {

	public BigTitleWrapper(BigTitle bigTitle) {
		super(bigTitle);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bigTitleId", getBigTitleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("articlePK", getArticlePK());
		attributes.put("title", getTitle());
		attributes.put("languageId", getLanguageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bigTitleId = (Long)attributes.get("bigTitleId");

		if (bigTitleId != null) {
			setBigTitleId(bigTitleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long articlePK = (Long)attributes.get("articlePK");

		if (articlePK != null) {
			setArticlePK(articlePK);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}
	}

	/**
	 * Returns the article pk of this big title.
	 *
	 * @return the article pk of this big title
	 */
	@Override
	public long getArticlePK() {
		return model.getArticlePK();
	}

	/**
	 * Returns the big title ID of this big title.
	 *
	 * @return the big title ID of this big title
	 */
	@Override
	public long getBigTitleId() {
		return model.getBigTitleId();
	}

	/**
	 * Returns the company ID of this big title.
	 *
	 * @return the company ID of this big title
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the language ID of this big title.
	 *
	 * @return the language ID of this big title
	 */
	@Override
	public String getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the primary key of this big title.
	 *
	 * @return the primary key of this big title
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this big title.
	 *
	 * @return the title of this big title
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the article pk of this big title.
	 *
	 * @param articlePK the article pk of this big title
	 */
	@Override
	public void setArticlePK(long articlePK) {
		model.setArticlePK(articlePK);
	}

	/**
	 * Sets the big title ID of this big title.
	 *
	 * @param bigTitleId the big title ID of this big title
	 */
	@Override
	public void setBigTitleId(long bigTitleId) {
		model.setBigTitleId(bigTitleId);
	}

	/**
	 * Sets the company ID of this big title.
	 *
	 * @param companyId the company ID of this big title
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the language ID of this big title.
	 *
	 * @param languageId the language ID of this big title
	 */
	@Override
	public void setLanguageId(String languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the primary key of this big title.
	 *
	 * @param primaryKey the primary key of this big title
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this big title.
	 *
	 * @param title the title of this big title
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	protected BigTitleWrapper wrap(BigTitle bigTitle) {
		return new BigTitleWrapper(bigTitle);
	}

}