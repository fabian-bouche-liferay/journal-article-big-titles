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

package com.liferay.samples.fbo.big.titles.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.samples.fbo.big.titles.model.BigTitle;
import com.liferay.samples.fbo.big.titles.model.BigTitleModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the BigTitle service. Represents a row in the &quot;BIGTITLE_BigTitle&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BigTitleModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BigTitleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BigTitleImpl
 * @generated
 */
public class BigTitleModelImpl
	extends BaseModelImpl<BigTitle> implements BigTitleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a big title model instance should use the <code>BigTitle</code> interface instead.
	 */
	public static final String TABLE_NAME = "BIGTITLE_BigTitle";

	public static final Object[][] TABLE_COLUMNS = {
		{"bigTitleId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"articlePK", Types.BIGINT}, {"title", Types.VARCHAR},
		{"languageId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("bigTitleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("articlePK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table BIGTITLE_BigTitle (bigTitleId LONG not null primary key,companyId LONG,articlePK LONG,title STRING null,languageId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table BIGTITLE_BigTitle";

	public static final String ORDER_BY_JPQL =
		" ORDER BY bigTitle.bigTitleId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY BIGTITLE_BigTitle.bigTitleId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long ARTICLEPK_COLUMN_BITMASK = 1L;

	public static final long LANGUAGEID_COLUMN_BITMASK = 2L;

	public static final long BIGTITLEID_COLUMN_BITMASK = 4L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public BigTitleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bigTitleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBigTitleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bigTitleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BigTitle.class;
	}

	@Override
	public String getModelClassName() {
		return BigTitle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BigTitle, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BigTitle, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BigTitle, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((BigTitle)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BigTitle, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BigTitle, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BigTitle)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BigTitle, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BigTitle, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, BigTitle>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			BigTitle.class.getClassLoader(), BigTitle.class,
			ModelWrapper.class);

		try {
			Constructor<BigTitle> constructor =
				(Constructor<BigTitle>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<BigTitle, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BigTitle, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BigTitle, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<BigTitle, Object>>();
		Map<String, BiConsumer<BigTitle, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BigTitle, ?>>();

		attributeGetterFunctions.put("bigTitleId", BigTitle::getBigTitleId);
		attributeSetterBiConsumers.put(
			"bigTitleId", (BiConsumer<BigTitle, Long>)BigTitle::setBigTitleId);
		attributeGetterFunctions.put("companyId", BigTitle::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<BigTitle, Long>)BigTitle::setCompanyId);
		attributeGetterFunctions.put("articlePK", BigTitle::getArticlePK);
		attributeSetterBiConsumers.put(
			"articlePK", (BiConsumer<BigTitle, Long>)BigTitle::setArticlePK);
		attributeGetterFunctions.put("title", BigTitle::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<BigTitle, String>)BigTitle::setTitle);
		attributeGetterFunctions.put("languageId", BigTitle::getLanguageId);
		attributeSetterBiConsumers.put(
			"languageId",
			(BiConsumer<BigTitle, String>)BigTitle::setLanguageId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getBigTitleId() {
		return _bigTitleId;
	}

	@Override
	public void setBigTitleId(long bigTitleId) {
		_bigTitleId = bigTitleId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getArticlePK() {
		return _articlePK;
	}

	@Override
	public void setArticlePK(long articlePK) {
		_columnBitmask |= ARTICLEPK_COLUMN_BITMASK;

		if (!_setOriginalArticlePK) {
			_setOriginalArticlePK = true;

			_originalArticlePK = _articlePK;
		}

		_articlePK = articlePK;
	}

	public long getOriginalArticlePK() {
		return _originalArticlePK;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (_originalLanguageId == null) {
			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public String getOriginalLanguageId() {
		return GetterUtil.getString(_originalLanguageId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), BigTitle.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BigTitle toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BigTitle>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BigTitleImpl bigTitleImpl = new BigTitleImpl();

		bigTitleImpl.setBigTitleId(getBigTitleId());
		bigTitleImpl.setCompanyId(getCompanyId());
		bigTitleImpl.setArticlePK(getArticlePK());
		bigTitleImpl.setTitle(getTitle());
		bigTitleImpl.setLanguageId(getLanguageId());

		bigTitleImpl.resetOriginalValues();

		return bigTitleImpl;
	}

	@Override
	public int compareTo(BigTitle bigTitle) {
		long primaryKey = bigTitle.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BigTitle)) {
			return false;
		}

		BigTitle bigTitle = (BigTitle)object;

		long primaryKey = bigTitle.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		_originalArticlePK = _articlePK;

		_setOriginalArticlePK = false;

		_originalLanguageId = _languageId;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<BigTitle> toCacheModel() {
		BigTitleCacheModel bigTitleCacheModel = new BigTitleCacheModel();

		bigTitleCacheModel.bigTitleId = getBigTitleId();

		bigTitleCacheModel.companyId = getCompanyId();

		bigTitleCacheModel.articlePK = getArticlePK();

		bigTitleCacheModel.title = getTitle();

		String title = bigTitleCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			bigTitleCacheModel.title = null;
		}

		bigTitleCacheModel.languageId = getLanguageId();

		String languageId = bigTitleCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			bigTitleCacheModel.languageId = null;
		}

		return bigTitleCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BigTitle, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BigTitle, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BigTitle, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((BigTitle)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<BigTitle, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<BigTitle, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BigTitle, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((BigTitle)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, BigTitle>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _bigTitleId;
	private long _companyId;
	private long _articlePK;
	private long _originalArticlePK;
	private boolean _setOriginalArticlePK;
	private String _title;
	private String _languageId;
	private String _originalLanguageId;
	private long _columnBitmask;
	private BigTitle _escapedModel;

}