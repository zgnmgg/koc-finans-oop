CREATE TABLE IF NOT EXISTS user_account (
    id SERIAL NOT NULL,
    email varchar (222) NOT NULL,
    password varchar (222) NOT NULL,
    full_name varchar (222) NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    type varchar(20) NOT NULL
);

ALTER TABLE ONLY user_account ADD CONSTRAINT user_account_pkey PRIMARY KEY (id);

CREATE TABLE IF NOT EXISTS user_client (
    user_account_id SERIAL NOT NULL,
    gender varchar(6),
    phone_number varchar(200),
    company_name varchar(200),
    address varchar(200),
    birth_date timestamp ,
    is_enable boolean NOT NULL DEFAULT false
    );

ALTER TABLE ONLY user_client ADD CONSTRAINT user_client_pkey PRIMARY KEY (user_account_id);

ALTER TABLE ONLY user_client
    ADD CONSTRAINT user_client_user_account_id_fkey FOREIGN KEY (user_account_id) REFERENCES user_account(id) ON UPDATE CASCADE ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS user_admin (
    user_account_id SERIAL NOT NULL,
    company_id int NOT NULL,
    is_enable boolean NOT NULL DEFAULT true
);
ALTER TABLE ONLY user_admin ADD CONSTRAINT user_admin_pkey PRIMARY KEY (user_account_id);

ALTER TABLE ONLY user_admin
    ADD CONSTRAINT user_admin_user_account_id_fkey FOREIGN KEY (user_account_id) REFERENCES user_account(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY user_admin
    ADD CONSTRAINT user_admin_company_id_fkey FOREIGN KEY (company_id) REFERENCES company(id) ON UPDATE CASCADE ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS company (
    id SERIAL NOT NULL,
    brand_name varchar (222) NOT NULL,
    logo_url varchar (222) NOT NULL,
    is_enable boolean NOT NULL DEFAULT false,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    name varchar (222) NOT NULL,
    website varchar (222) NOT NULL,
    business_phone varchar (222) NOT NULL,
    address varchar (222) NOT NULL,
    about varchar (222) NOT NULL
);

ALTER TABLE ONLY company ADD CONSTRAINT company_pkey PRIMARY KEY (id);

CREATE TABLE IF NOT EXISTS menu (
    id SERIAL NOT NULL,
    company_id int NOT NULL,
    name varchar (222) NOT NULL,
    image_url varchar (222) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL
);

ALTER TABLE ONLY menu ADD CONSTRAINT menu_pkey PRIMARY KEY (id);

ALTER TABLE ONLY menu
    ADD CONSTRAINT menu_company_id_fkey FOREIGN KEY (company_id) REFERENCES company(id) ON UPDATE CASCADE ON DELETE CASCADE;


CREATE TABLE IF NOT EXISTS client_order (
    id SERIAL NOT NULL,
    menu_id int NOT NULL,
    user_client_id int NOT NULL,
    payment_method varchar (25) NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL
    );

ALTER TABLE ONLY client_order ADD CONSTRAINT client_order_pkey PRIMARY KEY (id);

ALTER TABLE ONLY client_order
    ADD CONSTRAINT client_order_menu_id_fkey FOREIGN KEY (menu_id) REFERENCES menu(id);
ALTER TABLE ONLY client_order
    ADD CONSTRAINT client_order_user_client_id_fkey FOREIGN KEY (user_client_id) REFERENCES user_client(user_account_id);
