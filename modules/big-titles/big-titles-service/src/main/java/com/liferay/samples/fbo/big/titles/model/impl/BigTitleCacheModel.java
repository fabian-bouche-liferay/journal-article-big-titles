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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.samples.fbo.big.titles.model.BigTitle;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BigTitle in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BigTitleCacheModel
	implements CacheModel<BigTitle>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BigTitleCacheModel)) {
			return false;
		}

		BigTitleCacheModel bigTitleCacheModel = (BigTitleCacheModel)object;

		if (bigTitleId == bigTitleCacheModel.bigTitleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bigTitleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{bigTitleId=");
		sb.append(bigTitleId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", articlePK=");
		sb.append(articlePK);
		sb.append(", title=");
		sb.append(title);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BigTitle toEntityModel() {
		BigTitleImpl bigTitleImpl = new BigTitleImpl();

		bigTitleImpl.setBigTitleId(bigTitleId);
		bigTitleImpl.setCompanyId(companyId);
		bigTitleImpl.setArticlePK(articlePK);

		if (title == null) {
			bigTitleImpl.setTitle("");
		}
		else {
			bigTitleImpl.setTitle(title);
		}

		if (languageId == null) {
			bigTitleImpl.setLanguageId("");
		}
		else {
			bigTitleImpl.setLanguageId(languageId);
		}

		bigTitleImpl.resetOriginalValues();

		return bigTitleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bigTitleId = objectInput.readLong();

		companyId = objectInput.readLong();

		articlePK = objectInput.readLong();
		title = objectInput.readUTF();
		languageId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(bigTitleId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(articlePK);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (languageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languageId);
		}
	}

	public long bigTitleId;
	public long companyId;
	public long articlePK;
	public String title;
	public String languageId;

}