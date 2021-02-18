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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BigTitleSoap implements Serializable {

	public static BigTitleSoap toSoapModel(BigTitle model) {
		BigTitleSoap soapModel = new BigTitleSoap();

		soapModel.setBigTitleId(model.getBigTitleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setArticlePK(model.getArticlePK());
		soapModel.setTitle(model.getTitle());
		soapModel.setLanguageId(model.getLanguageId());

		return soapModel;
	}

	public static BigTitleSoap[] toSoapModels(BigTitle[] models) {
		BigTitleSoap[] soapModels = new BigTitleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BigTitleSoap[][] toSoapModels(BigTitle[][] models) {
		BigTitleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BigTitleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BigTitleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BigTitleSoap[] toSoapModels(List<BigTitle> models) {
		List<BigTitleSoap> soapModels = new ArrayList<BigTitleSoap>(
			models.size());

		for (BigTitle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BigTitleSoap[soapModels.size()]);
	}

	public BigTitleSoap() {
	}

	public long getPrimaryKey() {
		return _bigTitleId;
	}

	public void setPrimaryKey(long pk) {
		setBigTitleId(pk);
	}

	public long getBigTitleId() {
		return _bigTitleId;
	}

	public void setBigTitleId(long bigTitleId) {
		_bigTitleId = bigTitleId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getArticlePK() {
		return _articlePK;
	}

	public void setArticlePK(long articlePK) {
		_articlePK = articlePK;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	private long _bigTitleId;
	private long _companyId;
	private long _articlePK;
	private String _title;
	private String _languageId;

}