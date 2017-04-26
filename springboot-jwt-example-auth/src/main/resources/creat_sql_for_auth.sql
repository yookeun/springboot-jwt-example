use test_tb;

create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
) ROW_FORMAT=DYNAMIC;


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



insert into user(user_name, password, user_type, reg_date) values('user1','$2a$10$oXhcs6qujNbFA5yXauupSuWLQpMjVbAskvPbMvcUzurpsdIuSXs7m','2',now())
