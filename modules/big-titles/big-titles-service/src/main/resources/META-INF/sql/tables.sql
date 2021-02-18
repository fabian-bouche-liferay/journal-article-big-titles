create table BIGTITLE_BigTitle (
	bigTitleId LONG not null primary key,
	companyId LONG,
	articlePK LONG,
	title STRING null,
	languageId VARCHAR(75) null
);