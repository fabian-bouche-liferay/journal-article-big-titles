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

package com.liferay.samples.fbo.big.titles.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BigTitleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BigTitleLocalService
 * @generated
 */
public class BigTitleLocalServiceWrapper
	implements BigTitleLocalService, ServiceWrapper<BigTitleLocalService> {

	public BigTitleLocalServiceWrapper(
		BigTitleLocalService bigTitleLocalService) {

		_bigTitleLocalService = bigTitleLocalService;
	}

	/**
	 * Adds the big title to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BigTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bigTitle the big title
	 * @return the big title that was added
	 */
	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle addBigTitle(
		com.liferay.samples.fbo.big.titles.model.BigTitle bigTitle) {

		return _bigTitleLocalService.addBigTitle(bigTitle);
	}

	/**
	 * Creates a new big title with the primary key. Does not add the big title to the database.
	 *
	 * @param bigTitleId the primary key for the new big title
	 * @return the new big title
	 */
	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle createBigTitle(
		long bigTitleId) {

		return _bigTitleLocalService.createBigTitle(bigTitleId);
	}

	/**
	 * Deletes the big title from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BigTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bigTitle the big title
	 * @return the big title that was removed
	 */
	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle deleteBigTitle(
		com.liferay.samples.fbo.big.titles.model.BigTitle bigTitle) {

		return _bigTitleLocalService.deleteBigTitle(bigTitle);
	}

	/**
	 * Deletes the big title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BigTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title that was removed
	 * @throws PortalException if a big title with the primary key could not be found
	 */
	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle deleteBigTitle(
			long bigTitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bigTitleLocalService.deleteBigTitle(bigTitleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bigTitleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bigTitleLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bigTitleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.big.titles.model.impl.BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bigTitleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.big.titles.model.impl.BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bigTitleLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bigTitleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _bigTitleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle fetchBigTitle(
		long bigTitleId) {

		return _bigTitleLocalService.fetchBigTitle(bigTitleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bigTitleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the big title with the primary key.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title
	 * @throws PortalException if a big title with the primary key could not be found
	 */
	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle getBigTitle(
			long bigTitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bigTitleLocalService.getBigTitle(bigTitleId);
	}

	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle getBigTitle(
		long articlePK, String languageId) {

		return _bigTitleLocalService.getBigTitle(articlePK, languageId);
	}

	/**
	 * Returns a range of all the big titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.big.titles.model.impl.BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of big titles
	 * @param end the upper bound of the range of big titles (not inclusive)
	 * @return the range of big titles
	 */
	@Override
	public java.util.List<com.liferay.samples.fbo.big.titles.model.BigTitle>
		getBigTitles(int start, int end) {

		return _bigTitleLocalService.getBigTitles(start, end);
	}

	/**
	 * Returns the number of big titles.
	 *
	 * @return the number of big titles
	 */
	@Override
	public int getBigTitlesCount() {
		return _bigTitleLocalService.getBigTitlesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bigTitleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bigTitleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bigTitleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the big title in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BigTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bigTitle the big title
	 * @return the big title that was updated
	 */
	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle updateBigTitle(
		com.liferay.samples.fbo.big.titles.model.BigTitle bigTitle) {

		return _bigTitleLocalService.updateBigTitle(bigTitle);
	}

	@Override
	public com.liferay.samples.fbo.big.titles.model.BigTitle upsertBigTitle(
		long companyId, long articlePK, String languageId, String title) {

		return _bigTitleLocalService.upsertBigTitle(
			companyId, articlePK, languageId, title);
	}

	@Override
	public BigTitleLocalService getWrappedService() {
		return _bigTitleLocalService;
	}

	@Override
	public void setWrappedService(BigTitleLocalService bigTitleLocalService) {
		_bigTitleLocalService = bigTitleLocalService;
	}

	private BigTitleLocalService _bigTitleLocalService;

}