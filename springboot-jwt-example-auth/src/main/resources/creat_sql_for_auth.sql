CREATE TABLE `oauth_client_details` (
  `client_id` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `resource_ids` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_secret` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `scope` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authorized_grant_types` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authorities` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) COLLATE utf8_unicode_ci DEFAULT NULL,
  `autoapprove` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO oauth_client_details
(
	client_id, 
	client_secret,
	resource_ids, 
	scope, 
	authorized_grant_types, 
	web_server_redirect_uri, 
	authorities, 
	access_token_validity, 
	refresh_token_validity, 
	additional_information, 
	autoapprove
)
VALUES
(
	'client1',
	'client1pwd',
	null, 
	'read,write', 
	'authorization_code,password, implicit, refresh_token',
	null,
	'ROLE_YOUR_CLIENT',
	36000,
	2592000,
	null,
	null
);


INSERT INTO oauth_client_details
(
	client_id, 
	client_secret,
	resource_ids, 
	scope, 
	authorized_grant_types, 
	web_server_redirect_uri, 
	authorities, 
	access_token_validity, 
	refresh_token_validity, 
	additional_information, 
	autoapprove
)
VALUES
(
	'client2',
	'client2pwd',
	null, 
	'read', 
	'authorization_code,password, implicit, refresh_token',
	null,
	'ROLE_YOUR_CLIENT',
	36000,
	2592000,
	null,
	null
);
