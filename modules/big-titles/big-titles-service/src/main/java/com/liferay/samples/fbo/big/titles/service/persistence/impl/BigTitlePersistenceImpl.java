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

package com.liferay.samples.fbo.big.titles.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.samples.fbo.big.titles.exception.NoSuchBigTitleException;
import com.liferay.samples.fbo.big.titles.model.BigTitle;
import com.liferay.samples.fbo.big.titles.model.impl.BigTitleImpl;
import com.liferay.samples.fbo.big.titles.model.impl.BigTitleModelImpl;
import com.liferay.samples.fbo.big.titles.service.persistence.BigTitlePersistence;
import com.liferay.samples.fbo.big.titles.service.persistence.impl.constants.BIGTITLEPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the big title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BigTitlePersistence.class)
public class BigTitlePersistenceImpl
	extends BasePersistenceImpl<BigTitle> implements BigTitlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BigTitleUtil</code> to access the big title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BigTitleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByArticlePK;
	private FinderPath _finderPathWithoutPaginationFindByArticlePK;
	private FinderPath _finderPathCountByArticlePK;

	/**
	 * Returns all the big titles where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @return the matching big titles
	 */
	@Override
	public List<BigTitle> findByArticlePK(long articlePK) {
		return findByArticlePK(
			articlePK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BigTitle> findByArticlePK(long articlePK, int start, int end) {
		return findByArticlePK(articlePK, start, end, null);
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
	@Override
	public List<BigTitle> findByArticlePK(
		long articlePK, int start, int end,
		OrderByComparator<BigTitle> orderByComparator) {

		return findByArticlePK(articlePK, start, end, orderByComparator, true);
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
	@Override
	public List<BigTitle> findByArticlePK(
		long articlePK, int start, int end,
		OrderByComparator<BigTitle> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByArticlePK;
				finderArgs = new Object[] {articlePK};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByArticlePK;
			finderArgs = new Object[] {
				articlePK, start, end, orderByComparator
			};
		}

		List<BigTitle> list = null;

		if (useFinderCache) {
			list = (List<BigTitle>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BigTitle bigTitle : list) {
					if (articlePK != bigTitle.getArticlePK()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BIGTITLE_WHERE);

			sb.append(_FINDER_COLUMN_ARTICLEPK_ARTICLEPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BigTitleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articlePK);

				list = (List<BigTitle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	@Override
	public BigTitle findByArticlePK_First(
			long articlePK, OrderByComparator<BigTitle> orderByComparator)
		throws NoSuchBigTitleException {

		BigTitle bigTitle = fetchByArticlePK_First(
			articlePK, orderByComparator);

		if (bigTitle != null) {
			return bigTitle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("articlePK=");
		sb.append(articlePK);

		sb.append("}");

		throw new NoSuchBigTitleException(sb.toString());
	}

	/**
	 * Returns the first big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching big title, or <code>null</code> if a matching big title could not be found
	 */
	@Override
	public BigTitle fetchByArticlePK_First(
		long articlePK, OrderByComparator<BigTitle> orderByComparator) {

		List<BigTitle> list = findByArticlePK(
			articlePK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	@Override
	public BigTitle findByArticlePK_Last(
			long articlePK, OrderByComparator<BigTitle> orderByComparator)
		throws NoSuchBigTitleException {

		BigTitle bigTitle = fetchByArticlePK_Last(articlePK, orderByComparator);

		if (bigTitle != null) {
			return bigTitle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("articlePK=");
		sb.append(articlePK);

		sb.append("}");

		throw new NoSuchBigTitleException(sb.toString());
	}

	/**
	 * Returns the last big title in the ordered set where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching big title, or <code>null</code> if a matching big title could not be found
	 */
	@Override
	public BigTitle fetchByArticlePK_Last(
		long articlePK, OrderByComparator<BigTitle> orderByComparator) {

		int count = countByArticlePK(articlePK);

		if (count == 0) {
			return null;
		}

		List<BigTitle> list = findByArticlePK(
			articlePK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BigTitle[] findByArticlePK_PrevAndNext(
			long bigTitleId, long articlePK,
			OrderByComparator<BigTitle> orderByComparator)
		throws NoSuchBigTitleException {

		BigTitle bigTitle = findByPrimaryKey(bigTitleId);

		Session session = null;

		try {
			session = openSession();

			BigTitle[] array = new BigTitleImpl[3];

			array[0] = getByArticlePK_PrevAndNext(
				session, bigTitle, articlePK, orderByComparator, true);

			array[1] = bigTitle;

			array[2] = getByArticlePK_PrevAndNext(
				session, bigTitle, articlePK, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BigTitle getByArticlePK_PrevAndNext(
		Session session, BigTitle bigTitle, long articlePK,
		OrderByComparator<BigTitle> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BIGTITLE_WHERE);

		sb.append(_FINDER_COLUMN_ARTICLEPK_ARTICLEPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BigTitleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(articlePK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(bigTitle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BigTitle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the big titles where articlePK = &#63; from the database.
	 *
	 * @param articlePK the article pk
	 */
	@Override
	public void removeByArticlePK(long articlePK) {
		for (BigTitle bigTitle :
				findByArticlePK(
					articlePK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bigTitle);
		}
	}

	/**
	 * Returns the number of big titles where articlePK = &#63;.
	 *
	 * @param articlePK the article pk
	 * @return the number of matching big titles
	 */
	@Override
	public int countByArticlePK(long articlePK) {
		FinderPath finderPath = _finderPathCountByArticlePK;

		Object[] finderArgs = new Object[] {articlePK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BIGTITLE_WHERE);

			sb.append(_FINDER_COLUMN_ARTICLEPK_ARTICLEPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articlePK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ARTICLEPK_ARTICLEPK_2 =
		"bigTitle.articlePK = ?";

	private FinderPath _finderPathFetchByB_T;
	private FinderPath _finderPathCountByB_T;

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or throws a <code>NoSuchBigTitleException</code> if it could not be found.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the matching big title
	 * @throws NoSuchBigTitleException if a matching big title could not be found
	 */
	@Override
	public BigTitle findByB_T(long articlePK, String languageId)
		throws NoSuchBigTitleException {

		BigTitle bigTitle = fetchByB_T(articlePK, languageId);

		if (bigTitle == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("articlePK=");
			sb.append(articlePK);

			sb.append(", languageId=");
			sb.append(languageId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBigTitleException(sb.toString());
		}

		return bigTitle;
	}

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the matching big title, or <code>null</code> if a matching big title could not be found
	 */
	@Override
	public BigTitle fetchByB_T(long articlePK, String languageId) {
		return fetchByB_T(articlePK, languageId, true);
	}

	/**
	 * Returns the big title where articlePK = &#63; and languageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching big title, or <code>null</code> if a matching big title could not be found
	 */
	@Override
	public BigTitle fetchByB_T(
		long articlePK, String languageId, boolean useFinderCache) {

		languageId = Objects.toString(languageId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {articlePK, languageId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByB_T, finderArgs, this);
		}

		if (result instanceof BigTitle) {
			BigTitle bigTitle = (BigTitle)result;

			if ((articlePK != bigTitle.getArticlePK()) ||
				!Objects.equals(languageId, bigTitle.getLanguageId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BIGTITLE_WHERE);

			sb.append(_FINDER_COLUMN_B_T_ARTICLEPK_2);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_T_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_B_T_LANGUAGEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articlePK);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				List<BigTitle> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByB_T, finderArgs, list);
					}
				}
				else {
					BigTitle bigTitle = list.get(0);

					result = bigTitle;

					cacheResult(bigTitle);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByB_T, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BigTitle)result;
		}
	}

	/**
	 * Removes the big title where articlePK = &#63; and languageId = &#63; from the database.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the big title that was removed
	 */
	@Override
	public BigTitle removeByB_T(long articlePK, String languageId)
		throws NoSuchBigTitleException {

		BigTitle bigTitle = findByB_T(articlePK, languageId);

		return remove(bigTitle);
	}

	/**
	 * Returns the number of big titles where articlePK = &#63; and languageId = &#63;.
	 *
	 * @param articlePK the article pk
	 * @param languageId the language ID
	 * @return the number of matching big titles
	 */
	@Override
	public int countByB_T(long articlePK, String languageId) {
		languageId = Objects.toString(languageId, "");

		FinderPath finderPath = _finderPathCountByB_T;

		Object[] finderArgs = new Object[] {articlePK, languageId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BIGTITLE_WHERE);

			sb.append(_FINDER_COLUMN_B_T_ARTICLEPK_2);

			boolean bindLanguageId = false;

			if (languageId.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_T_LANGUAGEID_3);
			}
			else {
				bindLanguageId = true;

				sb.append(_FINDER_COLUMN_B_T_LANGUAGEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articlePK);

				if (bindLanguageId) {
					queryPos.add(languageId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_B_T_ARTICLEPK_2 =
		"bigTitle.articlePK = ? AND ";

	private static final String _FINDER_COLUMN_B_T_LANGUAGEID_2 =
		"bigTitle.languageId = ?";

	private static final String _FINDER_COLUMN_B_T_LANGUAGEID_3 =
		"(bigTitle.languageId IS NULL OR bigTitle.languageId = '')";

	public BigTitlePersistenceImpl() {
		setModelClass(BigTitle.class);

		setModelImplClass(BigTitleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the big title in the entity cache if it is enabled.
	 *
	 * @param bigTitle the big title
	 */
	@Override
	public void cacheResult(BigTitle bigTitle) {
		entityCache.putResult(
			entityCacheEnabled, BigTitleImpl.class, bigTitle.getPrimaryKey(),
			bigTitle);

		finderCache.putResult(
			_finderPathFetchByB_T,
			new Object[] {bigTitle.getArticlePK(), bigTitle.getLanguageId()},
			bigTitle);

		bigTitle.resetOriginalValues();
	}

	/**
	 * Caches the big titles in the entity cache if it is enabled.
	 *
	 * @param bigTitles the big titles
	 */
	@Override
	public void cacheResult(List<BigTitle> bigTitles) {
		for (BigTitle bigTitle : bigTitles) {
			if (entityCache.getResult(
					entityCacheEnabled, BigTitleImpl.class,
					bigTitle.getPrimaryKey()) == null) {

				cacheResult(bigTitle);
			}
			else {
				bigTitle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all big titles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BigTitleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the big title.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BigTitle bigTitle) {
		entityCache.removeResult(
			entityCacheEnabled, BigTitleImpl.class, bigTitle.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BigTitleModelImpl)bigTitle, true);
	}

	@Override
	public void clearCache(List<BigTitle> bigTitles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BigTitle bigTitle : bigTitles) {
			entityCache.removeResult(
				entityCacheEnabled, BigTitleImpl.class,
				bigTitle.getPrimaryKey());

			clearUniqueFindersCache((BigTitleModelImpl)bigTitle, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, BigTitleImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BigTitleModelImpl bigTitleModelImpl) {

		Object[] args = new Object[] {
			bigTitleModelImpl.getArticlePK(), bigTitleModelImpl.getLanguageId()
		};

		finderCache.putResult(
			_finderPathCountByB_T, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByB_T, args, bigTitleModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		BigTitleModelImpl bigTitleModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				bigTitleModelImpl.getArticlePK(),
				bigTitleModelImpl.getLanguageId()
			};

			finderCache.removeResult(_finderPathCountByB_T, args);
			finderCache.removeResult(_finderPathFetchByB_T, args);
		}

		if ((bigTitleModelImpl.getColumnBitmask() &
			 _finderPathFetchByB_T.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				bigTitleModelImpl.getOriginalArticlePK(),
				bigTitleModelImpl.getOriginalLanguageId()
			};

			finderCache.removeResult(_finderPathCountByB_T, args);
			finderCache.removeResult(_finderPathFetchByB_T, args);
		}
	}

	/**
	 * Creates a new big title with the primary key. Does not add the big title to the database.
	 *
	 * @param bigTitleId the primary key for the new big title
	 * @return the new big title
	 */
	@Override
	public BigTitle create(long bigTitleId) {
		BigTitle bigTitle = new BigTitleImpl();

		bigTitle.setNew(true);
		bigTitle.setPrimaryKey(bigTitleId);

		bigTitle.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bigTitle;
	}

	/**
	 * Removes the big title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title that was removed
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	@Override
	public BigTitle remove(long bigTitleId) throws NoSuchBigTitleException {
		return remove((Serializable)bigTitleId);
	}

	/**
	 * Removes the big title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the big title
	 * @return the big title that was removed
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	@Override
	public BigTitle remove(Serializable primaryKey)
		throws NoSuchBigTitleException {

		Session session = null;

		try {
			session = openSession();

			BigTitle bigTitle = (BigTitle)session.get(
				BigTitleImpl.class, primaryKey);

			if (bigTitle == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBigTitleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bigTitle);
		}
		catch (NoSuchBigTitleException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BigTitle removeImpl(BigTitle bigTitle) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bigTitle)) {
				bigTitle = (BigTitle)session.get(
					BigTitleImpl.class, bigTitle.getPrimaryKeyObj());
			}

			if (bigTitle != null) {
				session.delete(bigTitle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bigTitle != null) {
			clearCache(bigTitle);
		}

		return bigTitle;
	}

	@Override
	public BigTitle updateImpl(BigTitle bigTitle) {
		boolean isNew = bigTitle.isNew();

		if (!(bigTitle instanceof BigTitleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bigTitle.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bigTitle);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bigTitle proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BigTitle implementation " +
					bigTitle.getClass());
		}

		BigTitleModelImpl bigTitleModelImpl = (BigTitleModelImpl)bigTitle;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bigTitle);

				bigTitle.setNew(false);
			}
			else {
				bigTitle = (BigTitle)session.merge(bigTitle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {bigTitleModelImpl.getArticlePK()};

			finderCache.removeResult(_finderPathCountByArticlePK, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByArticlePK, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((bigTitleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByArticlePK.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					bigTitleModelImpl.getOriginalArticlePK()
				};

				finderCache.removeResult(_finderPathCountByArticlePK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticlePK, args);

				args = new Object[] {bigTitleModelImpl.getArticlePK()};

				finderCache.removeResult(_finderPathCountByArticlePK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticlePK, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, BigTitleImpl.class, bigTitle.getPrimaryKey(),
			bigTitle, false);

		clearUniqueFindersCache(bigTitleModelImpl, false);
		cacheUniqueFindersCache(bigTitleModelImpl);

		bigTitle.resetOriginalValues();

		return bigTitle;
	}

	/**
	 * Returns the big title with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the big title
	 * @return the big title
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	@Override
	public BigTitle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBigTitleException {

		BigTitle bigTitle = fetchByPrimaryKey(primaryKey);

		if (bigTitle == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBigTitleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bigTitle;
	}

	/**
	 * Returns the big title with the primary key or throws a <code>NoSuchBigTitleException</code> if it could not be found.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title
	 * @throws NoSuchBigTitleException if a big title with the primary key could not be found
	 */
	@Override
	public BigTitle findByPrimaryKey(long bigTitleId)
		throws NoSuchBigTitleException {

		return findByPrimaryKey((Serializable)bigTitleId);
	}

	/**
	 * Returns the big title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bigTitleId the primary key of the big title
	 * @return the big title, or <code>null</code> if a big title with the primary key could not be found
	 */
	@Override
	public BigTitle fetchByPrimaryKey(long bigTitleId) {
		return fetchByPrimaryKey((Serializable)bigTitleId);
	}

	/**
	 * Returns all the big titles.
	 *
	 * @return the big titles
	 */
	@Override
	public List<BigTitle> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BigTitle> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<BigTitle> findAll(
		int start, int end, OrderByComparator<BigTitle> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<BigTitle> findAll(
		int start, int end, OrderByComparator<BigTitle> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<BigTitle> list = null;

		if (useFinderCache) {
			list = (List<BigTitle>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BIGTITLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BIGTITLE;

				sql = sql.concat(BigTitleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BigTitle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the big titles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BigTitle bigTitle : findAll()) {
			remove(bigTitle);
		}
	}

	/**
	 * Returns the number of big titles.
	 *
	 * @return the number of big titles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BIGTITLE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "bigTitleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BIGTITLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BigTitleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the big title persistence.
	 */
	@Activate
	public void activate() {
		BigTitleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		BigTitleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BigTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BigTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByArticlePK = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BigTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticlePK",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByArticlePK = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BigTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticlePK",
			new String[] {Long.class.getName()},
			BigTitleModelImpl.ARTICLEPK_COLUMN_BITMASK);

		_finderPathCountByArticlePK = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticlePK",
			new String[] {Long.class.getName()});

		_finderPathFetchByB_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BigTitleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByB_T",
			new String[] {Long.class.getName(), String.class.getName()},
			BigTitleModelImpl.ARTICLEPK_COLUMN_BITMASK |
			BigTitleModelImpl.LANGUAGEID_COLUMN_BITMASK);

		_finderPathCountByB_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_T",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(BigTitleImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = BIGTITLEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.samples.fbo.big.titles.model.BigTitle"),
			true);
	}

	@Override
	@Reference(
		target = BIGTITLEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BIGTITLEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BIGTITLE =
		"SELECT bigTitle FROM BigTitle bigTitle";

	private static final String _SQL_SELECT_BIGTITLE_WHERE =
		"SELECT bigTitle FROM BigTitle bigTitle WHERE ";

	private static final String _SQL_COUNT_BIGTITLE =
		"SELECT COUNT(bigTitle) FROM BigTitle bigTitle";

	private static final String _SQL_COUNT_BIGTITLE_WHERE =
		"SELECT COUNT(bigTitle) FROM BigTitle bigTitle WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bigTitle.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BigTitle exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BigTitle exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BigTitlePersistenceImpl.class);

	static {
		try {
			Class.forName(BIGTITLEPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}