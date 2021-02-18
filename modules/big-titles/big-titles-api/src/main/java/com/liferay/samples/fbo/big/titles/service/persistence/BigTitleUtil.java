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

package com.liferay.samples.fbo.big.titles.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.samples.fbo.big.titles.model.BigTitle;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the big title service. This utility wraps <code>com.liferay.samples.fbo.big.titles.service.persistence.impl.BigTitlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BigTitlePersistence
 * @generated
 */
public class BigTitleUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BigTitle bigTitle) {
		getPersistence().clearCache(bigTitle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BigTitle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BigTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BigTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BigTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BigTitle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BigTitle update(BigTitle bigTitle) {
		return getPersistence().update(bigTitle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BigTitle update(
		BigTitle bigTitle, ServiceContext serviceContext) {

		return getPersistence().update(bigTitle, serviceContext);
	}

	/**
	 * Returns all the big titles where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @return the matching big titles
	 */
	public static List<BigTitle> findByArticlePK(long articlePK) {
		return getPersistence().findByArticlePK(articlePK);
	}

	/**
	 * Returns a range of all the big titles where articlePK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param articlePK the article pk
	 * @param start the lower bound of the range of big titles
	 * @param end the upper bound of the range of big titles (not inclusive)
	 * @return the range of matching big titles
	 */
	public static List<BigTitle> findByArticlePK(
		long articlePK, int start, int end) {

		return getPersistence().findByArticlePK(articlePK, start, end);
	}

	/**
	 * Returns an ordered range of all the big titles where articlePK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param articlePK the article pk
	 * @param start the lower bound of the range of big titles
	 * @param end the upper bound of the range of big titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching big titles
	 */
	public static List<BigTitle> findByArticlePK(
		long articlePK, int start, int end,
		OrderByComparator<BigTitle> orderByComparator) {

		return getPersistence().findByArticlePK(
			articlePK, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the big titles where articlePK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param articlePK the article pk
	 * @param start the lower bound of the range of big titles
	 * @param end the upper bound of the range of big titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching big titles
	 */
	public static List<BigTitle> findByArticlePK(
		long articlePK, int start, int end,
		OrderByComparator<BigTitle> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByArticlePK(
			articlePK, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	public static BigTitle findByArticlePK_First(
			long articlePK, OrderByComparator<BigTitle> orderByComparator)
		throws com.liferay.samples.fbo.big.titles.exception.
			NoSuchBigTitleException {

		return getPersistence().findByArticlePK_First(
			articlePK, orderByComparator);
	}

	/**
	 * Returns the first big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public static BigTitle fetchByArticlePK_First(
		long articlePK, OrderByComparator<BigTitle> orderByComparator) {

		return getPersistence().fetchByArticlePK_First(
			articlePK, orderByComparator);
	}

	/**
	 * Returns the last big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	public static BigTitle findByArticlePK_Last(
			long articlePK, OrderByComparator<BigTitle> orderByComparator)
		throws com.liferay.samples.fbo.big.titles.exception.
			NoSuchBigTitleException {

		return getPersistence().findByArticlePK_Last(
			articlePK, orderByComparator);
	}

	/**
	 * Returns the last big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public static BigTitle fetchByArticlePK_Last(
		long articlePK, OrderByComparator<BigTitle> orderByComparator) {

		return getPersistence().fetchByArticlePK_Last(
			articlePK, orderByComparator);
	}

	/**
	 * Returns the big titles before and after the current big title in the ordered set where articlePK = &#63;.
	 *
	 * @param bigTitleId the primary key of the current big title
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next big title
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	public static BigTitle[] findByArticlePK_PrevAndNext(
			long bigTitleId, long articlePK,
			OrderByComparator<BigTitle> orderByComparator)
		throws com.liferay.samples.fbo.big.titles.exception.
			NoSuchBigTitleException {

		return getPersistence().findByArticlePK_PrevAndNext(
			bigTitleId, articlePK, orderByComparator);
	}

	/**
	 * Removes all the big titles where articlePK = &#63; from the database.
	 *
	 * @param articlePK the article pk
	 */
	public static void removeByArticlePK(long articlePK) {
		getPersistence().removeByArticlePK(articlePK);
	}

	/**
	 * Returns the number of big titles where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @return the number of matching big titles
	 */
	public static int countByArticlePK(long articlePK) {
		return getPersistence().countByArticlePK(articlePK);
	}

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or throws a <code>NoSuchBigTitleException</code> if it could not be found.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	public static BigTitle findByB_T(long articlePK, String languageId)
		throws com.liferay.samples.fbo.big.titles.exception.
			NoSuchBigTitleException {

		return getPersistence().findByB_T(articlePK, languageId);
	}

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public static BigTitle fetchByB_T(long articlePK, String languageId) {
		return getPersistence().fetchByB_T(articlePK, languageId);
	}

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public static BigTitle fetchByB_T(
		long articlePK, String languageId, boolean useFinderCache) {

		return getPersistence().fetchByB_T(
			articlePK, languageId, useFinderCache);
	}

	/**
	 * Removes the big title where articlePK = &#63; and languageId = &#63; from the database.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the big title that was removed
	 */
	public static BigTitle removeByB_T(long articlePK, String languageId)
		throws com.liferay.samples.fbo.big.titles.exception.
			NoSuchBigTitleException {

		return getPersistence().removeByB_T(articlePK, languageId);
	}

	/**
	 * Returns the number of big titles where articlePK = &#63; and languageId = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the number of matching big titles
	 */
	public static int countByB_T(long articlePK, String languageId) {
		return getPersistence().countByB_T(articlePK, languageId);
	}

	/**
	 * Caches the big title in the entity cache if it is enabled.
	 *
	 * @param bigTitle the big title
	 */
	public static void cacheResult(BigTitle bigTitle) {
		getPersistence().cacheResult(bigTitle);
	}

	/**
	 * Caches the big titles in the entity cache if it is enabled.
	 *
	 * @param bigTitles the big titles
	 */
	public static void cacheResult(List<BigTitle> bigTitles) {
		getPersistence().cacheResult(bigTitles);
	}

	/**
	 * Creates a new big title with the primary key. Does not add the big title to the database.
	 *
	 * @param bigTitleId the primary key for the new big title
	 * @return the new big title
	 */
	public static BigTitle create(long bigTitleId) {
		return getPersistence().create(bigTitleId);
	}

	/**
	 * Removes the big title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title that was removed
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	public static BigTitle remove(long bigTitleId)
		throws com.liferay.samples.fbo.big.titles.exception.
			NoSuchBigTitleException {

		return getPersistence().remove(bigTitleId);
	}

	public static BigTitle updateImpl(BigTitle bigTitle) {
		return getPersistence().updateImpl(bigTitle);
	}

	/**
	 * Returns the big title with the primary key or throws a <code>NoSuchBigTitleException</code> if it could not be found.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	public static BigTitle findByPrimaryKey(long bigTitleId)
		throws com.liferay.samples.fbo.big.titles.exception.
			NoSuchBigTitleException {

		return getPersistence().findByPrimaryKey(bigTitleId);
	}

	/**
	 * Returns the big title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title, or <code>null</code> if a big title with the primary key could not be found
	 */
	public static BigTitle fetchByPrimaryKey(long bigTitleId) {
		return getPersistence().fetchByPrimaryKey(bigTitleId);
	}

	/**
	 * Returns all the big titles.
	 *
	 * @return the big titles
	 */
	public static List<BigTitle> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the big titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of big titles
	 * @param end the upper bound of the range of big titles (not inclusive)
	 * @return the range of big titles
	 */
	public static List<BigTitle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the big titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of big titles
	 * @param end the upper bound of the range of big titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of big titles
	 */
	public static List<BigTitle> findAll(
		int start, int end, OrderByComparator<BigTitle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the big titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BigTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of big titles
	 * @param end the upper bound of the range of big titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of big titles
	 */
	public static List<BigTitle> findAll(
		int start, int end, OrderByComparator<BigTitle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the big titles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of big titles.
	 *
	 * @return the number of big titles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BigTitlePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BigTitlePersistence, BigTitlePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BigTitlePersistence.class);

		ServiceTracker<BigTitlePersistence, BigTitlePersistence>
			serviceTracker =
				new ServiceTracker<BigTitlePersistence, BigTitlePersistence>(
					bundle.getBundleContext(), BigTitlePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}