package com.liferay.samples.fbo.journal.localization.override;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.samples.fbo.big.titles.model.BigTitle;
import com.liferay.samples.fbo.big.titles.service.BigTitleLocalService;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
	    immediate = true,
	    property = {
	    },
	    service = ServiceWrapper.class
	)
public class JournalArticleLocalServiceOverride extends JournalArticleLocalServiceWrapper {

	private static final int MAX_TITLE_LENGTH = 400;
	private static final int MAX_BIG_TITLE_LENGTH = 4000;
	
	private static final Logger LOG = LoggerFactory.getLogger(JournalArticleLocalServiceOverride.class);
	
    public JournalArticleLocalServiceOverride() {
        super(null);
    }
    
    @Override
    public JournalArticle addArticle(long userId, long groupId, long folderId, long classNameId, long classPK,
    		String articleId, boolean autoArticleId, double version, Map<Locale, String> titleMap,
    		Map<Locale, String> descriptionMap, Map<Locale, String> friendlyURLMap, String content,
    		String ddmStructureKey, String ddmTemplateKey, String layoutUuid, int displayDateMonth, int displayDateDay,
    		int displayDateYear, int displayDateHour, int displayDateMinute, int expirationDateMonth,
    		int expirationDateDay, int expirationDateYear, int expirationDateHour, int expirationDateMinute,
    		boolean neverExpire, int reviewDateMonth, int reviewDateDay, int reviewDateYear, int reviewDateHour,
    		int reviewDateMinute, boolean neverReview, boolean indexable, boolean smallImage, String smallImageURL,
    		File smallImageFile, Map<String, byte[]> images, String articleURL, ServiceContext serviceContext)
    		throws PortalException {

    	Map<Locale, String> bigTitles = getLongTitles(titleMap);

    	JournalArticle newArticle = super.addArticle(userId, groupId, folderId, classNameId, classPK, articleId, autoArticleId, version, titleMap,
    			descriptionMap, friendlyURLMap, content, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth,
    			displayDateDay, displayDateYear, displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay,
    			expirationDateYear, expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay,
    			reviewDateYear, reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL,
    			smallImageFile, images, articleURL, serviceContext);
    	
    	saveLongTitles(bigTitles, newArticle.getId(), serviceContext.getCompanyId());
    	
    	return newArticle;
    }

    @Override
    public JournalArticle updateArticle(long userId, long groupId, long folderId, String articleId, double version,
    		Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, Map<Locale, String> friendlyURLMap,
    		String content, String ddmStructureKey, String ddmTemplateKey, String layoutUuid, int displayDateMonth,
    		int displayDateDay, int displayDateYear, int displayDateHour, int displayDateMinute,
    		int expirationDateMonth, int expirationDateDay, int expirationDateYear, int expirationDateHour,
    		int expirationDateMinute, boolean neverExpire, int reviewDateMonth, int reviewDateDay, int reviewDateYear,
    		int reviewDateHour, int reviewDateMinute, boolean neverReview, boolean indexable, boolean smallImage,
    		String smallImageURL, File smallImageFile, Map<String, byte[]> images, String articleURL,
    		ServiceContext serviceContext) throws PortalException {

    	Map<Locale, String> bigTitles = getLongTitles(titleMap);

    	JournalArticle article = super.updateArticle(userId, groupId, folderId, articleId, version, titleMap, descriptionMap, friendlyURLMap,
    			content, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay, displayDateYear,
    			displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear,
    			expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear,
    			reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallImageFile, images,
    			articleURL, serviceContext);

    	saveLongTitles(bigTitles, article.getId(), serviceContext.getCompanyId());

    	return article;
    }
    
    @Override
    public String getArticleTitle(long articlePK, Locale locale) {

    	LOG.debug("Looking for long title with locale {}", locale.getLanguage());

    	String title = super.getArticleTitle(articlePK, locale);
    	if(title != null && title.length() >= MAX_TITLE_LENGTH) {

    		LOG.debug("Long title");

    		BigTitle bigTitle = _bigTitleLocalService.getBigTitle(articlePK, locale.getLanguage());
    		if(bigTitle != null) {
    			title = _bigTitleLocalService.getBigTitle(articlePK, locale.getLanguage()).getTitle();
    		} else {
    			LOG.warn("No big title found!");
    		}
    	}
    	return title;
    }
    
    @Override
    public Map<Locale, String> getArticleTitleMap(long articlePK) {
    
    	LOG.debug("Looking for long titles");
    	
    	Map<Locale, String> titleMap = super.getArticleTitleMap(articlePK);
    	
    	titleMap.forEach((locale, title) -> {
    		
        	if(title != null && title.length() >= MAX_TITLE_LENGTH) {

        		LOG.debug("Long title");

        		BigTitle bigTitle = _bigTitleLocalService.getBigTitle(articlePK, locale.getLanguage());
        		if(bigTitle != null) {
        			title = _bigTitleLocalService.getBigTitle(articlePK, locale.getLanguage()).getTitle();
        			titleMap.put(locale, title);
        		} else {
        			LOG.warn("No big title found!");
        		}
        	}    		
    		
    	});
    	
    	return titleMap;
    }
    
    private void saveLongTitles(Map<Locale, String> bigTitles, long articlePK, long companyId) {
    	
    	bigTitles.forEach((locale, title) -> {
    		
    		_bigTitleLocalService.upsertBigTitle(companyId, articlePK, locale.getLanguage(), title);
    		
    	});
    	
	}

	private Map<Locale, String> getLongTitles(Map<Locale, String> titleMap) {
    	
    	Map<Locale, String> bigTitles = new HashMap<>();
    	
    	titleMap.forEach((locale, title) -> {
    		
    		if(title != null) {
        		if(title.length() >= MAX_TITLE_LENGTH) {
        			LOG.debug("Found big title < {} > for locale {}", title, locale.getLanguage());
        			if(title.length() >= MAX_BIG_TITLE_LENGTH) {
            			LOG.debug("Truncating to {} characters because length is {}", MAX_BIG_TITLE_LENGTH, title.length());
        				title = title.substring(0, MAX_BIG_TITLE_LENGTH);
        			}
        			bigTitles.put(locale, title);
        			title = title.substring(0, MAX_TITLE_LENGTH);
        			titleMap.put(locale, title);
        		}
    		}
    		
    	});
    	
    	return bigTitles;
    }
	
	@Reference
	private BigTitleLocalService _bigTitleLocalService;
	
}
