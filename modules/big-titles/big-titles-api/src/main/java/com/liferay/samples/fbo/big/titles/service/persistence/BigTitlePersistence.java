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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.samples.fbo.big.titles.exception.NoSuchBigTitleException;
import com.liferay.samples.fbo.big.titles.model.BigTitle;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the big title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BigTitleUtil
 * @generated
 */
@ProviderType
public interface BigTitlePersistence extends BasePersistence<BigTitle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BigTitleUtil} to access the big title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the big titles where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @return the matching big titles
	 */
	public java.util.List<BigTitle> findByArticlePK(long articlePK);

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
	public java.util.List<BigTitle> findByArticlePK(
		long articlePK, int start, int end);

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
	public java.util.List<BigTitle> findByArticlePK(
		long articlePK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
			orderByComparator);

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
	public java.util.List<BigTitle> findByArticlePK(
		long articlePK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	public BigTitle findByArticlePK_First(
			long articlePK,
			com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
				orderByComparator)
		throws NoSuchBigTitleException;

	/**
	 * Returns the first big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public BigTitle fetchByArticlePK_First(
		long articlePK,
		com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
			orderByComparator);

	/**
	 * Returns the last big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	public BigTitle findByArticlePK_Last(
			long articlePK,
			com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
				orderByComparator)
		throws NoSuchBigTitleException;

	/**
	 * Returns the last big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public BigTitle fetchByArticlePK_Last(
		long articlePK,
		com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
			orderByComparator);

	/**
	 * Returns the big titles before and after the current big title in the ordered set where articlePK = &#63;.
	 *
	 * @param bigTitleId the primary key of the current big title
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next big title
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	public BigTitle[] findByArticlePK_PrevAndNext(
			long bigTitleId, long articlePK,
			com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
				orderByComparator)
		throws NoSuchBigTitleException;

	/**
	 * Removes all the big titles where articlePK = &#63; from the database.
	 *
	 * @param articlePK the article pk
	 */
	public void removeByArticlePK(long articlePK);

	/**
	 * Returns the number of big titles where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @return the number of matching big titles
	 */
	public int countByArticlePK(long articlePK);

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or throws a <code>NoSuchBigTitleException</code> if it could not be found.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	public BigTitle findByB_T(long articlePK, String languageId)
		throws NoSuchBigTitleException;

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public BigTitle fetchByB_T(long articlePK, String languageId);

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching big title, or <code>null</code> if a matching big title could not be found
	 */
	public BigTitle fetchByB_T(
		long articlePK, String languageId, boolean useFinderCache);

	/**
	 * Removes the big title where articlePK = &#63; and languageId = &#63; from the database.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the big title that was removed
	 */
	public BigTitle removeByB_T(long articlePK, String languageId)
		throws NoSuchBigTitleException;

	/**
	 * Returns the number of big titles where articlePK = &#63; and languageId = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the number of matching big titles
	 */
	public int countByB_T(long articlePK, String languageId);

	/**
	 * Caches the big title in the entity cache if it is enabled.
	 *
	 * @param bigTitle the big title
	 */
	public void cacheResult(BigTitle bigTitle);

	/**
	 * Caches the big titles in the entity cache if it is enabled.
	 *
	 * @param bigTitles the big titles
	 */
	public void cacheResult(java.util.List<BigTitle> bigTitles);

	/**
	 * Creates a new big title with the primary key. Does not add the big title to the database.
	 *
	 * @param bigTitleId the primary key for the new big title
	 * @return the new big title
	 */
	public BigTitle create(long bigTitleId);

	/**
	 * Removes the big title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title that was removed
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	public BigTitle remove(long bigTitleId) throws NoSuchBigTitleException;

	public BigTitle updateImpl(BigTitle bigTitle);

	/**
	 * Returns the big title with the primary key or throws a <code>NoSuchBigTitleException</code> if it could not be found.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	public BigTitle findByPrimaryKey(long bigTitleId)
		throws NoSuchBigTitleException;

	/**
	 * Returns the big title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title, or <code>null</code> if a big title with the primary key could not be found
	 */
	public BigTitle fetchByPrimaryKey(long bigTitleId);

	/**
	 * Returns all the big titles.
	 *
	 * @return the big titles
	 */
	public java.util.List<BigTitle> findAll();

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
	public java.util.List<BigTitle> findAll(int start, int end);

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
	public java.util.List<BigTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
			orderByComparator);

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
	public java.util.List<BigTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BigTitle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the big titles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of big titles.
	 *
	 * @return the number of big titles
	 */
	public int countAll();

}